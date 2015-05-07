package ch.hslu.mobpro.youoweme.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

import ch.hslu.mobpro.youoweme.database.Debt;
import ch.hslu.mobpro.youoweme.database.AsyncTasks.GetDebtTask;
import ch.hslu.mobpro.youoweme.database.Person;
import ch.hslu.mobpro.youoweme.service.personhandling.PersonAuthenticator;


public class MainActivity extends ActionBarActivity {

    PersonAuthenticator personAuthenticator;
    EditText edittxtUsername;
    EditText edittxtPassword;
    CheckBox checkBoxRememberMe;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personAuthenticator = PersonAuthenticator.getInstance();
        edittxtPassword = (EditText) findViewById(R.id.edittxtPassword);
        edittxtUsername = (EditText) findViewById(R.id.edittxtUsername);
        checkBoxRememberMe = (CheckBox) findViewById(R.id.checkBoxRememberMe);
        preferences = getPreferences(MODE_PRIVATE);
        String username = preferences.getString("txtUsernameText", "");
        String password = preferences.getString("txtPasswordText", "");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBtnLoginClicked(View view) {
        Person person = new Person();
        person.seteMailAddress(String.valueOf(edittxtUsername.getText()));
        person.setPassword(String.valueOf(edittxtPassword.getText()));
        try {
            if (personAuthenticator.authenticate(person) > 0) {
                if (checkBoxRememberMe.isChecked()) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("txtUsernameText", String.valueOf(edittxtUsername.getText()));
                    editor.putString("txtPasswordText", String.valueOf(edittxtPassword.getText()));
                    editor.apply();
                }
                //Intent intent = new Intent(getApplicationContext(), DebtActivity.class);
                //startActivity(intent);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void onCreateUserClick(View view) {
        Intent intent = new Intent(this, UserCreationActivity.class);
        startActivity(intent);
    }
}
