package kg.kushtar.market.Service.base;

import kg.kushtar.market.Model.BaseEntity;

import java.util.List;

public interface BaseService<E extends BaseEntity>{

    E create(E e);
    E update(E e);
    E findById(Long id);
    void deleteById(Long id);
    List<E> findAll();

}
