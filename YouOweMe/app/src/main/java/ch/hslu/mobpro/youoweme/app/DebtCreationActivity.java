package ch.hslu.mobpro.youoweme.app;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ch.hslu.mobpro.youoweme.database.Debt;
import ch.hslu.mobpro.youoweme.database.EntityListGetter;
import ch.hslu.mobpro.youoweme.database.EntityListGetterImpl;
import ch.hslu.mobpro.youoweme.database.Person;
import ch.hslu.mobpro.youoweme.service.debthandling.DebtCreator;
import ch.hslu.mobpro.youoweme.service.personhandling.PersonAuthenticator;

/**
 * Created by livio on 07.05.2015.
 */
public class DebtCreationActivity extends ActionBarActivity implements View.OnClickListener {

    private DebtCreator debtCreator;
    private EditText userEditText;
    private EditText amountEditText;
    private EditText reasonEditText;
    private EditText datePickerEditText;
    private DatePickerDialog datePickerDialog;
    private Calendar c;
    private SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_debt_creation);

         c = Calendar.getInstance();

        userEditText = (EditText) findViewById(R.id.userEditText);
        amountEditText = (EditText) findViewById(R.id.amountEditText);
        reasonEditText = (EditText) findViewById(R.id.reasonEditText);
        datePickerEditText = (EditText) findViewById(R.id.datePickerEditText);

        datePickerEditText.setOnClickListener(this);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                datePickerEditText.setText(simpleDateFormat.format(newDate.getTime()));
            }
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    public void onCreateDebtClicked(View view) {
        try{
            debtCreator = DebtCreator.getInstance();
            Debt debt = new Debt();
            debt.setReason(reasonEditText.getText().toString());

            debt.setCreditor(PersonAuthenticator.getAuthenticationId());
            EntityListGetter entityListGetter = new EntityListGetterImpl();
            for(Person person : entityListGetter.getPersonList()){
                if(person.geteMailAddress().equals(userEditText.getText().toString())){
                    debt.setDebitor(person.getId());
                }
            }

            debt.setCreditor(PersonAuthenticator.getAuthenticationId());
            debt.setCreationDate(c.getTime());
            Date date = simpleDateFormat.parse(datePickerEditText.getText().toString());
            debt.setDueDate(simpleDateFormat.parse(datePickerEditText.getText().toString()));
            debt.setAmount(Integer.parseInt(amountEditText.getText().toString()));


            debtCreator.createDebt(debt);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }



    @Override
    public void onClick(View v) {
        datePickerDialog.show();
    }
}
