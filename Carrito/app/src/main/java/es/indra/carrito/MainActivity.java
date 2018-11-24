package es.indra.carrito;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
            Notificacion en aplicacion
         */
        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        R.string.bienvenida , Toast.LENGTH_SHORT);

        toast1.show();
    }


    public void recibirDatos(View view) {

        EditText et = findViewById(R.id.idText);

        //String mensaje = et.getText().toString();
        String mensaje = preferences.getString("mensaje",
                "n/a");
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("mensaje", "new_value_for_user");
        edit.commit();
        /*
            Pasa de una actividad a otra nueva el mensaje que le pasamos
         */
        Intent intent = new Intent(this, ListCategoryActivity.class);
        //EditText editText = (EditText) findViewById(R.id.idText);
        //String message = editText.getText().toString();
        //intent.putExtra("mensaje", message);
        startActivity(intent);


        /*
            Notificacion en aplicacion
         */
        Toast toast2 =
                Toast.makeText(getApplicationContext(),
                        getString(R.string.toast) + mensaje, Toast.LENGTH_LONG);

        toast2.show();

        System.out.println(mensaje);
    }
}
