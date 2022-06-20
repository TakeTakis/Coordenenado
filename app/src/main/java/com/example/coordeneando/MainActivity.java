////////////////////////////////
// Axel Alejandro Perez Gomez //
// Topicos Avanzados de Prog  //
//       Proyecto Final       //
//        Coordenenado        //
//         13/06/2022         //
////////////////////////////////

package com.example.coordeneando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtnameUser;
    AdminDBSQLite admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnameUser = findViewById(R.id.txtNombreUsuario);


        //Wea para la base de datos
        admin = new AdminDBSQLite(this,"bd1",null,1 );


        //////////////////Preferencias por el nombre////////////////
        SharedPreferences pref = getSharedPreferences("nombreMain", Context.MODE_PRIVATE);
        txtnameUser.setText(pref.getString("preferencia", "0"));

    }

    public void btnRegistrar(View view){

        //El nombre sera la clave primaria

        String nombre = txtnameUser.getText().toString();
        //if para validar el nombre
        if (nombre.length()<=3){
            Toast.makeText(this, "El nombre es invalido\nque sean al menos 4 letras",Toast.LENGTH_SHORT).show();
        }
        else {



            //try por si usuario ya registrado y se vuelve a registrar
            try {

                SQLiteDatabase db = admin.getWritableDatabase();

                //Contenedor de valores, objeto registro
                //Crear un objeto que genere un registro para almacenarlo en la tabla vehiculos
                ContentValues registro = new ContentValues();
                registro.put("nombre", txtnameUser.getText().toString());
                registro.put("nivel1", 0);
                registro.put("nivel2", 0);
                registro.put("nivel3", 0);
                registro.put("nivel4", 0);

                db.insertOrThrow("usuarios", null, registro);

                Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(this, "El usuario ya esta registrado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //Boton para entrar si ya esta registrado
    public void btnEntrar(View view){


        String claveNombre = txtnameUser.getText().toString();
        SQLiteDatabase bd = admin.getWritableDatabase();
        /*
            //Metodo para borrar usuarios
            try {
                bd.execSQL("DELETE FROM  usuarios WHERE nombre='ad'");
            }catch(Exception e)
            {

            }
         */



        //Metodo para las preferencias
        SharedPreferences preferente = getSharedPreferences("nombreMain", Context.MODE_PRIVATE);
        SharedPreferences.Editor objEditor = preferente.edit();
        objEditor.putString("preferencia", claveNombre);
        objEditor.commit();





        //Si usuario registrado entrar y enviar nombre

        Cursor fila = bd.rawQuery("SELECT nombre, nivel1, nivel2, nivel3, nivel4 from usuarios where nombre='" + claveNombre+"'", null);


        if (fila.moveToFirst()) {
            //Si entra
            Toast.makeText(this, "Bienvenido "+fila.getString(0), Toast.LENGTH_SHORT).show();

            //Cambiamos de activity y agregamos un Bunlde para pasar el nombre
            Intent NextScreen = new Intent(this,ActivityNivel.class);
            Bundle paquete = new Bundle();
            paquete.putString("keyNombre",claveNombre);
            NextScreen.putExtras(paquete);
            startActivity(NextScreen);


        } else {
            //Si no entra
            Toast.makeText(this, "No existe el usuario", Toast.LENGTH_SHORT).show();


        }


    }

    public void btnSalir(View view){
        finish();
    }

}