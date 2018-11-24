package es.indra.carritob;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ListCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_category);

        Intent intent = getIntent();

        String mensaje = intent.getStringExtra("mensaje");

        TextView tv = findViewById(R.id.tv);

        tv.setText(mensaje);
    }
}
