package com.example.myweatherbase.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView txtView;
    private ImageView imageView;
    private Spinner spinner;
    private Button btnPrevision;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.txtView);
        spinner = findViewById(R.id.spinner);
        btnPrevision = findViewById(R.id.btnPrevision);
        imageView = findViewById(R.id.ivRecycler);

        spinner.setAdapter(new SpinnerAdapter<>(this,R.layout.custom_spinner_item,Ciudad.values()));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Ciudad ciudad = (Ciudad)adapterView.getSelectedItem();
                ImageDownloader.downloadImage(getApplicationContext(),ciudad.getUrl(),imageView,R.drawable.ic_launcher_foreground);
                txtView.setText(ciudad.getDescription());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}