package com.example.myweatherbase.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends BaseActivity implements CallInterface {

    private TextView txtView;
//    private TextView textViewDay;
//    private TextView textViewDayOfWeek;
    private ImageView imageView;
    private Spinner spinner;
    private Button btnPrevision;
    private Root root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.txtView);
        spinner = findViewById(R.id.spinner);
        btnPrevision = findViewById(R.id.btnPrevision);
//        textViewDay = findViewById(R.id.textViewDay);
//        textViewDayOfWeek = findViewById(R.id.textViewDayOfWeek);
        imageView = findViewById(R.id.imageView);

        // Mostramos la barra de progreso y ejecutamos la llamada a la API
        showProgress();
        executeCall(this);

        spinner.setAdapter(new SpinnerAdapter<>(this,R.layout.custom_spinner_item,Ciudad.values()));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ImageDownloader.downloadImage(getApplicationContext(),"https://offloadmedia.feverup.com/barcelonasecreta.com/wp-content/uploads/2015/07/13082735/barcelona_skyline_wallpaper-e1626099901955.jpg",imageView,R.drawable.ic_launcher_foreground);
                //txtView.setText();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
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