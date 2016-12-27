package com.ssm.utils;

/**
 * Created by Administrator on 2016/12/20.
 */
public interface SQL {
    String sql1 = "select tb_auth.id,tb_auth.name,tb_auth.url,tb_auth.op, tb_authgroup.name\n" +
            "from tb_auth inner join tb_authgroup\n" +
            "on tb_auth.authgroup_id = tb_authgroup.id\n" +
            "where tb_authgroup.id in(\n" +
            "select tb_role_authgroup.authgroup_id\n" +
            "from tb_role_authgroup inner join tb_role\n" +
            "on tb_role_authgroup.role_id = tb_role.id\n" +
            "where tb_role.id in (\n" +
            "select tb_emp_role.role_id\n" +
            "from tb_emp_role inner join tb_emp\n" +
            "on tb_emp_role.emp_id = tb_emp.id\n" +
            "where tb_emp.id= ?\n" +
            ")\n" +
            ")";
    String sql2 ="select tb_auth.id,tb_auth.name,tb_auth.url,tb_auth.op\n" +
            "from tb_auth inner join tb_role_auth\n" +
            "on tb_auth.id = tb_role_auth.auth_id\n" +
            "where tb_role_auth.role_id in(\n" +
            "select tb_emp_role.role_id\n" +
            "from tb_emp_role inner join tb_emp\n" +
            "on tb_emp_role.emp_id = tb_emp.id\n" +
            "where tb_emp.id= ?\n" +
            ")";
}
