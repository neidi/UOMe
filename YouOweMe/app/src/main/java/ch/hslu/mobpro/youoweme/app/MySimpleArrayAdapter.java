package ch.hslu.mobpro.youoweme.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import ch.hslu.mobpro.youoweme.database.Debt;

/**
 * Created by simonneidhart on 08.05.15.
 */
public class MySimpleArrayAdapter extends ArrayAdapter<Debt> {
    private final Context context;
    private final Debt[] values;

    public MySimpleArrayAdapter(Context context, Debt[] values) {
        super(context, R.layout.fragment_debt_list_item, values);
        this.context = context;
        this.values = values;
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
        idOfDebt.setText(debt.getId());
        otherPerson.setText(debt.getDebitor().geteMailAddress());
        amount.setText(String.valueOf(debt.getAmount()));
        debtInformationLine.setText("Fällig am: " + String.valueOf(debt.getDueDate()));
        return rowView;
    }
}
