package com.tutorial.docker.springboot.dockerspringboot.model;

import javax.persistence.Entity;

@Entity
public class VisitorEntity extends AuditModel{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}