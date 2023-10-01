package com.example.testproject.repository;
import com.example.testproject.entity.SchoolMealEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SchoolMealRepository extends JpaRepository<SchoolMealEntity, Long> {
}