package im.wxd.study_shiro.service;

import im.wxd.study_shiro.domian.User;

public interface UserService {

    User getAllUserInfoByUsername(String username);

    User getSimpleUserInfoByUsername(String username);

    User getSimpleUserInfoByUserId(int userId);


}
