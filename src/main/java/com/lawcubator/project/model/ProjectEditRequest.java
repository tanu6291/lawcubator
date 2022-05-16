package com.lawcubator.project.model;

public class ProjectEditRequest {

    private int id;
    private String name;
    private String description;
    private String url;
    private Boolean showToAll;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public ProjectEditRequest() {
    }
}
