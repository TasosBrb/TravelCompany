package com.travelcompany.eshop.model;

/**
 *
 * Abstracrt Class for handling the IDs
 */
public abstract class PersistentClass {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
