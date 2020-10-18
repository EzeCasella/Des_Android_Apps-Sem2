package com.example.myappformulario;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class ConfirmarDatosActivity extends AppCompatActivity {

    String nombre;
    String fechaNacimiento;
    String telefono;
    String email;
    String descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        Bundle params = getIntent().getExtras();

        nombre = params.getString(getResources().getString(R.string.p_nombre),"");
        fechaNacimiento = params.getString(getResources().getString(R.string.p_fecha_nacimiento),"");
        telefono = params.getString(getResources().getString(R.string.p_telefono),"");
        email = params.getString(getResources().getString(R.string.p_email),"");
        descripcion = params.getString(getResources().getString(R.string.p_descripcion),"");

        ((TextView) findViewById(R.id.textView_Name)).setText(nombre);
        ((TextView) findViewById(R.id.textView_FechaNacimiento)).setText("Fecha Nacimiento: "+fechaNacimiento);
        ((TextView) findViewById(R.id.textView_Telefono)).setText("Tel. "+telefono);
        ((TextView) findViewById(R.id.textView_Email)).setText("Email: "+email);
        ((TextView) findViewById(R.id.textView_Descripcion)).setText("Descripcion: "+descripcion);

    }

    public void onClickEditarDatos(View view) {
        Intent confirmInten = new Intent(this, MainActivity.class);
        confirmInten.putExtra(getString(R.string.p_nombre), nombre);
        confirmInten.putExtra(getString(R.string.p_fecha_nacimiento), fechaNacimiento);
        confirmInten.putExtra(getString(R.string.p_telefono), telefono);
        confirmInten.putExtra(getString(R.string.p_email), email);
        confirmInten.putExtra(getString(R.string.p_descripcion), descripcion);

        startActivity(confirmInten);
        finish();
    }
}