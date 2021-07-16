package client_app.Model;

import lombok.Data;

@Data
public class Position {

    private Long id;
    private String name;
    private boolean active;

    @Override
    public String toString(){
        return name;
    }

}
