package com.curso.ejemplo09tablelayout;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // Cargar la vista de diseño
        setContentView(R.layout.activity_main);

        // Obtener de la vista de diseño en función del id respectivo
        EditText nombreEditText = findViewById(R.id.nombre_edit_text);
        EditText correoEditText = findViewById(R.id.correo_edit_text);
        Button enviarButton = findViewById(R.id.enviar_button);

        // Asociar manejo del evento clic al botón enviar
        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreEditText.getText().toString();
                String correo = correoEditText.getText().toString();
                String mensaje = "Formulario enviado por:\nNOMBRE:"+ nombre + ",CORREO:"+correo;
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
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