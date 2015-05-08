package ch.hslu.mobpro.youoweme.app;

/**
 * Created by simonneidhart on 08.05.15.
 */


import android.app.AlertDialog;
import android.content.DialogInterface;
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
import ch.hslu.mobpro.youoweme.database.EntityPerIdDeleterImp;
import ch.hslu.mobpro.youoweme.service.debthandling.DebtDeleter;
import ch.hslu.mobpro.youoweme.service.debthandling.DebtReader;
import ch.hslu.mobpro.youoweme.service.personhandling.PersonAuthenticator;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment containing debts or credits
 */
public class DebtFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private DebtReader debtReader;

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
        View rootView;
        debtReader = DebtReader.getInstance();
        Debt[] debtsArray = new Debt[0];
        List<Debt> debts = debtReader.readDebts();
        List<Debt> debtsToRemove = new ArrayList<Debt>();
        final String dialogString;
        if (getArguments().getInt(ARG_SECTION_NUMBER) == 0) {
            dialogString = "gelöscht";
            rootView = inflater.inflate(R.layout.fragment_credit_list, container, false);
            for (int i = 0; i < debts.size(); i++) {
                if (debts.get(i).getCreditor() != PersonAuthenticator.getAuthenticationId()) {
                    debtsToRemove.add(debts.get(i));
                }
            }
        } else {
            dialogString = "zum löschen freigegeben";
            rootView = inflater.inflate(R.layout.fragment_debit_list, container, false);
            System.out.println(getActivity());
            for (int i = 0; i < debts.size(); i++) {
                if (debts.get(i).getDebitor() != PersonAuthenticator.getAuthenticationId()) {
                    debtsToRemove.add(debts.get(i));
                }
            }

        }
        for (int i = 0; i < debtsToRemove.size(); i++) {
            debts.remove(debtsToRemove.get(i));
        }
        debtsArray = debts.toArray(debtsArray);
        MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(getActivity(), debtsArray, getArguments().getInt(ARG_SECTION_NUMBER) == 0);
        ListView listView = (ListView) rootView.findViewById(R.id.debtList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setMessage(R.string.really_delete_debt)
                        .setTitle(R.string.really_delete_debt);

                builder.setPositiveButton("löschen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(),
                                "Schuld mit dem Grund "
                                        + ((Debt) adapterView.getItemAtPosition(position)).getReason()
                                        + dialogString,
                                Toast.LENGTH_SHORT).show();
                        DebtDeleter debtDeleter = DebtDeleter.getInstance();
                        if (getArguments().getInt(ARG_SECTION_NUMBER) == 0) {
                            debtDeleter.deleteDebt(((Debt) adapterView.getItemAtPosition(position)).getId());
                        } else {
                            debtDeleter.markDebtAsDeleted(((Debt) adapterView.getItemAtPosition(position)).getId());
                        }
                    }
                });

                AlertDialog deleteDebtDialog = builder.create();
                deleteDebtDialog.show();

            }
        });
        listView.setAdapter(adapter);
        return rootView;
    }
}

