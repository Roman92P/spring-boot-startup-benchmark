package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Roman Pashkov created on 03.02.2026 inside the package - com.example.demo.model
 */
@Entity
@Table(name = "test_data")
@Data
public class TestData {

    @Id
    private int id;

    private String name;
}
