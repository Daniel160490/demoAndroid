package es.indra.carritob;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.SortedList;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.indra.carritob.es.indra.carritob.beans.Categoria;
import es.indra.carritob.es.indra.carritob.service.RestService;

public class MainActivity extends AppCompatActivity {

    ListView listado;
    ArrayList<String> listadoArray = new ArrayList<>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        TextView tv = findViewById(R.id.TVusername);
        String username = preferences.getString("username",
                null);
        tv.setText(username);

        arrayAdapter = new
                ArrayAdapter(this,android.R.layout.simple_list_item_1,listadoArray);
        listado = findViewById(R.id.list);
        listado.setAdapter(arrayAdapter);
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

    private void getCategorias() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.149:8090/categoria/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RestService rest = retrofit.create(RestService.class);
        Call<List<Categoria>> call = rest.getAllCategories();
        call.enqueue(new SortedList.Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call,
                                   Response<List<Categoria>> response) {
                for(Categoria cat : response.body()) {
                    listadoArray.add(cat.getNombre());
                }
                arrayAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
