package com.example.finartz_project.service;

import com.example.finartz_project.controller.request.AddRoleRequest;
import com.example.finartz_project.controller.response.AddRoleResponse;
import com.example.finartz_project.model.dto.RoleDto;

public interface RoleService {

    AddRoleResponse addRole(AddRoleRequest request);
}
