package kg.kushtar.market.Service.base;

import javassist.NotFoundException;
import kg.kushtar.market.Exception.NotFoundExist;
import kg.kushtar.market.Model.BaseEntity;
import kg.kushtar.market.Repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class BaseServiceImpl <E extends BaseEntity, Repo extends BaseRepository<E>> implements BaseService<E> {

    public BaseServiceImpl(Repo repo) {
        this.repo = repo;
    }

    private Repo repo;

    @Override
    public E create(E e) {
        return repo.save(e);
    }

    @Override
    public E update(E e) {
        return repo.save(e);
    }

    @Override
    public E findById(Long id) {
        return repo.findById(id).orElseThrow(()-> new NotFoundExist("Not Found"));
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<E> findAll() {
        return repo.findAll();
    }
}
