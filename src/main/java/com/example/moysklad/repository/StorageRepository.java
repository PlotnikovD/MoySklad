package com.example.moysklad.repository;

import com.example.moysklad.entity.Storage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StorageRepository extends CrudRepository<Storage, Long> {
    List<Storage> findAll();
}
