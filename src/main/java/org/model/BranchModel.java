package org.model;

public class BranchModel {
    public String name;
    public CommitModel commit;
    public String sha;

    public BranchModel() {}

    public BranchModel(String name, CommitModel commit) {
        this.name = name;
        this.commit = commit;
    }

    public BranchModel(String name, String sha) {
        this.name = name;
        this.sha = sha ;
    }
}
