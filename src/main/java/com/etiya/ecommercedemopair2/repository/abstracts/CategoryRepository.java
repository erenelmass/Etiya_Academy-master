package com.etiya.ecommercedemopair2.repository.abstracts;

import com.etiya.ecommercedemopair2.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findByName(String name);

    @Query("SELECT p from Category as p where p.name=:name")
    Category customFindByName(String name);

    List<Category> findByNameEquals(String name);

    boolean existsCategoryByName(String name);
}
