package com.bessaleks.internetprovider.repository.impl;

import com.bessaleks.internetprovider.entity.User;
import com.bessaleks.internetprovider.repository.UserCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Objects;

@Repository
@Transactional
public class UserCustomRepositoryImpl implements UserCustomRepository {

    private final EntityManager entityManager;

    @Autowired
    public UserCustomRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User getById(Long userId) {
        User user = entityManager.find(User.class, userId);
        entityManager.detach(user);
        entityManager.merge(user);
        return entityManager.find(User.class, userId);
    }

    @Override
    public void delete(Long userId) {
        User user = getById(userId);
        if (Objects.isNull(user)) {
            throw new RuntimeException("User not found!");
        }
        entityManager.remove(user);
    }

    @Override
    public void delete(User user) {
        User user1 = entityManager.merge(user);
        entityManager.remove(user1);
    }
}
