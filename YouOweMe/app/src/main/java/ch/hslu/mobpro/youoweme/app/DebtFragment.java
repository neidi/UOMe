package ch.hslu.mobpro.youoweme.app;

/**
 * Created by simonneidhart on 08.05.15.
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import ch.hslu.mobpro.youoweme.database.Debt;
import ch.hslu.mobpro.youoweme.database.EntityListGetterImpl;
import ch.hslu.mobpro.youoweme.service.personhandling.PersonAuthenticator;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class DebtFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static DebtFragment newInstance(int sectionNumber) {
        DebtFragment fragment = new DebtFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public DebtFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (getArguments().getInt(ARG_SECTION_NUMBER) == 0) {
            View rootView = inflater.inflate(R.layout.fragment_credit_list, container, false);
            System.out.println(getActivity());
            Debt[] debtsArray = new Debt[0];
            List<Debt> debts = new EntityListGetterImpl().getDebtList();

            List<Debt> debtsToRemove = new ArrayList<Debt>();
            for (int i = 0; i < debts.size(); i++) {
                if (debts.get(i).getCreditor() != PersonAuthenticator.getAuthenticationId()) {
                    debtsToRemove.add(debts.get(i));
                }
            }
            for (int i = 0; i < debtsToRemove.size(); i++) {
                debts.remove(debtsToRemove.get(i));
            }
            debtsArray = debts.toArray(debtsArray);
            MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(getActivity(), debtsArray);
            ListView listView = (ListView) rootView.findViewById(R.id.debtList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Toast.makeText(getActivity(),
                            ((Debt) adapterView.getItemAtPosition(position)).getReason(),
                            Toast.LENGTH_SHORT).show();
                }
            });
            try {
                listView.setAdapter(adapter);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return rootView;
        } else {
            View rootView = inflater.inflate(R.layout.fragment_debit_list, container, false);
            System.out.println(getActivity());
            Debt[] debtsArray = new Debt[0];
            List<Debt> debts = new EntityListGetterImpl().getDebtList();
            List<Debt> debtsToRemove = new ArrayList<Debt>();
            for (int i = 0; i < debts.size(); i++) {
                if (debts.get(i).getDebitor() != PersonAuthenticator.getAuthenticationId()) {
                    debtsToRemove.add(debts.get(i));
                }
            }
            for (int i = 0; i < debtsToRemove.size(); i++) {
                debts.remove(debtsToRemove.get(i));
            }
            debtsArray = debts.toArray(debtsArray);
            MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(getActivity(), debtsArray);
            ListView listView = (ListView) rootView.findViewById(R.id.debtList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    DeleteDebtDialog deleteDebtDialog = new DeleteDebtDialog();
                    deleteDebtDialog.show(getActivity().getSupportFragmentManager(), "");
                    if (deleteDebtDialog.getResult()) {
                        Toast.makeText(getActivity(),
                                ((Debt) adapterView.getItemAtPosition(position)).getReason(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
            try {
                listView.setAdapter(adapter);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return rootView;
        }
    }
}

