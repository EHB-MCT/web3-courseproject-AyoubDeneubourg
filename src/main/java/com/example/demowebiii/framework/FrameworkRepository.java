package com.example.demowebiii.framework;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FrameworkRepository extends JpaRepository<Framework, Long> {


    @Query("SELECT f FROM Framework f WHERE f.name = ?1")
    Optional<Framework> findFrameworkByName(String name);


}
