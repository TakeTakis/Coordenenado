////////////////////////////////
// Axel Alejandro Perez Gomez //
// Topicos Avanzados de Prog  //
//       Proyecto Final       //
//        Coordenenado        //
//         13/06/2022         //
////////////////////////////////

package com.example.coordeneando;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityScores extends AppCompatActivity {

    String nombre="";
    private TextView saludos, txtShowScore1,txtShowScore2,txtShowScore3,txtShowScore4;
    AdminDBSQLite admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        saludos=findViewById(R.id.txtBienvNombre);

        txtShowScore1 = findViewById(R.id.txtShowScore);
        txtShowScore2 = findViewById(R.id.txtShowScore2);
        txtShowScore3 = findViewById(R.id.txtShowScore3);
        txtShowScore4 = findViewById(R.id.txtShowScore4);



        Bundle paqueteRecibido =  getIntent().getExtras();
        nombre = paqueteRecibido.getString("keyNombre");
        saludos.setText("Para "+nombre+" tenemos el siguiente Score:");

        admin = new AdminDBSQLite(this,"bd1",null,1 );
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("SELECT nivel1, nivel2, nivel3, nivel4 from usuarios where nombre='" + nombre + "'", null);
        if (fila.moveToFirst()){

            txtShowScore1.setText(fila.getString(0));
            txtShowScore2.setText(fila.getString(1));
            txtShowScore3.setText(fila.getString(2));
            txtShowScore4.setText(fila.getString(3));
        }
    }

    public void btnSalir(View view){
        finish();
    }
}