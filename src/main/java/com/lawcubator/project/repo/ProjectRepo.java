package com.lawcubator.project.repo;

import com.lawcubator.project.model.Project;
import com.lawcubator.project.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectRepo extends CrudRepository<Project, Integer> {

    @Query("SELECT * from Project where user_id = :userId")
    List<Project> findByUserId(String userId);


    @Query("SELECT * from Project where is_private = false and user_id = :userId")
    List<Project> findPublicAndByUserId(String userId);
}
