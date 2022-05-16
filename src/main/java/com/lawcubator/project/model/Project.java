package com.lawcubator.project.model;

import org.aspectj.lang.annotation.RequiredTypes;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @NonNull
    private String name;

    @Column(nullable=true)
    private String description;
    private String url;

    private Boolean showToAll;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getShowToAll() {
        return showToAll;
    }

    public void setShowToAll(Boolean showToAll) {
        this.showToAll = showToAll;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project(@NonNull String name, String description, String url, Boolean showToAll, User user) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.showToAll = showToAll;
        this.user = user;
    }

    public Project() {
    }
}
