package app.diogo.com.br.sunshine;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.diogo.com.br.sunshine.adapter.MyAdapter;
import app.diogo.com.br.sunshine.model.Clima;
import app.diogo.com.br.sunshine.util.Constants;

public class MyActivity extends Activity {

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        listview = (ListView) findViewById(R.id.listview);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            new RequestTask().execute("58042060");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class RequestTask extends AsyncTask<String, Void, List<Clima>> {

        @Override
        protected List<Clima> doInBackground(String... params) {
            if (params.length == 0) {
                return null;
            }

            Map<String, String> reqParams = new HashMap<String, String>();
            reqParams.put("q", params[0]);
            reqParams.put("mode", "json");
            reqParams.put("units", "metric");
            reqParams.put("cnt", "7");

            String jsonString = HttpHelper.request( Constants.URL_API, reqParams );

            if (jsonString != null) {
                try {
                    JSONObject json = new JSONObject(jsonString);

                    JSONArray jArray = json.getJSONArray("list");
                    int len = jArray.length();

                    ArrayList<Clima> items = new ArrayList<Clima>();

                    for (int i = 0; i < len; i++) {

                        JSONObject data = jArray.getJSONObject(i);

                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis( data.getLong("dt") * 1000 );

                        String date = DateFormat.format("dd/MM/yyyy", calendar).toString();
                        String type = data.getJSONArray("weather").getJSONObject(0).getString("main");
                        double min = data.getJSONObject("temp").getDouble("min");
                        double max = data.getJSONObject("temp").getDouble("max");

                        Clima clima = new Clima(date, type, min, max);
                        items.add(clima);
                    }

                    return items;
                } catch (JSONException e) {
                    Log.e(Constants.TAG, e.getMessage(), e);
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(List<Clima> result) {
            super.onPostExecute(result);

            if (result != null) {
                listview.setAdapter(new MyAdapter(MyActivity.this, (ArrayList) result));
            }
        }
    }

}











