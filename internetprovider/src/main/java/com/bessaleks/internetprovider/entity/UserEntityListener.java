package com.bessaleks.internetprovider.entity;

import javax.persistence.*;

public class UserEntityListener {
    @PrePersist
    public void prePersist(User user) {
    }

    @PreUpdate
    public void preUpdate(User user) {
    }

    @PreRemove
    public void preRemove(User user) {
    }

    @PostPersist
    public void postPersist(User user) {
    }

    @PostUpdate
    public void postUpdate(User user) {
    }

    @PostRemove
    public void postRemove(User user) {
    }

    @PostLoad
    public void postLoad(User user) {
    }
}
