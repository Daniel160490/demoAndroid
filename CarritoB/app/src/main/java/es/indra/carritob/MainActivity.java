package es.indra.carritob;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        TextView tv = findViewById(R.id.TVusername);
        String username = preferences.getString("username",
                null);
        tv.setText(username);

    }



    public void recibirDatos(View view) {
        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        EditText et = findViewById(R.id.idText);

        String mensaje = et.getText().toString();

        /*
            Pasa de una actividad a otra nueva el mensaje que le pasamos
         */
        Intent intent = new Intent(this, ListCategoryActivity.class);
        EditText editText = findViewById(R.id.idText);
        String message = editText.getText().toString();
        intent.putExtra("mensaje", message);
        startActivity(intent);

    }


}
