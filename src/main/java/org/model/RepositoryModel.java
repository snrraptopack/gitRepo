package org.model;

public class RepositoryModel {
    public String name;
    public boolean fork;
    public String branches_url;

    public RepositoryModel(){
    }

    RepositoryModel(String name , boolean fork, String branches_url){
        this.name = name;
        this.fork = fork;
        this.branches_url = branches_url;
    }
}
