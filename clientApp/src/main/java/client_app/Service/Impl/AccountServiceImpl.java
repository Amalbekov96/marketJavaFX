package client_app.Service.Impl;

import client_app.Model.Account;
import client_app.Model.Product;
import client_app.Service.AccountService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    private ObjectMapper objectMapper = new ObjectMapper();
    private OkHttpClient client = new OkHttpClient();

    private String baseAccountUrl = "http://localhost:9090/api/account/";

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public Account findById(Long id) {
        return null;
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Account> findAll() {

        Request request = new Request.Builder()
                .url( baseAccountUrl +"/all")
                .build();

        Call call = client.newCall(request);

        try {
            Response response = call.execute();

            List<Account> accountList = objectMapper.readValue(response.body().string(), new TypeReference<List<Account>>(){});

            return accountList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
