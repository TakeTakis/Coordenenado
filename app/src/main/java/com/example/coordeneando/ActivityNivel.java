////////////////////////////////
// Axel Alejandro Perez Gomez //
// Topicos Avanzados de Prog  //
//       Proyecto Final       //
//        Coordenenado        //
//         13/06/2022         //
////////////////////////////////

package com.example.coordeneando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityNivel extends AppCompatActivity {

    String nombre="";
    private TextView saludo;
    private RadioButton rb1,rb2,rb3,rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel);

        saludo = findViewById(R.id.txtNivelNombre);
        rb1 = findViewById(R.id.rbnivel1);
        rb2 = findViewById(R.id.rbnivel2);
        rb3 = findViewById(R.id.rbnivel3);
        rb4 = findViewById(R.id.rbnivel4);


        //get bounds
        //Crear un bundle para recuperar el PutExtras
        Bundle paqueteRecibido =  getIntent().getExtras();
        nombre = paqueteRecibido.getString("keyNombre");
        saludo.setText(nombre);

    }

    public void AceptarNivel(View view){
        int nivel =0;
        if (rb1.isChecked()){
            nivel = 1;
        }
        if (rb2.isChecked()){
            nivel = 2;
        }
        if (rb3.isChecked()){
            nivel = 3;
        }
        if (rb4.isChecked()){
            nivel = 4;
        }

        //Toast.makeText(this, "Nivel "+nivel+" Selecionado", Toast.LENGTH_SHORT).show();

        //Cambiamos de activity y agregamos un Bunlde para pasar el nombre
        Intent NextScreen = new Intent(this,ActivityTablero.class);
        Bundle paquete = new Bundle();
        paquete.putString("keyNombre",nombre);
        paquete.putInt("keyNivel",nivel);
        NextScreen.putExtras(paquete);
        startActivity(NextScreen);

    }

    public void btnSeeScore(View view){
        //wea para ir a otro activity mostrando los scores
        Intent NextScreen = new Intent(this,ActivityScores.class);
        Bundle paquete = new Bundle();
        paquete.putString("keyNombre",nombre);
        NextScreen.putExtras(paquete);
        startActivity(NextScreen);
    }

    public void btnSalir(View view){
        finish();
    }
}