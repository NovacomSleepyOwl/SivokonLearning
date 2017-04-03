package com.novacom.dao.beans;

/**
 * Created by A.Sivakon on 03.04.2017.
 */
public class ClientBean {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientBean(String cname) {
        this.name = cname;
    }
}
