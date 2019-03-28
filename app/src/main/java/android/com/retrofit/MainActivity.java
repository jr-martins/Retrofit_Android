package android.com.retrofit;

import android.com.retrofit.model.CEP;
import android.com.retrofit.retrofit.RetrofitConfig;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//https://blog.matheuscastiglioni.com.br/consumindo-web-service-no-android-com-retrofit/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText cep = findViewById(R.id.etMain_cep);
        final TextView resposta = findViewById(R.id.etMain_resposta);

        Button btnBuscarCep = findViewById(R.id.btnMain_buscarCep);
        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<CEP> call = new RetrofitConfig().getCEPService().buscarCEP(cep.getText().toString());
                call.enqueue(new Callback<CEP>() {
                    @Override
                    public void onResponse(Call<CEP> call, Response<CEP> response) {
                        CEP cep = response.body();
                        resposta.setText(cep.toString());
                    }

                    @Override
                    public void onFailure(Call<CEP> call, Throwable t) {
                        Log.e("CEPService", "Erro ao buscar o cep:" + t.getMessage());

                    }
                });



            }
        });
    }
}
