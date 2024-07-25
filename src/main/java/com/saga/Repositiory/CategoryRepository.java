package com.saga.Repositiory;

import com.saga.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepositiory extends JpaRepository<Category,Long> {
}
