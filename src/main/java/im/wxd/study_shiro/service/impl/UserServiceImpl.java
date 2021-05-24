package im.wxd.study_shiro.service.impl;

import im.wxd.study_shiro.dao.RoleMapper;
import im.wxd.study_shiro.dao.UserMapper;
import im.wxd.study_shiro.domian.Role;
import im.wxd.study_shiro.domian.User;
import im.wxd.study_shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User getAllUserInfoByUsername(String username) {
        User user = userMapper.findByUsername(username);

        List<Role> roleList = roleMapper.findRoleListByUserId(user.getId());

        user.setRoleList(roleList);

        return user;
    }

    @Override
    public User getSimpleUserInfoByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public User getSimpleUserInfoByUserId(int userId) {
        return userMapper.findById(userId);
    }
}
