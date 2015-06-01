package no.ciber.tutorial.spring_hibernate.services;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
    public T create(T model);
    public T save(T model);
    public Optional<T> findOne(ID id);
    public List<T> findAll();
}
