package com.bessaleks.internetprovider.repository;

import com.bessaleks.internetprovider.dto.OperationHistoryDto;
import com.bessaleks.internetprovider.entity.OperationsHistory;
import com.bessaleks.internetprovider.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface OperationsHistoryRepository extends CrudRepository<OperationsHistory,Long> {
List<OperationsHistory> findByUser(User user);
}
