package com.example.demo.repository;

import com.example.demo.model.TestData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Roman Pashkov created on 03.02.2026 inside the package - com.example.demo.repository
 */
@Repository
public interface TestDataRepository extends JpaRepository<TestData, Long> {
}
