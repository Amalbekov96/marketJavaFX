package client_app.Service;

import client_app.Model.Position;
import client_app.Service.Impl.PositionServiceImpl;

import java.util.List;

public interface PositionService {
    PositionService INSTANCE = new PositionServiceImpl();
    List<Position> findAll();
    void save(Position position);
    void closeAddWindow();
}
