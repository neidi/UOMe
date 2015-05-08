package ch.hslu.mobpro.youoweme.app;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import ch.hslu.mobpro.youoweme.database.Debt;
import ch.hslu.mobpro.youoweme.database.EntityListGetterImpl;
import ch.hslu.mobpro.youoweme.database.Person;

/**
 * Created by simonneidhart on 08.05.15.
 */
public class MySimpleArrayAdapter extends ArrayAdapter<Debt> {
    private final Context context;
    private final Debt[] values;
    private boolean isCreditor;

    public MySimpleArrayAdapter(Context context, Debt[] values, boolean isCreditor) {
        super(context, R.layout.fragment_debt_list_item, values);
        this.context = context;
        this.values = values;
        this.isCreditor = isCreditor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.fragment_debt_list_item, parent, false);
        TextView idOfDebt = (TextView) rowView.findViewById(R.id.idOfDebt);
        TextView otherPerson = (TextView) rowView.findViewById(R.id.otherPerson);
        TextView amount = (TextView) rowView.findViewById(R.id.debtAmount);
        TextView debtInformationLine = (TextView) rowView.findViewById(R.id.debtInformationLine);

        Debt debt = values[position];
        if(debt.isMarkedAsDeleted()){
            rowView.setBackgroundColor(Color.RED);
        }
        idOfDebt.setText(String.valueOf(debt.getId()));
        for (Person person : new EntityListGetterImpl().getPersonList()) {
            if (isCreditor) {
                if (person.getId() == debt.getDebitor()) {
                    otherPerson.setText(person.geteMailAddress());
                }
            } else {
                if (person.getId() == debt.getCreditor()) {
                    otherPerson.setText(person.geteMailAddress());
                }
            }
        }
        amount.setText(String.valueOf(debt.getAmount()));
        debtInformationLine.setText("Fällig am: " + String.valueOf(debt.getDueDate()));
        return rowView;
    }
}
