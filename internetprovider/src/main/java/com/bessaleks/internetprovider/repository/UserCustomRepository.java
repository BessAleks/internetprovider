package com.bessaleks.internetprovider.repository;

import com.bessaleks.internetprovider.entity.User;

public interface UserCustomRepository {
    User create(User user);

    User update(User user);

    User getById(Long userId);

    void delete(Long userId);

    void delete(User user);

}
