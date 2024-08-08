package org.model;

import jakarta.json.bind.annotation.JsonbProperty;

public class NotFoundModel {
    public int status;
    public String message;

    public NotFoundModel(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
