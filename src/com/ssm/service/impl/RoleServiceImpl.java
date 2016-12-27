package com.ssm.service.impl;

import com.ssm.dao.RoleDao;
import com.ssm.domain.Role;
import com.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAllRoles() {
        return roleDao.selectAllRoles();
    }

    @Override
    public List<Role> findRolesByPage(int page, int rows) {
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("rows",rows);
        return roleDao.selectRolesByPage(map);
    }

    @Override
    public boolean addRole(String roleName) {
        Role role = new Role();
        role.setName(roleName);
        int temp = roleDao.insertSelective(role);
        return temp==1?true:false;
    }
}
