package im.wxd.study_shiro.dao;

import im.wxd.study_shiro.domian.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {

    @Select("select p.id as id,p.name as name,p.url as url from permission p left join role_permission rp on p.id = rp.permission_id where rp.role_id = #{id}")
    List<Permission> findPermissionListByRoleId(@Param("id") int roleId);
}
