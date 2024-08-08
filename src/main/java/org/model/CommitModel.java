package org.model;

import java.net.URL;

public class CommitModel {
    public String sha;
    public URL url;

    public CommitModel() {}

    public CommitModel(String sha, URL url) {
        this.sha = sha;
        this.url = url;
    }
}
