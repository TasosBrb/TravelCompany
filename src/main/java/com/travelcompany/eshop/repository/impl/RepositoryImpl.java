package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.model.PersistentClass;
import com.travelcompany.eshop.repository.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Implemetns the Repository Interface methods
 */
public abstract class RepositoryImpl<T extends PersistentClass> implements Repository<T> {

    private final List<T> list;
    private int index = 1;

    public RepositoryImpl() {
        list = new ArrayList<>();
    }

    @Override
    public int create(T t) {
        t.setId(index++);
        list.add(t);
        return t.getId();
    }

    @Override
    public T read(int id) {
        for (T t : list) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    @Override
    public List<T> read() {
        return list;
    }

    @Override
    public boolean delete(int id) {
        T t = RepositoryImpl.this.read(id);
        if (t != null) {
            list.remove(t);
            return true;
        }
        return false;
    }
}
