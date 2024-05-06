package com.example.myweatherbase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondActivity extends BaseActivity  implements CallInterface {
    private RecyclerView recyclerView;
    private Root root;
    private RecyclerViewAdapter recyclerViewAdapter;
    private String ciudad;
    private TextView tvCiudad;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);

        Bundle bundle = getIntent().getExtras();
        ciudad = bundle.getString("ciudad");

        tvCiudad.findViewById(R.id.tvCiudad);
        tvCiudad.setText(ciudad);

        showProgress();
        executeCall(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

     //Realizamos la llamada y recogemos los datos en un objeto Root
    @Override
    public void doInBackground() {
        switch (ciudad.toLowerCase()){
            case "valencia":
                root = Connector.getConector().get(Root.class,"&lat=39.5862518&lon=-0.5411163");
                break;
            case "barcelona":
                root = Connector.getConector().get(Root.class,"&lat=41.3851&lon=2.1734");
                break;
            case "bilbao":
                root = Connector.getConector().get(Root.class,"&lat=43.2630&lon=-2.9349");
                break;
            case "madrid":
                root = Connector.getConector().get(Root.class,"&lat=40.4168&lon=-3.7038");
                break;
            case "sevilla":
                root = Connector.getConector().get(Root.class,"&lat=37.3886&lon=-5.9823");
                break;
        }
    }

    // Una vez ya se ha realizado la llamada, ocultamos la barra de progreso y presentamos los datos
    @Override
    public void doInUI() {
        hideProgress();
        recyclerViewAdapter = new RecyclerViewAdapter(this,R.layout.my_grade_view,root);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
