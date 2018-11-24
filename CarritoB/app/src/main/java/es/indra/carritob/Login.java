package es.indra.carritob;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = preferences.edit();
        edit.clear();
        edit.commit();

        String username = preferences.getString("username", null);
        String pass = preferences.getString("password", null);

        if(username != null && pass != null ){
            Intent i = new Intent(this, ListCategoryActivity.class);
            startActivity(i);
        } else{
            setContentView(R.layout.activity_login);
        }

    }

    public void entrar (View view){

        EditText login = findViewById(R.id.etUsername);
        EditText pass = findViewById(R.id.etPassword);

        String username = login.getText().toString();
        String password = pass.getText().toString();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("username", username);
        edit.putString("password", password);
        edit.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);



    }
}
