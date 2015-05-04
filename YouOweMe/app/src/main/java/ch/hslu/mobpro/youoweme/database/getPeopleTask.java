package ch.hslu.mobpro.youoweme.database;

import android.os.AsyncTask;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;

/**
 * Created by livio on 03.05.2015.
 */
public class getPeopleTask extends AsyncTask<String, Void, ArrayList<Person>> {

    @Override
    protected ArrayList<Person> doInBackground(String... params) {

    try {
        String dblink = "http://10.177.1.183/mobprophp/getpeople.php";

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(dblink);

        HttpResponse response = httpclient.execute(httppost);

        String jsonResult = inputStreamToString(
                response.getEntity().getContent()).toString();

        JSONObject jsonObject = new JSONObject(jsonResult);

        JSONArray jsonArray = jsonObject.getJSONArray("id");

        ArrayList<Person> arrayList = new ArrayList();

        for(int i=0;i < jsonArray.length();i++){
            JSONObject c = jsonArray.getJSONObject(i);
            Person person = new Person();
            person.setId(c.getInt("id"));
            person.setFirstName(c.getString("lastName"));
            person.setLastName(c.getString("firstName"));
            person.seteMailAddress(c.getString("emailAddress"));
            person.setPassword(c.getString("password"));

            arrayList.add(person);


        }
        return arrayList;

    }catch(Exception ex){
        ex.printStackTrace();
        System.out.println(ex.getMessage());
    }
        return null;
    }

    private StringBuilder inputStreamToString(InputStream is) {
        String rLine = "";
        StringBuilder answer = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));

        try {
            while ((rLine = rd.readLine()) != null) {
                answer.append(rLine);
            }
        }

        catch (IOException e) {
            e.printStackTrace();

        }
        return answer;
    }

}
