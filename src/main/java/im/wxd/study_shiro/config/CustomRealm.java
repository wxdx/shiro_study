package im.wxd.study_shiro.config;

import im.wxd.study_shiro.domian.Permission;
import im.wxd.study_shiro.domian.Role;
import im.wxd.study_shiro.domian.User;
import im.wxd.study_shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User newUser = (User) principals.getPrimaryPrincipal();
        User user = userService.getAllUserInfoByUsername(newUser.getUsername());

        List<String> roleList = new ArrayList<>();
        List<String> permissionList = new ArrayList<>();

        if (user.getRoleList() != null && user.getRoleList().size() > 0) {
            for (Role role : user.getRoleList()) {
                roleList.add(role.getName());
                if (role.getPermissionList() != null && role.getPermissionList().size() > 0) {
                    for (Permission permission : role.getPermissionList()) {
                        permissionList.add(permission.getName());
                    }
                }
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roleList);
        simpleAuthorizationInfo.addStringPermissions(permissionList);


        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User user = userService.getAllUserInfoByUsername(username);
        if (user == null || user.getPassword() == null || "".equals(user.getPassword())){
            return null;
        }

        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}
