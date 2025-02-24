package com.example.wisdom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.wisdom.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
    @Select("select permission_id from t_role_permission where role_id = #{id}")
    List<Integer> getPermissionIdByRoleId(int id);
}
