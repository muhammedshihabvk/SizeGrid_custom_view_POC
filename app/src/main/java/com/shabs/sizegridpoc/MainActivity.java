package com.shabs.sizegridpoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shabs.sizegridpoc.models.MovieList;
import com.shabs.sizegridpoc.models.Search;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> sizeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        sizeList.add("45");
        sizeList.add("76");
        sizeList.add("24");
        sizeList.add("Small");
        sizeList.add("98");
//
        sizeList.add("age\n8-10");
        sizeList.add("20");
        sizeList.add("11-14");
        sizeList.add("a bigger size");
        sizeList.add("S");
        sizeList.add("age\n8-10");
        sizeList.add("20");
        sizeList.add("11-14");
        sizeList.add("a bigger size");
        sizeList.add("S");


        SizeAdapter sizeAdapter = new SizeAdapter(this,sizeList);

        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        recyclerView.setAdapter(sizeAdapter);
    }


//    "https://www.omdbapi.com/?s=star%20wars&apikey=132c797b"
//    https://www.omdbapi.com/?t=batman&apikey=132c797b

    private void loadData(){
        AndroidNetworking.get("https://www.omdbapi.com/?s=star%20wars&apikey=132c797b").addHeaders("shihab","btech").addHeaders("shuaib","SSLC").build().getAsObject(MovieList.class, new ParsedRequestListener() {
            @Override
            public void onResponse(Object response) {
                Log.d("TAGF",response.getClass().getSimpleName());
            }

            @Override
            public void onError(ANError anError) {
            }
        });
    }
}