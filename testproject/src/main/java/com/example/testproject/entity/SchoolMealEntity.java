package com.example.testproject.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SchoolMealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @Lob
    private String textData;
}