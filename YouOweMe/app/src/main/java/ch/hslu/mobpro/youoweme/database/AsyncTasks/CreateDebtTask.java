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
public class CreateDebtTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
        try {
            ArrayList<NameValuePair> nameValuePairArrayList = new ArrayList();

            nameValuePairArrayList.add(new BasicNameValuePair("creationDate", params[0]));
            nameValuePairArrayList.add(new BasicNameValuePair("dueDate", params[1]));
            nameValuePairArrayList.add(new BasicNameValuePair("amount", params[2]));
            nameValuePairArrayList.add(new BasicNameValuePair("creditor_id", params[3]));
            nameValuePairArrayList.add(new BasicNameValuePair("debitor_id", params[4]));
            nameValuePairArrayList.add(new BasicNameValuePair("reason", params[5]));


            String dblink = "http://10.177.1.183/mobprophp/createdebt.php";

            URL url = new URL(dblink);
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
