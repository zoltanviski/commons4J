package hu.vizoli.commons4J.mvc.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;

@Getter
@Setter
@SuppressWarnings("unchecked")
public class GenericCrudService<T, ID> implements CrudService<T, ID> {
    private CrudRepository<T, ID> crudRepository;

    @Override
    public T create(T t) {
        return (T)this.crudRepository.save(t);
    }

    @Override
    public List<T> findAll() {
        return (List<T>)this.crudRepository.findAll();
    }

    // TODO vizoli, manage the exceptions!
    @Override
    public T findById(ID id) {
        return crudRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Can not find an entity with id: " + id));
    }

    @Override
    public T update(T t) {
        return (T)this.crudRepository.save(t);
    }

    @Override
    public void deleteById(ID id) {
        this.crudRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.crudRepository.deleteAll();
    }
}
