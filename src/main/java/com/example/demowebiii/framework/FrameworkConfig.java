package com.example.demowebiii.framework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// Like a Seeder
@Configuration
public class FrameworkConfig {

    @Bean
    CommandLineRunner commandLineRunner(FrameworkRepository repository) {

        return args -> {

            Framework angular = new Framework( "Angular", "15000", "Front-End");
            Framework laravel = new Framework("Laravel", "67000", "Back-End");

            repository.saveAll(
                List.of(angular, laravel)
            );
        };


    }

}
