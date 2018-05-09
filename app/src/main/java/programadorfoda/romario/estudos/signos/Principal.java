package programadorfoda.romario.estudos.signos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Principal extends AppCompatActivity {
    private Spinner spinnerDia = null;
    private Spinner spinnerMes = null;

    private void validarData() {
        int dia = spinnerDia.getSelectedItemPosition();
        int mes = spinnerMes.getSelectedItemPosition();
        dia++;
        mes++;
        if (dia > 29 && mes == 2) {
            spinnerDia.setSelection(28);
        } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia > 30)) {
          spinnerDia.setSelection(29);
          }
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        spinnerDia = (Spinner) findViewById(R.id.spinnerDia);
        spinnerMes = (Spinner) findViewById(R.id.spinnerMes);

        ArrayAdapter<CharSequence> adapter_dia = ArrayAdapter.createFromResource(this, R.array.dias,
                android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_mes = ArrayAdapter.createFromResource(this, R.array.meses,
                android.R.layout.simple_spinner_item);

        spinnerDia.setAdapter(adapter_dia);
        spinnerMes.setAdapter(adapter_mes);

        spinnerDia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                validarData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });

        spinnerMes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                validarData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });

        Button enviar = (Button) findViewById(R.id.buttonEnviar);
        enviar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){
                int posicaoDia = spinnerDia.getSelectedItemPosition();
                int posicaoMes = spinnerMes.getSelectedItemPosition();

                posicaoDia++;
                posicaoMes++;

                InterpretadorSigno interpretador = new InterpretadorSigno();

                Signo signoResultado = interpretador.interpretar(posicaoDia,posicaoMes);

                Bundle args = new Bundle();
                args.putSerializable("resultado", signoResultado);

                Intent intent = new Intent (Principal.this, Resultado.class);
                intent.putExtra("signo", args);

                startActivity(intent);
            }
        });
    }
}