////////////////////////////////
// Axel Alejandro Perez Gomez //
// Topicos Avanzados de Prog  //
//       Proyecto Final       //
//        Coordenenado        //
//         13/06/2022         //
////////////////////////////////

package com.example.coordeneando;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminDBSQLite extends SQLiteOpenHelper {

    public AdminDBSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Clase que apartir de ella podemos construir objetos DB
    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("CREATE TABLE usuarios(" +
                "nombre TEXT PRIMARY KEY," +
                "nivel1 INTEGER," +
                "nivel2 INTEGER," +
                "nivel3 INTEGER," +
                "nivel4 INTEGER" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
