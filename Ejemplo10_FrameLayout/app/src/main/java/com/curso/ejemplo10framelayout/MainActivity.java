package com.curso.ejemplo10framelayout;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // Carga de la vista de diseño
        setContentView(R.layout.activity_main);

        // Obtener de la vista de diseño el elemento textView
        TextView overlayTextView = findViewById(R.id.overlay_text_view);

        // Asociar evento clic al elemento textView de la vista de diseño
        overlayTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "!Has hecho click sobre el texto superpuesto¡", Toast.LENGTH_LONG).show();
                // Se cambia el texto que se encontraba contenido en la vista de diseño
                overlayTextView.setText("!Texto cambiado...¡");
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