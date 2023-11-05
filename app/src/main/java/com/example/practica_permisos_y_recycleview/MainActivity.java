package com.example.practica_permisos_y_recycleview;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica_permisos_y_recycleview.Models.Permiso;
import com.example.practica_permisos_y_recycleview.adapters.PermisoAdapter;

import java.util.ArrayList;
import java.util.List;
import android.Manifest;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private PermisoAdapter adapter;
    List<Permiso> ListaPermiso=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListaPermiso.add(new Permiso(Manifest.permission.CALL_PHONE,"Llamar"));
        ListaPermiso.add(new Permiso(Manifest.permission.CAMERA,"Camara"));
        adapter=new PermisoAdapter(MainActivity.this,ListaPermiso);
        RecyclerView rv=findViewById(R.id.rvPermisos);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
    }
}
