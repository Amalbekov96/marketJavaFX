package kg.kushtar.market.Repository;

import kg.kushtar.market.Model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends BaseRepository<User> {
    User findByName(String name);
}
