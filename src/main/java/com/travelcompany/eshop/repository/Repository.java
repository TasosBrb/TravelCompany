package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.model.PersistentClass;
import java.util.List;

/**
 *
 * Interface for implementing the CRUD on repositories
 *
 * @param <T>
 */
public interface Repository<T extends PersistentClass> {

    /**
     * Creates a Repository
     *
     * @param t
     * @return
     */
    int create(T t);

    /**
     * Reads a Repository
     *
     * @param id
     * @return
     */
    T read(int id);

    List<T> read();

    /**
     * Deletes a Repository
     *
     * @param id
     * @return
     */
    boolean delete(int id);

}
