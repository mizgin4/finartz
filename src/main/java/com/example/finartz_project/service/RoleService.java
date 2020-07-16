package com.example.finartz_project.service;

import com.example.finartz_project.controller.request.AddRoleRequest;
import com.example.finartz_project.controller.response.AddRoleResponse;


public interface RoleService {

    AddRoleResponse addRole(AddRoleRequest request);
}
