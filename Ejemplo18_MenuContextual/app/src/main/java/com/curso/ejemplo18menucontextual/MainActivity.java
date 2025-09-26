package com.curso.ejemplo18menucontextual;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // Vista de diseño vinculada con la actividad
        setContentView(R.layout.activity_main);

        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        */

        // 1. Obtener la referencia a la vista
        TextView textViewContextMenu = findViewById(R.id.textViewContextMenu);

        // 2. Registrar la vista para el menú contextual
        registerForContextMenu(textViewContextMenu);
    }

    /**
     * Este método es llamado cuando el usuario realiza un toque largo en la vista registrada.
     * Aquí se infla el menú contextual.
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }
    /**
     * Este método se llama cuando el usuario selecciona un elemento del menú contextual.
     * Aquí se maneja el evento de clic.
     */
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.context_edit) {
            Toast.makeText(this, "Opción 'Editar' seleccionada", Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.context_delete) {
            Toast.makeText(this, "Opción 'Eliminar' seleccionada", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}