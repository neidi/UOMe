package ch.hslu.mobpro.youoweme.app;

/**
 * Created by simonneidhart on 08.05.15.
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import ch.hslu.mobpro.youoweme.database.Debt;
import ch.hslu.mobpro.youoweme.database.EntityListGetterImpl;

/**
 * A placeholder fragment containing a simple view.
 */
public class CreditorFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static CreditorFragment newInstance(int sectionNumber) {
        CreditorFragment fragment = new CreditorFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public CreditorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_credit_list, container, false);
        System.out.println(getActivity());
        Debt[] debts = (Debt[]) new EntityListGetterImpl().getDebtList().toArray();
        MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(getActivity(), debts);
        ListView listView = (ListView) getView().findViewById(R.id.debtList);
        listView.setAdapter(adapter);
        return rootView;
    }
}

