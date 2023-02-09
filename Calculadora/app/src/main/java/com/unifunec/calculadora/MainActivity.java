package com.unifunec.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mapear os elementos da View
        EditText valor = findViewById(R.id.edt_Valor);

        EditText quant = findViewById(R.id.edt_Quantidade);
        TextView total = findViewById(R.id.txt_Total);
        Button calcular = findViewById(R.id.btn_Calcular);
        Button limpar = findViewById(R.id.btn_Limpar);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double vl = Double.parseDouble(valor.getText().toString());
                int qt = Integer.parseInt(quant.getText().toString());

                total.setText("R$ "+(vl*qt));

                //ativar e desativar os botões
                calcular.setEnabled(false);
                limpar.setEnabled(true);
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor.setText("");
                quant.setText("");
                total.setText("R$ 0,00");

                //ativar e desativar os botões
                limpar.setEnabled(false);
                calcular.setEnabled(true);
            }
        });

    }
}