package com.ssm.service;

import com.ssm.domain.Role;

import java.util.List;

/**
 * Created by Administrator on 2016/12/24.
 */
public interface RoleService {
    List<Role> findAllRoles();
    List<Role> findRolesByPage(int page, int rows);
    boolean addRole(String roleName);
}
