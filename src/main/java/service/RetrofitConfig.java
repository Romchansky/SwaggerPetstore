package service;

import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    public <T> T createClient(String APIUrl, Class<T> clientClass) {
        return new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl(APIUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(clientClass);
    }

    @SneakyThrows
    public <T> T execute(Call<T> call) {
        Response<T> response = call.execute();
        if (response.isSuccessful()) return response.body();
        else {
            String errorMessage = "http code: " + response.code() + " -> " + response.errorBody().string();
            System.out.println(errorMessage);
            throw new RuntimeException();
        }
    }
}
