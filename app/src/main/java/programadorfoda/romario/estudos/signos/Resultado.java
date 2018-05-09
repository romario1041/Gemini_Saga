package programadorfoda.romario.estudos.signos;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado2);

        Bundle args = getIntent().getBundleExtra("signo");

        if(args != null){
            Signo signoRecebido = (Signo) args.getSerializable("resultado");

            int imageResource = getResources().getIdentifier(signoRecebido.getImagem(), null, getPackageName());

            Drawable res = ContextCompat.getDrawable(getApplicationContext(), imageResource);
            ImageView imagem_signo = (ImageView) findViewById(R.id.imgSigno);
            imagem_signo.setImageDrawable(res);

            TextView resultado = (TextView) findViewById(R.id.textSigno);
            TextView datas = (TextView) findViewById(R.id.textData);

            resultado.setText(signoRecebido.getNome());
            datas.setText("de " + signoRecebido.getDiainicio() + "/" +signoRecebido.getMesInicio() + " até "+ signoRecebido.getDiafim() + "/" + signoRecebido.getMesfim());
        }

        Button voltar = (Button) findViewById(R.id.buttonVoltar);
        voltar.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                finish();
            }
        });

    }
}
