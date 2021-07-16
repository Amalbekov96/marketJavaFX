package client_app.Service.Impl;

import client_app.Model.Position;
import client_app.Service.PositionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.stage.Stage;
import lombok.val;
import okhttp3.*;
import org.jetbrains.annotations.Nullable;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PositionServiceImpl implements PositionService {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Position> findAll() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://localhost:9090/api/v1/positions/all")
                .build();

        Call call = okHttpClient.newCall(request);

        List<Position> positions= new ArrayList<>();
        try {
            Response response = call.execute();
            positions = objectMapper.readValue(response.body().string(), new TypeReference<List<Position>>() {});

        } catch (IOException e) {
            e.printStackTrace();

        }
        return positions;
    }

    @Override
    public void save(Position position) {
        OkHttpClient okHttpClient = new OkHttpClient();
        try {

            RequestBody requestBody = RequestBody.create(objectMapper.writeValueAsString(position), MediaType.parse("application/json"));


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
