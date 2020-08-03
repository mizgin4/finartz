package com.example.finartz_project.controller.response;

import com.example.finartz_project.model.enumeration.Roles;

public class AddRoleResponse {
    private Roles title;

    public Roles getTitle() {
        return title;
    }

    public void setTitle(Roles title) {
        this.title = title;
    }
}
