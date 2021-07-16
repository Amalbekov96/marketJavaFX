package kg.kushtar.market.Repository;

import kg.kushtar.market.Model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  BaseRepository<E extends BaseEntity> extends JpaRepository<E, Long> {

}
