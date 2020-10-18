package com.example.myappformulario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle params = getIntent().getExtras();

        if (params != null) {
            String nombre = params.getString(getResources().getString(R.string.p_nombre),"");
            String fechaNacimiento = params.getString(getResources().getString(R.string.p_fecha_nacimiento),"");
            String telefono = params.getString(getResources().getString(R.string.p_telefono),"");
            String email = params.getString(getResources().getString(R.string.p_email),"");
            String descripcion = params.getString(getResources().getString(R.string.p_descripcion),"");

            ((EditText) findViewById(R.id.editText_Nombre)).setText(nombre);
            try {
                Date fechaNacimientoParsed = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fechaNacimientoParsed);
                ((DatePicker) findViewById(R.id.datepicker_fechaNacimiento))
                        .updateDate(
                                calendar.get(Calendar.YEAR),
                                calendar.get(Calendar.MONTH),
                                calendar.get(Calendar.DAY_OF_MONTH));
                Log.i("Main","Anio: "+fechaNacimientoParsed.getYear());
                Log.i("Main","Mes: "+fechaNacimientoParsed.getMonth());
                Log.i("Main","Dia: "+fechaNacimientoParsed.getDay());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            ((EditText) findViewById(R.id.editText_Telefono)).setText(telefono);
            ((EditText) findViewById(R.id.editText_Email)).setText(email);
            ((EditText) findViewById(R.id.editText_DescripcionContato)).setText(descripcion);
        }
    }
    /**
     *
     * @param datePicker
     * @return a java.util.Date
     */
    public static java.util.Date getDateFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }


    public void onClickSiguiente(View view){
        String nombre = ((TextView) findViewById(R.id.editText_Nombre)).getText().toString();
        Date fechaNacimiento = getDateFromDatePicker((DatePicker) findViewById(R.id.datepicker_fechaNacimiento));
        String telefono = ((TextView) findViewById(R.id.editText_Telefono)).getText().toString();
        String email = ((TextView) findViewById(R.id.editText_Email)).getText().toString();
        String descripcion = ((TextView) findViewById(R.id.editText_DescripcionContato)).getText().toString();


        Intent confirmInten = new Intent(this, ConfirmarDatosActivity.class);
        confirmInten.putExtra(getString(R.string.p_nombre), nombre);
        confirmInten.putExtra(getString(R.string.p_fecha_nacimiento),
                new SimpleDateFormat("dd/MM/yyyy").format(fechaNacimiento));
        confirmInten.putExtra(getString(R.string.p_telefono), telefono);
        confirmInten.putExtra(getString(R.string.p_email), email);
        confirmInten.putExtra(getString(R.string.p_descripcion), descripcion);

        startActivity(confirmInten);
        finish();
    }
}