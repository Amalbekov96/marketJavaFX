package client_app.Service.Impl;

import client_app.Model.Account;
import client_app.Model.Product;
import client_app.Service.ProductService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ObjectMapper objectMapper = new ObjectMapper();
    private OkHttpClient client = new OkHttpClient();

    private String baseAccountUrl = "http://localhost:9090/api/product/";

    @Override
    public List<Product> findAll() {

        Request request = new Request.Builder()
                .url( baseAccountUrl +"/all")
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
}
