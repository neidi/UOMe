package ch.hslu.mobpro.youoweme.database;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by livio on 03.05.2015.
 */
public class CreateUserTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
        try {
            String firstname = "Livio";
            String lastname = "Kunzic";
            String username = params[0];
            String password = params[1];

            String dblink = "http://mobpro2015.byethost16.com/createuser.php?firstname=" + firstname + "lastname=" + lastname+ "username=" + username + "&password=" + password;

            URL url = new URL(dblink);
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(dblink));
            HttpResponse response = client.execute(request);



        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
