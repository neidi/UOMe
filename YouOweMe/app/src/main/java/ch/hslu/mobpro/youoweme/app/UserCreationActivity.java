package ch.hslu.mobpro.youoweme.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import ch.hslu.mobpro.youoweme.database.Person;


public class UserCreationActivity extends ActionBarActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText firstNameEditText;
    private EditText lastNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.emailEditText = (EditText) findViewById(R.id.emailEditText);
        this.passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        this.firstNameEditText = (EditText) findViewById(R.id.firstNameEditText);
        this.lastNameEditText = (EditText) findViewById(R.id.lastNameEditText);

        setContentView(R.layout.activity_user_creation);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_creation, menu);
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

    public void onCreateAccountButtonClicked(View view){
        Person person = new Person();
        person.seteMailAddress(String.valueOf(this.emailEditText.getText()));
        person.setPassword(String.valueOf(this.passwordEditText));
        person.setFirstName(String.valueOf(this.firstNameEditText));
        person.setLastName(String.valueOf(this.lastNameEditText));
    }
}
