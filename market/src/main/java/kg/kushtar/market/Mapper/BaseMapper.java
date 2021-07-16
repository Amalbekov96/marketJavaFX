package kg.kushtar.market.Mapper;

import java.util.List;

public interface BaseMapper<E, D> {
    E toEntity(D d);
    D toDto(E e);
    List<E> toEntityList(List<D> dtoList);
    List<D> toDtoList(List<E> entityList);
}
