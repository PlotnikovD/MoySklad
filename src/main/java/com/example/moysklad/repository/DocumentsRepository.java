package com.example.moysklad.repository;

import com.example.moysklad.entity.Documents;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsRepository extends CrudRepository<Documents, Long> {
}