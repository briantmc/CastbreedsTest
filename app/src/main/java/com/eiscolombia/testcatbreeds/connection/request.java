package com.eiscolombia.testcatbreeds.connection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


import androidx.annotation.NonNull;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.eiscolombia.testcatbreeds.MainActivity;
import com.eiscolombia.testcatbreeds.Principal;
import com.eiscolombia.testcatbreeds.classcat.Cat;
import com.eiscolombia.testcatbreeds.classcat.DummyCat;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;



public class request {

    RequestQueue requestQueue;
    Context context;
    public request(Context context){
        this.context = context;

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/breeds")
                .addHeader("x-api-key", "bda53789-d59e-46cd-9bc4-2936630fde39")
                .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        /*Toast.makeText(context,
                                "Ops!" + e.toString(),
                                Toast.LENGTH_SHORT).show();*/
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        if(response.isSuccessful()){
                            try {
                                JSONArray json = new JSONArray(response.body().string());
                                /*Toast.makeText(context,
                                        "Melo!",
                                        Toast.LENGTH_SHORT).show();*/
                                DummyCat cat = new DummyCat(json);
                                Intent intent = new Intent(context, Principal.class);
                                context.startActivity(intent);
                                ((Activity) context).finish();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

    }


}
