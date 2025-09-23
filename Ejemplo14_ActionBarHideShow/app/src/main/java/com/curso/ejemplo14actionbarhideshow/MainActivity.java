package com.curso.ejemplo14actionbarhideshow;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import androidx.appcompat.app.ActionBar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private boolean isActionBarVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // Obtención de la vista de diseño
        setContentView(R.layout.activity_main);

        // Obtener la instancia de la Action Bar
        actionBar = getSupportActionBar();

        // Obtener el botón de la vista
        Button toggleButton = findViewById(R.id.toggleButton);

        // Asignar un clic al botón para ocultar/mostrar la Action Bar
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isActionBarVisible) {
                    // Si está visible, la ocultamos
                    if (actionBar != null) {
                        actionBar.hide();
                        isActionBarVisible = false;
                    }
                } else {
                    // Si está oculta, la mostramos
                    if (actionBar != null) {
                        actionBar.show();
                        isActionBarVisible = true;
                    }
                }
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