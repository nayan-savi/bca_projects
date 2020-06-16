package com.web.project.create.projectcreatorservice.api;

import com.web.project.create.projectcreatorservice.model.Project;
import com.web.project.create.projectcreatorservice.service.ProjectCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api")
public class ApiProjectCreator {

    @Autowired
    private ProjectCreatorService creatorService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createProject(@RequestBody Project project) throws IOException {
        creatorService.createProject(project);
        return "CREATED";
    }
}
