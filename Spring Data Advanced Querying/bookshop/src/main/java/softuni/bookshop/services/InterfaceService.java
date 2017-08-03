package softuni.bookshop.services;

import java.util.List;

public interface InterfaceService<E, K> {
    E findById(K id);

    void remove(E object);

    List<E> findAll();

    void save(E object);
}
