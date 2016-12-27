package com.ssm.service.impl;

import com.ssm.dao.EmpDao;
import com.ssm.domain.Emp;
import com.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;
    @Override
    public Emp login(String name, String pass) {
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("pwd",pass);
        return  empDao.selectByNameAndPass(map);
    }

    @Override
    public List<Emp> sectAll() {

        return empDao.findAll();
    }

    @Override
    public List<Emp> findRolesByPage(int page, int rows) {
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("rows",rows);
        return empDao.findByPage(map);
    }
    @Override
    public boolean addUser(String name,String pwd) {
       Emp emp=new Emp();
        emp.setName(name);
        emp.setPwd(pwd);
        int temp = empDao.insertSelective(emp);
        return temp==1?true:false;
    }

    @Override
    public boolean UpateEmpbyId(Integer id,Emp emp) {
        emp.setId(id);
        return empDao.updateByPrimaryKey(emp)==1?true:false;
    }

    @Override
    public boolean DeleteUser(Integer id) {

        return empDao.deleteByPrimaryKey(id)==1?true:false;
    }
//    @Override
//    public boolean deleteBatchto(String[] menuids) {
//
//        Object params[][] = new Object[menuids.length][];
//        for (int i = 0; i < menuids.length; i++) {
//            params[i] = new Object[] {menuids[i]};
//        }

}
