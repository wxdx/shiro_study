package im.wxd.study_shiro.dao;

import im.wxd.study_shiro.domian.Role;
import im.wxd.study_shiro.domian.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RoleMapper {

    @Select("select r.id as id,r.name as name,r.description as description from role r left join user_role ur on ur.role_id = r.id where ur.user_id = #{id}")
    @Results(
            value = {
                    @Result(id = true,property = "id",column = "id"),
                    @Result(property = "name",column = "name"),
                    @Result(property = "description",column = "description"),
                    @Result(property = "permissionList",column = "id",
                            many = @Many(select = "im.wxd.study_shiro.dao.PermissionMapper.findPermissionListByRoleId",fetchType = FetchType.DEFAULT))
            }
    )
    List<Role> findRoleListByUserId(@Param("id") int userId);

}
