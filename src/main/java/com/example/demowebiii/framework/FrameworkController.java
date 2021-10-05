package com.example.demowebiii.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FrameworkController {
    private final FrameworkService frameworkService;





    @Autowired
    public FrameworkController(FrameworkService frameworkService) {
        this.frameworkService = frameworkService;
    }


    @GetMapping("/")
    public String initz() {
        return "Welcome to API APPLICATION";
    }


    @GetMapping(path = "api/v1/frameworks")
    public List<Framework> getFrameworks() {
        return frameworkService.getFrameworks();

    }

    @GetMapping(path = "/multiply")
    public Map<String,String> multiply(@RequestParam("number" ) int number) {
        HashMap<String, String> map = new HashMap<>();
        map.put("result", number * number + "");
        return map;

    }


    @RequestMapping(path = "api/v1/frameworks", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,String>  registerNewFramework(@RequestBody Framework framework) {
        frameworkService.addNewFramework(framework);
        HashMap<String, String> map = new HashMap<>();
        map.put("result", "Framework added");
        return map;
    }

    @DeleteMapping(path = "api/v1/frameworks/{frameworkID}")
    public Map<String,String> deleteFramework(@PathVariable("frameworkID") Long frameworkId) {
        frameworkService.deleteFramework(frameworkId);
        HashMap<String, String> map = new HashMap<>();
        map.put("result", "Framework with id " + frameworkId + " deleted");
        return map;

    }

    @PutMapping(path = "api/v1/frameworks/{frameworkId}")
    public Map<String,String> updateFramework(
            @PathVariable("frameworkId") Long frameworkId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String stars,
            @RequestParam(required = false) String type

    ) {

        frameworkService.updateFramework(frameworkId, name, stars, type);
        HashMap<String, String> map = new HashMap<>();
        map.put("result", "Framework with id " + frameworkId + " updated");
        return map;


    }
}
