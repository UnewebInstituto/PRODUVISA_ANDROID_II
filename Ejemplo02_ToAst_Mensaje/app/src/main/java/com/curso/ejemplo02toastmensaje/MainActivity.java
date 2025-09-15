package com.curso.ejemplo02toastmensaje;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Encontrar el botón por su ID
        Button button = findViewById(R.id.btn_show_toast);


        // Configurar el listener de clic para el botón
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el inflador de layouts
                LayoutInflater inflater = getLayoutInflater();

                // Inflar la vista personalizada del Toast
                View customToastView = inflater.inflate(R.layout.custom_toast_layout,
                        findViewById(R.id.custom_toast_container));

                // Opcional: Si quieres cambiar el texto del Toast programáticamente
                // TextView toastText = customToastView.findViewById(R.id.text_toast);
                // toastText.setText("¡El botón ha sido presionado!");

                // Crear el objeto Toast y asignar la vista personalizada
                Toast toast = new Toast(getApplicationContext());
                toast.setView(customToastView);

                // Establecer la duración del Toast
                toast.setDuration(Toast.LENGTH_LONG);

                // Opcional: Establecer la posición del Toast en la pantalla
                toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 100);

                // Mostrar el Toast
                toast.show();
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