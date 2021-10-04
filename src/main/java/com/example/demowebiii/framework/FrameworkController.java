package com.example.demowebiii.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/v1/frameworks")
@CrossOrigin(origins = "http://127.0.0.1:5500")



public class FrameworkController {

    private final FrameworkService frameworkService;


    @Autowired
    public FrameworkController(FrameworkService frameworkService) {
        this.frameworkService = frameworkService;
    }


    @GetMapping
    public List<Framework> getFrameworks() {
        return frameworkService.getFrameworks();

    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void registerNewFramework(@RequestBody Framework framework) {
            frameworkService.addNewFramework(framework);
    }

    @DeleteMapping(path = "{frameworkID}")
    public void deleteFramework(@PathVariable("frameworkID") Long frameworkId) {
        frameworkService.deleteFramework(frameworkId);
    }

    @CrossOrigin
    @PutMapping(path = "{frameworkId}")
    public void updateFramework(
            @PathVariable("frameworkId") Long frameworkId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String stars,
            @RequestParam(required = false) String type

    ) {

        frameworkService.updateFramework(frameworkId, name, stars, type);

    }
}
