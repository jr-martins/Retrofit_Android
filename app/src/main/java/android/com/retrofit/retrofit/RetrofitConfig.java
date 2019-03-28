package android.com.retrofit.retrofit;

import android.com.retrofit.model.CEP;
import android.com.retrofit.service.CEPService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    final Retrofit retrofit;

    public RetrofitConfig(){

     this.retrofit = new Retrofit.Builder()
             .baseUrl("http://ws.matheuscastiglioni.com.br/ws/")
             .addConverterFactory(JacksonConverterFactory.create())
             .build();

    }

    public CEPService getCEPService(){

        return this.retrofit.create(CEPService.class);
    }


}
