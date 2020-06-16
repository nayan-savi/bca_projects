package com.web.project.create.projectcreatorservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Project {

    private String projectPath;
    private String projectName;
    private String packageName;

    @JsonIgnore
    private String absolutePath;


    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAbsolutePath() {
        absolutePath = this.projectPath+"/"+this.getProjectName();
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }
}
