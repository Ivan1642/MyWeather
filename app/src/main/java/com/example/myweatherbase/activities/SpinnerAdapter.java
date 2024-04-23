package com.example.myweatherbase.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myweatherbase.R;

import java.util.ArrayList;
import java.util.Arrays;

public class SpinnerAdapter<T extends Listable> extends ArrayAdapter<T> {

    private int resource;


    public SpinnerAdapter(@NonNull Context context, int resource, @NonNull T[] objects) {
        super(context, resource, new ArrayList<>(Arrays.asList(objects)));
        this.resource = resource;
    }

    public View getView(int position,@Nullable View convertView,@NonNull ViewGroup parent){
        View customView = convertView;
        if (customView==null)
            customView = LayoutInflater.from(getContext()).inflate(resource,parent,false);

        T item = getItem(position);
        TextView ciudad = customView.findViewById(R.id.ciudad);

        ciudad.setText(item.getDescription());

        return customView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View customView = convertView;
        if(customView==null)
            customView = LayoutInflater.from(getContext()).inflate(resource, parent,false);

        T item = getItem(position);
        TextView nation = customView.findViewById(R.id.ciudad);

        nation.setText(item.getDescription());

        return customView;
    }
}
