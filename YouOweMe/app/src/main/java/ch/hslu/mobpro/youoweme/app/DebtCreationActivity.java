package ch.hslu.mobpro.youoweme.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import ch.hslu.mobpro.youoweme.database.Debt;
import ch.hslu.mobpro.youoweme.service.debthandling.DebtCreator;

/**
 * Created by livio on 07.05.2015.
 */
public class DebtCreationActivity extends ActionBarActivity {

    private DebtCreator debtCreator;
    private EditText userEditText;
    private EditText amountEditText;
    private EditText reasonEditText;
    private EditText datePickerEditText;


    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_debt_creation);

        userEditText = (EditText) findViewById(R.id.userEditText);
        amountEditText = (EditText) findViewById(R.id.amountEditText);
        reasonEditText = (EditText) findViewById(R.id.reasonEditText);
        datePickerEditText = (EditText) findViewById(R.id.datePickerEditText);

    }

    public void onCreateDebtClicked(View view) {
        debtCreator = DebtCreator.getInstance();
        Debt debt = new Debt();
        debt.setReason(reasonEditText.getText().toString());

        //ToDo: Get current user and username to person
      //  debt.setDebitor(userEditText.getText().toString());
       // debt.setCreditor("currentUser");

        Date date = new Date();
        //debt.setCreationDate(date.);

        // debtCreator.createDebt()
    }
}
