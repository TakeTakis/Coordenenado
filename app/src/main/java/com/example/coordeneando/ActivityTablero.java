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
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTablero extends AppCompatActivity {

    private MediaPlayer correct_ding;

    private LinearLayout papaAlberto;
    private TextView
            t01, t02, t03, t04, t05, t06, t07, t08,
            t09, t10, t11, t12, t13, t14, t15, t16,
            t17, t18, t19, t20, t21, t22, t23, t24,
            t25, t26, t27, t28, t29, t30, t31, t32,
            t33, t34, t35, t36, t37, t38, t39, t40,
            t41, t42, t43, t44, t45, t46, t47, t48,
            t49, t50, t51, t52, t53, t54, t55, t56,
            t57, t58, t59, t60, t61, t62, t63, t64;

    private TextView txtNivel, txtScore,txtCoordenada, txtColorTop, txtColorBot;
    private int num, CoorGen, nivel, score = 0;
    String nombre="";

    AdminDBSQLite admin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);

        //Asociar sonido
        correct_ding = MediaPlayer.create(this,R.raw.correct_ding);

        asociarTablero();

        //Asociar LinearLayout mayor
        papaAlberto = findViewById(R.id.papaAlberto);
        //Asociar
        txtNivel = findViewById(R.id.txtNivel);
        txtScore = findViewById(R.id.txtScoreJusNumber);

        txtCoordenada = findViewById(R.id.txtCoordenada);
        txtColorTop = findViewById(R.id.txtColorTop);
        txtColorBot = findViewById(R.id.txtColorBot);

        ///////// Conseguir informacion (nombre y score del nivel) de los paquetes bundles

        Bundle paqueteRecibido =  getIntent().getExtras();
        int nivelRecibido = paqueteRecibido.getInt("keyNivel");
        nombre = paqueteRecibido.getString("keyNombre");
        txtNivel.setText("Nivel: "+nivelRecibido);
        nivel = Integer.valueOf(nivelRecibido);

        //El Score se saca de la base de datos, so...
        admin = new AdminDBSQLite(this,"bd1",null,1 );
        SQLiteDatabase bd = admin.getWritableDatabase();

        Cursor fila = bd.rawQuery("SELECT nombre, nivel1, nivel2, nivel3, nivel4 from usuarios where nombre='" + nombre+"'", null);

        if (fila.moveToFirst()) {
            switch (nivel){
                case 1:
                    txtScore.setText(fila.getString(1));
                    break;
                case 2:
                    txtScore.setText(fila.getString(2));
                    break;
                case 3:
                    txtScore.setText(fila.getString(3));
                    break;
                case 4:
                    txtScore.setText(fila.getString(4));
                    break;
            }

        } else {
            Toast.makeText(this, "No deberias de estar aqui", Toast.LENGTH_SHORT).show();
        }

        score = Integer.valueOf(txtScore.getText().toString());
        crearTablero(nivelRecibido);

    }

    public void asociarTablero(){
        t01=findViewById(R.id.textView);
        t02=findViewById(R.id.textView2);
        t03=findViewById(R.id.textView3);
        t04=findViewById(R.id.textView4);
        t05=findViewById(R.id.textView5);
        t06=findViewById(R.id.textView6);
        t07=findViewById(R.id.textView7);
        t08=findViewById(R.id.textView8);
        t09=findViewById(R.id.textView9);
        t10=findViewById(R.id.textView10);
        t11=findViewById(R.id.textView11);
        t12=findViewById(R.id.textView12);
        t13=findViewById(R.id.textView13);
        t14=findViewById(R.id.textView14);
        t15=findViewById(R.id.textView15);
        t16=findViewById(R.id.textView16);
        t17=findViewById(R.id.textView17);
        t18=findViewById(R.id.textView18);
        t19=findViewById(R.id.textView19);
        t20=findViewById(R.id.textView20);
        t21=findViewById(R.id.textView21);
        t22=findViewById(R.id.textView22);
        t23=findViewById(R.id.textView23);
        t24=findViewById(R.id.textView24);
        t25=findViewById(R.id.textView25);
        t26=findViewById(R.id.textView26);
        t27=findViewById(R.id.textView27);
        t28=findViewById(R.id.textView28);
        t29=findViewById(R.id.textView29);
        t30=findViewById(R.id.textView30);
        t31=findViewById(R.id.textView31);
        t32=findViewById(R.id.textView32);
        t33=findViewById(R.id.textView33);
        t34=findViewById(R.id.textView34);
        t35=findViewById(R.id.textView35);
        t36=findViewById(R.id.textView36);
        t37=findViewById(R.id.textView37);
        t38=findViewById(R.id.textView38);
        t39=findViewById(R.id.textView39);
        t40=findViewById(R.id.textView40);
        t41=findViewById(R.id.textView41);
        t42=findViewById(R.id.textView42);
        t43=findViewById(R.id.textView43);
        t44=findViewById(R.id.textView44);
        t45=findViewById(R.id.textView45);
        t46=findViewById(R.id.textView46);
        t47=findViewById(R.id.textView47);
        t48=findViewById(R.id.textView48);
        t49=findViewById(R.id.textView49);
        t50=findViewById(R.id.textView50);
        t51=findViewById(R.id.textView51);
        t52=findViewById(R.id.textView52);
        t53=findViewById(R.id.textView53);
        t54=findViewById(R.id.textView54);
        t55=findViewById(R.id.textView55);
        t56=findViewById(R.id.textView56);
        t57=findViewById(R.id.textView57);
        t58=findViewById(R.id.textView58);
        t59=findViewById(R.id.textView59);
        t60=findViewById(R.id.textView60);
        t61=findViewById(R.id.textView61);
        t62=findViewById(R.id.textView62);
        t63=findViewById(R.id.textView63);
        t64=findViewById(R.id.textView64);
    }

    public void TableroNivel1(){
        t01.setText("A8");
        t02.setText("B8");
        t03.setText("C8");
        t04.setText("D8");
        t05.setText("E8");
        t06.setText("F8");
        t07.setText("G8");
        t08.setText("H8");
        t09.setText("A7");
        t10.setText("B7");
        t11.setText("C7");
        t12.setText("D7");
        t13.setText("E7");
        t14.setText("F7");
        t15.setText("G7");
        t16.setText("H7");
        t17.setText("A6");
        t18.setText("B6");
        t19.setText("C6");
        t20.setText("D6");
        t21.setText("E6");
        t22.setText("F6");
        t23.setText("G6");
        t24.setText("H6");
        t25.setText("A5");
        t26.setText("B5");
        t27.setText("C5");
        t28.setText("D5");
        t29.setText("E5");
        t30.setText("F5");
        t31.setText("G5");
        t32.setText("H5");
        t33.setText("A4");
        t34.setText("B4");
        t35.setText("C4");
        t36.setText("D4");
        t37.setText("E4");
        t38.setText("F4");
        t39.setText("G4");
        t40.setText("H4");
        t41.setText("A3");
        t42.setText("B3");
        t43.setText("C3");
        t44.setText("D3");
        t45.setText("E3");
        t46.setText("F3");
        t47.setText("G3");
        t48.setText("H3");
        t49.setText("A2");
        t50.setText("B2");
        t51.setText("C2");
        t52.setText("D2");
        t53.setText("E2");
        t54.setText("F2");
        t55.setText("G2");
        t56.setText("H2");
        t57.setText("A1");
        t58.setText("B1");
        t59.setText("C1");
        t60.setText("D1");
        t61.setText("E1");
        t62.setText("F1");
        t63.setText("G1");
        t64.setText("H1");
    }
    public void TableroNivel2(){
        t01.setText("");
        t02.setText("");
        t03.setText("");
        t04.setText("");
        t05.setText("");
        t06.setText("");
        t07.setText("");
        t08.setText("8");
        t09.setText("");
        t10.setText("");
        t11.setText("");
        t12.setText("");
        t13.setText("");
        t14.setText("");
        t15.setText("");
        t16.setText("7");
        t17.setText("");
        t18.setText("");
        t19.setText("");
        t20.setText("");
        t21.setText("");
        t22.setText("");
        t23.setText("");
        t24.setText("6");
        t25.setText("");
        t26.setText("");
        t27.setText("");
        t28.setText("");
        t29.setText("");
        t30.setText("");
        t31.setText("");
        t32.setText("5");
        t33.setText("");
        t34.setText("");
        t35.setText("");
        t36.setText("");
        t37.setText("");
        t38.setText("");
        t39.setText("");
        t40.setText("4");
        t41.setText("");
        t42.setText("");
        t43.setText("");
        t44.setText("");
        t45.setText("");
        t46.setText("");
        t47.setText("");
        t48.setText("3");
        t49.setText("");
        t50.setText("");
        t51.setText("");
        t52.setText("");
        t53.setText("");
        t54.setText("");
        t55.setText("");
        t56.setText("2");
        t57.setText("A");
        t58.setText("B");
        t59.setText("C");
        t60.setText("D");
        t61.setText("E");
        t62.setText("F");
        t63.setText("G");
        t64.setText("H1");
    }
    public void TableroNivel3(){
        t01.setText("");
        t02.setText("");
        t03.setText("");
        t04.setText("");
        t05.setText("");
        t06.setText("");
        t07.setText("");
        t08.setText("");
        t09.setText("");
        t10.setText("");
        t11.setText("");
        t12.setText("");
        t13.setText("");
        t14.setText("");
        t15.setText("");
        t16.setText("");
        t17.setText("");
        t18.setText("");
        t19.setText("");
        t20.setText("");
        t21.setText("");
        t22.setText("");
        t23.setText("");
        t24.setText("");
        t25.setText("");
        t26.setText("");
        t27.setText("");
        t28.setText("");
        t29.setText("");
        t30.setText("");
        t31.setText("");
        t32.setText("");
        t33.setText("");
        t34.setText("");
        t35.setText("");
        t36.setText("");
        t37.setText("");
        t38.setText("");
        t39.setText("");
        t40.setText("");
        t41.setText("");
        t42.setText("");
        t43.setText("");
        t44.setText("");
        t45.setText("");
        t46.setText("");
        t47.setText("");
        t48.setText("");
        t49.setText("");
        t50.setText("");
        t51.setText("");
        t52.setText("");
        t53.setText("");
        t54.setText("");
        t55.setText("");
        t56.setText("");
        t57.setText("");
        t58.setText("");
        t59.setText("");
        t60.setText("");
        t61.setText("");
        t62.setText("");
        t63.setText("");
        t64.setText("");
    }
    public void TableroNivel4(Boolean BolBlackUp){
        //Excelente si funciona
        //TableroNivel1();
        TableroNivel3();
        if (BolBlackUp){
            papaAlberto.setRotation(0);
        }
        else{
            papaAlberto.setRotation(180);
        }
    }

    public void crearCoordenada(){
        //Crear un numero random entre 1 a 64
        CoorGen = (int) Math.round(1+Math.random()*63);

        switch (CoorGen){
            case 1:
                //Si coor = 1
                txtCoordenada.setText("A8");
                break;
            case 2:
                txtCoordenada.setText("B8");
                break;
            case 3:
                txtCoordenada.setText("C8");
                break;
            case 4:
                txtCoordenada.setText("D8");
                break;
            case 5:
                txtCoordenada.setText("E8");
                break;
            case 6:
                txtCoordenada.setText("F8");
                break;
            case 7:
                txtCoordenada.setText("G8");
                break;
            case 8:
                txtCoordenada.setText("H8");
                break;

            case 9:
                txtCoordenada.setText("A7");
                break;
            case 10:
                txtCoordenada.setText("B7");
                break;
            case 11:
                txtCoordenada.setText("C7");
                break;
            case 12:
                txtCoordenada.setText("D7");
                break;
            case 13:
                txtCoordenada.setText("E7");
                break;
            case 14:
                txtCoordenada.setText("F7");
                break;
            case 15:
                txtCoordenada.setText("G7");
                break;
            case 16:
                txtCoordenada.setText("H7");
                break;

            case 17:
                txtCoordenada.setText("A6");
                break;
            case 18:
                txtCoordenada.setText("B6");
                break;
            case 19:
                txtCoordenada.setText("C6");
                break;
            case 20:
                txtCoordenada.setText("D6");
                break;
            case 21:
                txtCoordenada.setText("E6");
                break;
            case 22:
                txtCoordenada.setText("F6");
                break;
            case 23:
                txtCoordenada.setText("G6");
                break;
            case 24:
                txtCoordenada.setText("H6");
                break;

            case 25:
                txtCoordenada.setText("A5");
                break;
            case 26:
                txtCoordenada.setText("B5");
                break;
            case 27:
                txtCoordenada.setText("C5");
                break;
            case 28:
                txtCoordenada.setText("D5");
                break;
            case 29:
                txtCoordenada.setText("E5");
                break;
            case 30:
                txtCoordenada.setText("F5");
                break;
            case 31:
                txtCoordenada.setText("G5");
                break;
            case 32:
                txtCoordenada.setText("H5");
                break;

            case 33:
                txtCoordenada.setText("A4");
                break;
            case 34:
                txtCoordenada.setText("B4");
                break;
            case 35:
                txtCoordenada.setText("C4");
                break;
            case 36:
                txtCoordenada.setText("D4");
                break;
            case 37:
                txtCoordenada.setText("E4");
                break;
            case 38:
                txtCoordenada.setText("F4");
                break;
            case 39:
                txtCoordenada.setText("G4");
                break;
            case 40:
                txtCoordenada.setText("H4");
                break;

            case 41:
                txtCoordenada.setText("A3");
                break;
            case 42:
                txtCoordenada.setText("B3");
                break;
            case 43:
                txtCoordenada.setText("C3");
                break;
            case 44:
                txtCoordenada.setText("D3");
                break;
            case 45:
                txtCoordenada.setText("E3");
                break;
            case 46:
                txtCoordenada.setText("F3");
                break;
            case 47:
                txtCoordenada.setText("G3");
                break;
            case 48:
                txtCoordenada.setText("H3");
                break;

            case 49:
                txtCoordenada.setText("A2");
                break;
            case 50:
                txtCoordenada.setText("B2");
                break;
            case 51:
                txtCoordenada.setText("C2");
                break;
            case 52:
                txtCoordenada.setText("D2");
                break;
            case 53:
                txtCoordenada.setText("E2");
                break;
            case 54:
                txtCoordenada.setText("F2");
                break;
            case 55:
                txtCoordenada.setText("G2");
                break;
            case 56:
                txtCoordenada.setText("H2");
                break;

            case 57:
                txtCoordenada.setText("A1");
                break;
            case 58:
                txtCoordenada.setText("B1");
                break;
            case 59:
                txtCoordenada.setText("C1");
                break;
            case 60:
                txtCoordenada.setText("D1");
                break;
            case 61:
                txtCoordenada.setText("E1");
                break;
            case 62:
                txtCoordenada.setText("F1");
                break;
            case 63:
                txtCoordenada.setText("G1");
                break;
            case 64:
                txtCoordenada.setText("H1");
                break;

            default:
                txtCoordenada.setText("Error en el generador rnd ._. XD");


        }


    }

    public void crearTablero(int n){
        //Normalmente: Blancas bot, Negras Top

        switch (n){
            case 1:

                //Toast.makeText(this, "Se Creara el Tablero nivel 1", Toast.LENGTH_SHORT).show();
                //Mostrar todas las coordenadas
                TableroNivel1();
                txtColorTop.setText("Negras");
                txtColorBot.setText("Blancas");
                crearCoordenada();
                break;
            case 2:
                //Toast.makeText(this, "Se Creara el Tablero nivel 2", Toast.LENGTH_SHORT).show();
                //Mostrar Solo las coordenadas de los extremos
                TableroNivel2();
                txtColorTop.setText("Negras");
                txtColorBot.setText("Blancas");
                crearCoordenada();
                break;
            case 3:
                //Toast.makeText(this, "Se Creara el Tablero nivel 3", Toast.LENGTH_SHORT).show();
                //NO Mostrar Solo las coordenadas de los extremos
                TableroNivel3();
                txtColorTop.setText("Negras");
                txtColorBot.setText("Blancas");
                crearCoordenada();
                break;
            case 4:
                //Toast.makeText(this, "Se Creara el Tablero nivel 4", Toast.LENGTH_SHORT).show();
                //Bandos invirtiendo bandos
                Boolean BlackUp = false;
                double rnd = Math.random();
                if (rnd <= .5){
                    txtColorTop.setText("Negras");
                    txtColorBot.setText("Blancas");
                    BlackUp = true;
                } else{
                    txtColorTop.setText("Blancas");
                    txtColorBot.setText("Negras");
                    BlackUp = false;
                }
                crearCoordenada();
                TableroNivel4(BlackUp);
                break;
            default:
                Toast.makeText(this, "No deberias estar aqui", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void actualizarDB() {
        //Excelente
        //Si entra aqui es porque fue correcto, asi que lo felicitaremos con un sonido
        correct_ding.start();

        String auxnivel1="",auxnivel2="",auxnivel3="",auxnivel4="";
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("SELECT nivel1, nivel2, nivel3, nivel4 from usuarios where nombre='" + nombre + "'", null);
        if (fila.moveToFirst()){

            auxnivel1 = fila.getString(0);
            auxnivel2 = fila.getString(1);
            auxnivel3 = fila.getString(2);
            auxnivel4 = fila.getString(3);
        }

        if (fila.moveToFirst()) {
            switch (nivel) {
                case 1:
                    auxnivel1 = txtScore.getText().toString();
                    break;
                case 2:
                    auxnivel2 = txtScore.getText().toString();
                    break;
                case 3:
                    auxnivel3 = txtScore.getText().toString();
                    break;
                case 4:
                    auxnivel4 = txtScore.getText().toString();
                    break;
            }

            //Actualizamos datos en la base de datos
            bd.execSQL("UPDATE usuarios SET nivel1='"+ auxnivel1 + "'," +" nivel2 = '"+ auxnivel2 + "'," + " nivel3 = '"+ auxnivel3 + "'," + " nivel4 = '"+ auxnivel4 + "' WHERE nombre = '"+nombre+"'");

        }
    }

    public void btnSalir(View view){

        finish();
    }


    public void Coor01(View view){
        num=1;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor02(View view){
        num=2;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor03(View view){
        num=3;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor04(View view){
        num=4;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor05(View view){
        num=5;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor06(View view){
        num=6;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor07(View view){
        num=7;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor08(View view){
        num=8;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor09(View view){
        num=9;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor10(View view){
        num=10;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor11(View view){
        num=11;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor12(View view){
        num=12;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor13(View view){
        num=13;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor14(View view){
        num=14;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor15(View view){
        num=15;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor16(View view){
        num=16;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }




    public void Coor17(View view){
        num=17;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor18(View view){
        num=18;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor19(View view){
        num=19;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor20(View view){
        num=20;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor21(View view){
        num=21;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor22(View view){
        num=22;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor23(View view){
        num=23;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor24(View view){
        num=24;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor25(View view){
        num=25;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor26(View view){
        num=26;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor27(View view){
        num=27;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor28(View view){
        num=28;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor29(View view){
        num=29;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor30(View view){
        num=30;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor31(View view){
        num=31;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor32(View view){
        num=32;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }


    public void Coor33(View view){
        num=33;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor34(View view){
        num=34;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor35(View view){
        num=35;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor36(View view){
        num=36;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor37(View view){
        num=37;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor38(View view){
        num=38;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor39(View view){
        num=39;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor40(View view){
        num=40;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor41(View view){
        num=41;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor42(View view){
        num=42;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor43(View view){
        num=43;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor44(View view){
        num=44;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor45(View view){
        num=45;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor46(View view){
        num=46;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor47(View view){
        num=47;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor48(View view){
        num=48;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }




    public void Coor49(View view){
        num=49;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor50(View view){
        num=50;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor51(View view){
        num=51;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor52(View view){
        num=52;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor53(View view){
        num=53;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor54(View view){
        num=54;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor55(View view){
        num=55;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor56(View view){
        num=56;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor57(View view){
        num=57;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor58(View view){
        num=58;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor59(View view){
        num=59;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor60(View view){
        num=60;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor61(View view){
        num=61;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor62(View view){
        num=62;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor63(View view){
        num=63;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }
    public void Coor64(View view){
        num=64;
        if(num == CoorGen){
            //Correcto, volvemos a crear otro Tablero y otra Coordenada
            crearTablero(nivel);
            //Aumentamos Score
            score = score + 1;
            txtScore.setText(String.valueOf(score));
            actualizarDB();
        }else{}
    }

}