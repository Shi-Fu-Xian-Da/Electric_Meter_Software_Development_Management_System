package com.example.wisdom.controller;

import com.example.wisdom.entity.Permission;
import com.example.wisdom.entity.Role;
import com.example.wisdom.entity.User;
import com.example.wisdom.mapper.PermissionMapper;
import com.example.wisdom.mapper.RoleMapper;
import com.example.wisdom.mapper.RolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("roles")
public class RoleController {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RolePermissionMapper rolePermissionMapper;
    @Autowired
    PermissionMapper permissionMapper;

    // 查询一个
    @GetMapping
    public Role getRoleById(@RequestParam("id")int id) {
        Role role = roleMapper.selectById(id);
        if (role != null) {
            return role;
        } else {
            return null;
        }
    }

    //通过role——id，获取所有permission列表
    @GetMapping("/role/permissions")
    public List<Permission> getPermissionByUserId(@RequestParam("roleId")int id) {
        List<Permission>permissionList=new LinkedList<>();
        //获取permission_id   列表
        List<Integer>permissionIdList= (List<Integer>) rolePermissionMapper.getPermissionIdByRoleId(id);
        for (Integer permissionId : permissionIdList) {
            permissionList.add(permissionMapper.selectById(permissionId));
        }
        return permissionList;
    }


}
