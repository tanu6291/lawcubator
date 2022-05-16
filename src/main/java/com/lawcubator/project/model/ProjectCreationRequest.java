package com.lawcubator.project.model;

public class ProjectCreationRequest {

    private String name;
    private String description;
    private String url;
    private Boolean showToAll;

    public ProjectCreationRequest() {
    }

    public ProjectCreationRequest(String name, String description, String url, Boolean showToAll) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.showToAll = showToAll;
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
}
