package org.model;

import java.util.List;

public class GitHubRepositoryResponseModel {
    public String repositoryName;
    public String username;
    public List<BranchModel> branches;
    public NotFoundModel notFoundModel;
    public GitHubRepositoryResponseModel() {}

    public GitHubRepositoryResponseModel(String username, String repositoryName, List<BranchModel> branches) {
        this.username = username;
        this.repositoryName = repositoryName;
        this.branches = branches;
    }
    public GitHubRepositoryResponseModel(NotFoundModel notFoundModel){
        this.notFoundModel = notFoundModel;
    }
}
