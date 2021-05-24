package im.wxd.study_shiro.dao;

import im.wxd.study_shiro.domian.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User findByUsername(@Param("username") String username);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") int id);


    @Select("select * from user where username = #{username} and password = #{password}")
    User findByUsernameAndPwd(@Param("username") String username,@Param("password") String password);
}
