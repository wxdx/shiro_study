package im.wxd.study_shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;

public class IniTestAuth {

    @Test
    public void run(){
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jack", "456");

        subject.login(usernamePasswordToken);

        System.out.println("认证结果：" + subject.isAuthenticated());

        boolean b = subject.hasRole("user");


        System.out.println("是否有user角色:" + b);

        subject.checkPermission("video:find");

        boolean permitted = subject.isPermitted("video:find");

        System.out.println("是否有video:find权限:"  + permitted);


        System.out.println("用户名:" + subject.getPrincipal());

        subject.logout();

        System.out.println("认证结果：" + subject.isAuthenticated());

    }
}
