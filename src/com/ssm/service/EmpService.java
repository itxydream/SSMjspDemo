package com.ssm.service;

import com.ssm.domain.Emp;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */
public interface EmpService {
    Emp login(String name, String pass);
    List<Emp>sectAll();
    List<Emp> findRolesByPage(int page, int rows);
    boolean addUser(String name,String pwd);
    boolean UpateEmpbyId(Integer id,Emp emp);
    boolean DeleteUser(Integer id);
//   boolean   deleteBatchto(String[] menuids);
}
