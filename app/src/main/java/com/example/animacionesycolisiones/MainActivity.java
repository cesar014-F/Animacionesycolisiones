package com.example.animacionesycolisiones;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button play = (Button) findViewById(R.id.btn_inicio);

        Display pantalla = getWindowManager().getDefaultDisplay();
        Point size = new Point();

        pantalla.getSize(size);

        int x = size.x;
        int y = size.y;

        Log.i("Pantalla", "Ancho es: " + x);
        Log.i("Pantalla", "Alto es: " + y);
    }

    public void jugar(View view){

        Juego juego = new Juego(this);
        setContentView(juego);
    }
}
