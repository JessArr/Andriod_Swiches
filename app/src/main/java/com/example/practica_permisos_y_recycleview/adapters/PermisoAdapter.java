package com.example.practica_permisos_y_recycleview.adapters;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica_permisos_y_recycleview.Models.Permiso;
import com.example.practica_permisos_y_recycleview.R;

import java.util.List;

public class PermisoAdapter extends RecyclerView.Adapter<PermisoAdapter.ViewHolder>{
    private List<Permiso> LP;

    Switch state;

    private Activity mActivity;

    Permiso permisos;

    public PermisoAdapter(Activity activity, List<Permiso> LP){
        this.LP=LP; this.mActivity=activity;
    }
    @NonNull
    @Override
    public PermisoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater Li=LayoutInflater.from(parent.getContext());
        View vy=Li.inflate(R.layout.lista_permisos,parent,false);
        return new ViewHolder(vy);
    }



    @Override
    public void onBindViewHolder(@NonNull PermisoAdapter.ViewHolder holder, int position) {
        holder.setData(LP.get(position));
        state=holder.MostrarPermiso;
        Permiso p=LP.get(position);
        state.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(state.isChecked())
                {
                    if (ContextCompat.checkSelfPermission(mActivity,p.getNombre()) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(mActivity, new String[]{p.getNombre()}, 2004);
                    }

                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return LP.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtPermiso;
        private Switch MostrarPermiso;

        public Permiso permisoH;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPermiso=itemView.findViewById(R.id.tvPermiso);
            MostrarPermiso=(Switch) itemView.findViewById(R.id.switch1);
        }
        public void setData(Permiso permiso) {
            permisoH=permiso;
            txtPermiso.setText(permiso.getDescripcion());
        }
    }
}
