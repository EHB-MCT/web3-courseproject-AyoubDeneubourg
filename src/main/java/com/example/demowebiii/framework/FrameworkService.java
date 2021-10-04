package com.example.demowebiii.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FrameworkService {

    private final FrameworkRepository frameworkRepository;


    @Autowired
    public FrameworkService(FrameworkRepository frameworkRepository) {
        this.frameworkRepository = frameworkRepository;
    }


    public List<Framework> getFrameworks() {

        return frameworkRepository.findAll();

    }

    public void addNewFramework(Framework framework) {

       Optional<Framework> frameworkOptional =  frameworkRepository.findFrameworkByName(framework.getName());
       if(frameworkOptional.isPresent()) {
           throw new IllegalArgumentException("Name already exists");
       }

       frameworkRepository.save(framework);
    }

    public void deleteFramework(Long frameworkId) {
        boolean exists = frameworkRepository.existsById(frameworkId);
            if(!exists) {
                throw new IllegalArgumentException("Framework with id " + frameworkId + " doesn't exists");
            }
            frameworkRepository.deleteById(frameworkId);
    }

    @Transactional
    public void updateFramework(Long frameworkId, String name, String stars, String type) {

        Framework framework = frameworkRepository.findById(frameworkId).orElseThrow(
                ()-> new IllegalArgumentException("Framework with id " + frameworkId + " doesn't exists.")
        );


        if (name != null && name.length() > 0 && !Objects.equals(framework.getName(), name)) {

                Optional<Framework> frameworkOptional = frameworkRepository.findFrameworkByName(name);
                    if(frameworkOptional.isPresent()) {
                        throw new IllegalArgumentException("This framework name already exists.");
                    }

                    framework.setName(name);
        }

        if (stars != null && !Objects.equals(framework.getStars(), stars)) {
            framework.setStars(stars);
        }

        if (type != null && type.length() > 0 && !Objects.equals(framework.getType(), type)) {
            framework.setType(type);
        }

    }
}
