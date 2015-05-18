package ch.hslu.mobpro.youoweme.database.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by livio on 03.05.2015.
 */
public class CreateUserTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
        try {
            ArrayList<NameValuePair> nameValuePairArrayList = new ArrayList();

            nameValuePairArrayList.add(new BasicNameValuePair("firstname", params[0]));
            nameValuePairArrayList.add(new BasicNameValuePair("lastname", params[1]));
            nameValuePairArrayList.add(new BasicNameValuePair("email", params[2]));
            nameValuePairArrayList.add(new BasicNameValuePair("password", params[3]));


            String dblink = "http://10.177.1.183/createperson.php";

            HttpClient client = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(dblink);
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairArrayList));
            HttpResponse response = client.execute(httpPost);

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            Log.d("InsertStatementPerson", "Erfolgreich" + response);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
