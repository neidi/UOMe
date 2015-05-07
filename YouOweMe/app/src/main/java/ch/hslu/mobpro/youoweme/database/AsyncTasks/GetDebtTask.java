package ch.hslu.mobpro.youoweme.database.AsyncTasks;

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
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ch.hslu.mobpro.youoweme.database.Debt;
import ch.hslu.mobpro.youoweme.database.Person;

/**
 * Created by livio on 04.05.2015.
 */
public class GetDebtTask extends AsyncTask<String, Void, ArrayList<Debt>> {

        @Override
        protected ArrayList<Debt> doInBackground(String... params) {

            try {
                String dblink = "http://10.177.1.183/mobprophp/getdebt.php";

                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(dblink);

                HttpResponse response = httpclient.execute(httppost);

                String jsonResult = inputStreamToString(
                        response.getEntity().getContent()).toString();

                JSONObject jsonObject = new JSONObject(jsonResult);

                JSONArray jsonArray = jsonObject.getJSONArray("id");
                ArrayList<Debt> arrayList = new ArrayList<Debt>();
                for(int i = 0; i< jsonArray.length();i++) {
                    JSONObject c = jsonArray.getJSONObject(i);

                    Debt debt = new Debt();
                    debt.setId(c.getInt("id"));
                    debt.setAmount(c.getDouble("amount"));
                    debt.setCreationDate((convertStringToDate(c.getString("creationDate"))));
                    debt.setDueDate(convertStringToDate((c.getString("dueDate"))));

                    //ToDo: Teste
                    debt.setCreditor(setIDtoPerson(c.getInt("creditor_id")));
                    debt.setDebitor(setIDtoPerson(c.getInt("debitor_id")));

                    debt.setReason(c.getString("reason"));

                    arrayList.add(debt);

                }
                return arrayList;
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println(ex.getMessage());
                return null;
            }
        }

    public Date convertStringToDate(String dateString)
    {
        Date date = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try{
            date = df.parse(dateString);
        }
        catch ( Exception ex ){
            System.out.println(ex);
        }
        return date;
    }


        private StringBuilder inputStreamToString(InputStream is) {
            String rLine = "";
            StringBuilder answer = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));

            try {
                while ((rLine = rd.readLine()) != null) {
                    answer.append(rLine);
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
            return answer;
        }

    private Person setIDtoPerson(int id){
        try {
            GetPeopleTask getPeopleTask = new GetPeopleTask();
            ArrayList<Person> arrayList = getPeopleTask.execute().get();
            for(Person person: arrayList){
                if(person.getId() == id){
                    return person;
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


}
