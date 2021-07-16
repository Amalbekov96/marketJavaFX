package client_app.Service.Impl;

import client_app.Model.Category;
import client_app.Service.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Category> findAll() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://localhost:9090/api/category/all")
                .build();

        Call call = okHttpClient.newCall(request);

        List<Category> categories= new ArrayList<>();
        try {
            Response response = call.execute();
            categories = objectMapper.readValue(response.body().string(), new TypeReference<List<Category>>() {});

        } catch (IOException e) {
            e.printStackTrace();

        }
        return categories;
    }

    @Override
    public void save(Category category) {
        OkHttpClient okHttpClient = new OkHttpClient();
        try {

            RequestBody requestBody = RequestBody.create(objectMapper.writeValueAsString(category), MediaType.parse("application/json"));


            Request request = new Request.Builder()
                    .post(requestBody)
                    .url("http://localhost:9090/api/v1/positions/save")
                    .build();
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeAddWindow() {

    }
}