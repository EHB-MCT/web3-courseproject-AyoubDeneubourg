package com.example.demowebiii.framework;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;

//
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