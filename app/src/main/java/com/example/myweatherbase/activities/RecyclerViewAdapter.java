package com.example.myweatherbase.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private int layout;
    private Context context;
    private List<Root> previsiones;

    public RecyclerViewAdapter(Context context,int layout, List<Root> previsiones) {
        super();
        this.layout = layout;
        this.context = context;
        this.previsiones = previsiones;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.my_grade_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return ciudades.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvFecha;
        private TextView tvEstadoCielo;
        private TextView tvTemp;
        private TextView tvTempMax;
        private TextView tvTempMin;
        private TextView tvHora;
        private TextView tvDia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFecha = itemView.findViewById(R.id.tvFecha);
            tvEstadoCielo = itemView.findViewById(R.id.tvEstadoCielo);
            tvTemp = itemView.findViewById(R.id.tvTemp);
            tvTempMax = tvTempMax;
            tvTempMin = tvTempMin;
            tvHora = tvHora;
            tvDia = tvDia;
        }
    }
}
