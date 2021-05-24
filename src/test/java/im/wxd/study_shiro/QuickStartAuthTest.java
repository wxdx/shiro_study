package im.wxd.study_shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuickStartAuthTest {

    private SimpleAccountRealm accountRealm = new SimpleAccountRealm();

    private DefaultSecurityManager securityManager = new DefaultSecurityManager();

    @BeforeEach
    public void init(){
        accountRealm.addAccount("wxd","123","admin","root");
        accountRealm.addAccount("yyq","123","user");

        securityManager.setRealm(accountRealm);
    }

    @Test
    public void run(){

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("wxd", "123");

        subject.login(usernamePasswordToken);

        System.out.println("认证结果：" + subject.isAuthenticated());

        boolean b = subject.hasRole("admin");

//        subject.checkRole("user");

        System.out.println("是否有admin角色:" + b);

        System.out.println("用户名:" + subject.getPrincipal());

        subject.logout();

        System.out.println("认证结果：" + subject.isAuthenticated());



    }
}
