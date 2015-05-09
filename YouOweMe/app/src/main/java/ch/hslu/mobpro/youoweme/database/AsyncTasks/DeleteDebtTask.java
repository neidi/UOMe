package ch.hslu.mobpro.youoweme.database.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by livio on 05.05.2015.
 */
public class DeleteDebtTask extends AsyncTask<Integer, Void, String> {
    @Override
    protected String doInBackground(Integer... params) {
        try {
            ArrayList<NameValuePair> nameValuePairArrayList = new ArrayList();

            nameValuePairArrayList.add(new BasicNameValuePair("id", params[0].toString()));

            String dblink = "http://10.177.1.183/mobprophp/deletedebt.php";

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
