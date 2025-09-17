package com.curso.ejemplo05imagebutton;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ImageButton imageButtonSearch;
    TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 1.) Encontrar los elementos por nombre de Id dentro de la IU
        imageButtonSearch = findViewById(R.id.imageButtonSearch);
        textViewMessage = findViewById(R.id.textViewMessage);

        // 2.) Establecer acción de escucha para el botón de imagen
        imageButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3.) Mostrar mensaje en caja de texto y ventana emergente de mensajes
                textViewMessage.setText("¡Se ha activado el proceso de búsqueda!");
                Toast.makeText(MainActivity.this, "¡Se ha activado el proceso de búsqueda!",Toast.LENGTH_LONG);
            }
        });


        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        */

    }
}