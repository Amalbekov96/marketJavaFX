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

    private String baseUrl = "http://localhost:9090/api/category/";
    private ObjectMapper objectMapper = new ObjectMapper();
    private OkHttpClient client = new OkHttpClient();

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
                    .url("http://localhost:9090/api/category/save")
                    .build();
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();
            response.close();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Category category) {
        OkHttpClient okHttpClient = new OkHttpClient();
        try {

            RequestBody requestBody = RequestBody.create(objectMapper.writeValueAsString(category), MediaType.parse("application/json"));


            Request request = new Request.Builder()
                    .post(requestBody)
                    .url("http://localhost:9090/api/category/update")
                    .build();
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();
            response.close();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {

        Request request = new Request.Builder()
                .delete()
                .url(baseUrl + "/deleteById/"+id)
                .build();

        Call call = client.newCall(request);

        try {
            Response response = call.execute();

            System.out.println(response.body().string());
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category findById(Long id) {
        Request request = new Request.Builder()
                .url(baseUrl + "/findById/"+id)
                .build();

        Call call = client.newCall(request);

        try {
            Response response = call.execute();

            Category category = objectMapper.readValue(response.body().string(), Category.class);

            return category;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
