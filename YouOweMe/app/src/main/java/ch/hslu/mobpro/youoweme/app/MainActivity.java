package ch.hslu.mobpro.youoweme.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import ch.hslu.mobpro.youoweme.database.Person;
import ch.hslu.mobpro.youoweme.service.personhandling.PersonFacade;
import ch.hslu.mobpro.youoweme.service.personhandling.PersonFacadeImpl;


public class MainActivity extends ActionBarActivity {

    PersonFacade personFacade;
    EditText edittxtUsername;
    EditText edittxtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personFacade = new PersonFacadeImpl();
        edittxtPassword = (EditText) findViewById(R.id.edittxtPassword);
        edittxtUsername = (EditText) findViewById(R.id.edittxtUsername);
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
        if(personFacade.authenticate(person)>0){
            Intent intent = new Intent(getApplicationContext(), CreditorActivity.class);
            startActivity(intent);
        }
    }


    public void onCreateUserClick(View view) {
        Intent intent = new Intent(this.getApplicationContext(), UserCreationActivity.class);
        startActivity(intent);
    }
}
