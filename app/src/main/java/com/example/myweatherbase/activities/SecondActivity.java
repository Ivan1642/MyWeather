package com.example.myweatherbase.activities;

import android.content.Intent;
import android.os.Bundle;

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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.recyclerView);

        // Mostramos la barra de progreso y ejecutamos la llamada a la API
        showProgress();
        executeCall(this);

        Intent intent = getIntent();

        Root root = doInBackground();
        recyclerView.setAdapter(new RecyclerViewAdapter(this,R.layout.my_grade_view,ciudades));
    }
    // Realizamos la llamada y recogemos los datos en un objeto Root
    @Override
    public void doInBackground() {
        root = Connector.getConector().get(Root.class,"&lat=39.5862518&lon=-0.5411163");
    }

    // Una vez ya se ha realizado la llamada, ocultamos la barra de progreso y presentamos los datos
    @Override
    public void doInUI() {
        hideProgress();
        txtView.setText(root.list.get(0).weather.get(0).description);
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + root.list.get(0).weather.get(0).icon + Parameters.ICON_URL_POST, imageView);

        Date date = new Date((long)root.list.get(0).dt*1000);
        SimpleDateFormat dateDayOfWeek = new SimpleDateFormat("E");
        SimpleDateFormat dateDay = new SimpleDateFormat("EEE, d MMM yyyy HH:mm");
//        textViewDayOfWeek.setText(dateDayOfWeek.format(date));
//        textViewDay.setText(dateDay.format(date));
    }
}
