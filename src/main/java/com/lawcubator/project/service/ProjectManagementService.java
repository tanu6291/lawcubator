package com.lawcubator.project.service;

import com.lawcubator.project.model.Project;
import com.lawcubator.project.model.ProjectCreationRequest;
import com.lawcubator.project.model.ProjectEditRequest;
import com.lawcubator.project.model.User;
import com.lawcubator.project.repo.ProjectRepo;
import com.lawcubator.project.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class ProjectManagementService {

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    UserDao userDao;
    public Project registerNewProject(ProjectCreationRequest projectReq, String loginUserName) {
        User user = userDao.findById(loginUserName).get();
        Project project = new Project(projectReq.getName(), projectReq.getDescription(), projectReq.getUrl(),
                projectReq.getShowToAll(), user);
        return projectRepo.save(project);
    }

    public Project editProject(ProjectEditRequest request, String loginUserName) throws Exception {
        Project project = projectRepo.findById(request.getId()).get();

        if(project == null){ throw new Exception("There is no project");}
        if(!project.getUser().getUserName().equals(loginUserName) ) {
            throw new Exception("You can not edit others project");
        }

        if(!request.getName().isEmpty()){
            project.setName(request.getName());
        }

        if(!request.getDescription().isEmpty()){
            project.setDescription(request.getDescription());
        }

        if(!request.getUrl().isEmpty()){
            project.setUrl(request.getUrl());
        }

        project.setShowToAll(request.getShowToAll());

        return projectRepo.save(project);

    }

    public void deleteProject(int projectId, String loginUserName) throws Exception {
        Project project = projectRepo.findById(projectId).get();
        if(project == null){ throw new Exception("There is no project");}
        if(!project.getUser().getUserName().equals(loginUserName)) {
            throw new Exception("You can not delete others project");
        }
        projectRepo.delete(project);

    }

    public List<Project> getAllProject(String visitedProfileUserName, String loginUserName) {

        if(visitedProfileUserName.equals(loginUserName)){
            return projectRepo.findByUserId(visitedProfileUserName);
        }else {
            return projectRepo.findPublicAndByUserId(visitedProfileUserName);
        }

        //return (List<Project>) projectRepo.findAll();


    }
}
