package client_app.Service.Impl;

import client_app.Model.Account;
import client_app.Model.Category;
import client_app.Model.Product;
import client_app.Model.User;
import client_app.Service.httpClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

public class httpClientImpl implements httpClient {

    private ObjectMapper objectMapper = new ObjectMapper();
    private OkHttpClient client = new OkHttpClient();
    private String baseAccountUrl = "http://localhost:9090/api/account";
    private String baseCategoryUrl = "http://localhost:9090/api/category";
    private String baseUserUrl = "http://localhost:9090/api/user";
    private String baseProductUrl = "http://localhost:9090/api/product";


    @Override
    public void save(Account account) {
        OkHttpClient okHttpClient = new OkHttpClient();
        try {
            RequestBody requestBody = RequestBody.create(objectMapper.writeValueAsString(account), MediaType.parse("application/json"));

            Request request = new Request.Builder()
                    .post(requestBody)
                    .url(baseAccountUrl + "/save")
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
    public Account findByIdAc(Long id) {
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
    public List<Account> findAllAc() {
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

    //-------------------------------------------------------------------------------------------------------
    // Catefroy Service


    @Override
    public List<Category> findAllCa() {
        Request request = new Request.Builder()
                .url( baseCategoryUrl +"/all")
                .build();

        Call call = client.newCall(request);

        try {
            Response response = call.execute();

            List<Category> categoryList = objectMapper.readValue(response.body().string(), new TypeReference<List<Category>>(){});

            return categoryList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void save(Category category) {

        try {

            RequestBody requestBody = RequestBody.create(objectMapper.writeValueAsString(category), MediaType.parse("application/json"));


            Request request = new Request.Builder()
                    .post(requestBody)
                    .url( baseCategoryUrl + "/save")
                    .build();
            Call call = client.newCall(request);
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
                    .url(baseCategoryUrl + "/update")
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
                .url(baseCategoryUrl + "/deleteById/"+id)
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
    public Category findByIdCa(Long id) {
        Request request = new Request.Builder()
                .url(baseCategoryUrl + "/findById/"+id)
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

    @Override
    public List<Product> findAllPr() {

        Request request = new Request.Builder()
                .url( baseProductUrl +"/all")
                .build();
        Call call = client.newCall(request);

        try {
            Response response = call.execute();
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

            List<Product> productList = mapper.readValue(response.body().string(), new TypeReference<List<Product>>(){});
            return productList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteByIdPr(Long id) {
        Request request = new Request.Builder()
                .delete()
                .url(baseProductUrl + "/deleteById/"+id)
                .build();

        Call call = client.newCall(request);

        try {
            Response response = call.execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findByIdPr(Long id) {
        return null;
    }

    @Override
    public List<User> findAllUs() {
        return null;
    }

    @Override
    public void save(User user) {

        try {
            RequestBody requestBody = RequestBody.create(objectMapper.writeValueAsString(user), MediaType.parse("application/json"));
            Request request = new Request.Builder()
                    .post(requestBody)
                    .url( baseUserUrl + "/save")
                    .build();
            Call call = client.newCall(request);
            Response response = call.execute();
            response.close();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteByIdUs(Long id) {

    }

    @Override
    public User findByIdUs(Long id) {
        return null;
    }

    @Override
    public User findByNameUs(String name) {

        Request request = new Request.Builder()
                .url( baseUserUrl +"/findByName/" + name)
                .build();
        Call call = client.newCall(request);

        try {
            Response response = call.execute();
            if(response != null){
                User user = objectMapper.readValue(response.body().string(), User.class);
                return user;
            }


        } catch (IOException e) {
            return null;
        }

        return null;
    }
}
