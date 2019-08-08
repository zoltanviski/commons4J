package hu.vizoli.commons4J.mvc.service;

import java.util.List;

public interface CrudService<T, ID> {
    T create(T t);

    List<T> findAll();

    T findById(ID id);

    T update(T t);

    void deleteById(ID id);

    void deleteAll();
}
