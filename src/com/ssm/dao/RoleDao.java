package com.ssm.dao;

import com.ssm.domain.Role;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    List<Role> selectAllRoles();

    List<Role> selectRolesByPage(Map<String, Object> map);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}