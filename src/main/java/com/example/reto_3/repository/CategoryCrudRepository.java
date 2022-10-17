package com.example.reto_3.repository;

import com.example.reto_3.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category,Integer> {
}
