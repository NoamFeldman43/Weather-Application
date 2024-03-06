package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    EditText etCity;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCity = findViewById(R.id.etCity);
        tvResult = findViewById(R.id.tvResult);
    }

    @SuppressLint("SetTextI18n")
    public void getWeatherDetails(View view)
    {
        String apikey = "b37712eda7eb4c0b5e1ea63a9442abc6";
        String city=etCity.getText().toString();
        String url= "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=b37712eda7eb4c0b5e1ea63a9442abc6";
        RequestQueue queue= Volley.newRequestQueue((getApplicationContext()));
        JsonObjectRequest request = new JsonObjectRequest (Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                    try{
                        JSONObject object=response.getJSONObject("main");
                        String temperature=object.getString("temp");
                        Double temp=Double.parseDouble(temperature)-273.15;
                        tvResult.setText("Temperature "+temp.toString().substring(0,5)+"C°");
                        // String feelsLike=object.getString("feels_like");
                      //  Double feels=Double.parseDouble(feelsLike)-273.15;
                     //   tvResult.setText("Feels like "+feels.toString().substring(0,5)+"C°");
                    }catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }

            });
            queue.add(request);
        }
    }
