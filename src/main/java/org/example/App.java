package org.example;

import example.dao.RoleDao;
import example.dto.Role;

public class App 
{
    public static void main(String[] args) {
        RoleDao dao=new RoleDao();
        Role role=dao.getRole(100);
        System.out.println(role);
    }
}