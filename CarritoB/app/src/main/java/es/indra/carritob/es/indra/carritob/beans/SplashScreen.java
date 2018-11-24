package es.indra.carritob.es.indra.carritob.beans;

import android.app.Activity;

import java.util.Timer;
import java.util.TimerTask;
import android.widget.ProgressBar;
import android.os.Bundle;
import android.content.Intent;

import es.indra.carritob.MainActivity;
import es.indra.carritob.R;


public class SplashScreen extends Activity{
    private Timer timer;
    private ProgressBar progressBar;
    private int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
            }
        },4000);*/


        //-----BARRA DE PROGRESO-------//
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar.setProgress(0);
        final long intervalo = 45;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (i < 100){
                    progressBar.setProgress(i);
                    i++;
                }else{
                    timer.cancel();
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },0,intervalo);
        //----------------------------//
    }
}
