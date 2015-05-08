package ch.hslu.mobpro.youoweme.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by simonneidhart on 08.05.15.
 */
public class DeleteDebtDialog extends DialogFragment {
    private boolean result;

    public boolean getResult(){
        return result;
    }
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.really_delete_debt)
                .setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        result = true;
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        result = false;
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}