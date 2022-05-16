package com.lawcubator.project.controller;

import com.lawcubator.project.model.Project;
import com.lawcubator.project.model.ProjectCreationRequest;
import com.lawcubator.project.model.ProjectEditRequest;
import com.lawcubator.project.model.User;
import com.lawcubator.project.service.ProjectManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProjectController {

    @Autowired
    ProjectManagementService projectManagementService;

    @PostMapping({"/registerNewProject"})
    public Project registerNewProject(@RequestBody ProjectCreationRequest request, Authentication authentication){
        return projectManagementService.registerNewProject(request, authentication.getName());
    }

    @PutMapping({"/editProject"})
    public Project editProject(@RequestBody ProjectEditRequest request, Authentication authentication)
            throws Exception {
        return projectManagementService.editProject(request, authentication.getName());
    }

    @DeleteMapping({"/deleteProject"})
    public void deleteProject(int projectId, Authentication authentication) throws Exception {
        projectManagementService.deleteProject(projectId, authentication.getName());
        return;
    }

    @GetMapping({"/getAllProjects"})
    public List<Project> getAllProjects(String visitedProfileUserName, Authentication authentication){
        return projectManagementService.getAllProject(visitedProfileUserName, authentication.getName());
    }


}
