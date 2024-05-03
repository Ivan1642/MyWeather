package com.example.myweatherbase.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private int layout;

    private Context context;
    private Root root;

    public RecyclerViewAdapter(Context context,int layout, Root root) {
        super();
        this.layout = layout;
        this.context = context;
        this.root = root;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.my_grade_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Date date = new Date((long)root.list.get(position).dt*1000);
        holder.tvDia.setText((new SimpleDateFormat("EEEE")).format(date));
        holder.tvHora.setText(root.list.get(position).dt_txt.substring(11,16));
        holder.tvFecha.setText(root.list.get(position).dt_txt.substring(0,11));
        holder.tvTemp.setText("Temp: "+root.list.get(position).main.temp+"º");
        holder.tvTempMax.setText("MAX: "+((String.valueOf(root.list.get(position).main.temp_max).length()>=3)?String.valueOf(root.list.get(position).main.temp_max).substring(0,3):root.list.get(position).main.temp_max)+"º");
        holder.tvTempMin.setText("MIN: "+((String.valueOf(root.list.get(position).main.temp_min).length()>=3)?String.valueOf(root.list.get(position).main.temp_min).substring(0,3):root.list.get(position).main.temp_min)+"º");
        holder.tvEstadoCielo.setText(root.list.get(position).weather.get(0).description);
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + root.list.get(0).weather.get(0).icon + Parameters.ICON_URL_POST,holder.ivRecycler);
    }

    @Override
    public int getItemCount() {
        return root.getList().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvFecha;
        private TextView tvEstadoCielo;
        private TextView tvTemp;
        private TextView tvTempMax;
        private TextView tvTempMin;
        private TextView tvHora;
        private TextView tvDia;
        private ImageView ivRecycler;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFecha = itemView.findViewById(R.id.tvFecha);
            tvEstadoCielo = itemView.findViewById(R.id.tvEstadoCielo);
            tvTemp = itemView.findViewById(R.id.tvTemp);
            tvTempMax = itemView.findViewById(R.id.tvTempMax);
            tvTempMin = itemView.findViewById(R.id.tvTempMin);
            tvHora = itemView.findViewById(R.id.tvHora);
            tvDia = itemView.findViewById(R.id.tvDia);
            ivRecycler = itemView.findViewById(R.id.ivRecycler);
        }
    }
}
