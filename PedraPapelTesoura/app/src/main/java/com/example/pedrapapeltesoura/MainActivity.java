package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int venci;
    int perdi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void opcaoSelecionada(String opcaoSelecionada){
        ImageView imagemResutlado = findViewById(R.id.imagePadrao);
        TextView textoResultado = findViewById(R.id.ganhador);
        TextView textoVenci = findViewById(R.id.textVenci);
        TextView textoPerdi = findViewById(R.id.textPerdi);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[ numero ];

        switch (opcaoApp){
            case "Pedra":
                imagemResutlado.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                imagemResutlado.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                imagemResutlado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                (opcaoApp == "Pedra" && opcaoSelecionada == "Tesoura") ||
                (opcaoApp == "Papel" && opcaoSelecionada == "Pedra") ||
                (opcaoApp == "Tesoura" && opcaoSelecionada == "Papel")
        ){//app ganhador
            perdi++;
            textoPerdi.setText(Integer.toString(perdi));
            textoResultado.setText("Você perdeu o app ganhou.");
        }else if(
                (opcaoApp == "Tesoura" && opcaoSelecionada == "Pedra") ||
                (opcaoApp == "Pedra" && opcaoSelecionada == "Papel") ||
                (opcaoApp == "Papel" && opcaoSelecionada == "Tesoura")
        ){//voce ganhou
            venci++;
            textoVenci.setText(Integer.toString(venci));
            textoResultado.setText("Você venceu o app perdeu.");
        }else{
            textoResultado.setText("Ninguém ganhou, Impate.");
        }//empate

    }

    public void Pedra(View view) {
        opcaoSelecionada("Pedra");
    }

    public void Papel(View view) {
        opcaoSelecionada("Papel");
    }

    public void Tesoura(View view) {
        opcaoSelecionada("Tesoura");
    }
}