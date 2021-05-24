package im.wxd.study_shiro;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;

public class JdbcTestAuth {

    @Test
    public void run(){
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:jdbcrealm.ini");
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jack", "123");

        subject.login(usernamePasswordToken);

        System.out.println("认证结果：" + subject.isAuthenticated());

        boolean b = subject.hasRole("role1");


        System.out.println("是否有role1角色:" + b);

        subject.checkPermission("video:find");

        boolean permitted = subject.isPermitted("video:find");

        System.out.println("是否有video:find权限:"  + permitted);


        System.out.println("用户名:" + subject.getPrincipal());

        subject.logout();

        System.out.println("认证结果：" + subject.isAuthenticated());

    }

    @Test
    public void run2(){
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://82.156.202.19:3306/shiro?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("1qaz!QAZ");


        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setPermissionsLookupEnabled(true);
        jdbcRealm.setDataSource(ds);

        securityManager.setRealm(jdbcRealm);

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jack", "123");

        subject.login(usernamePasswordToken);

        System.out.println("认证结果：" + subject.isAuthenticated());

        boolean b = subject.hasRole("role1");


        System.out.println("是否有role1角色:" + b);

        subject.checkPermission("video:find");

        boolean permitted = subject.isPermitted("video:find");

        System.out.println("是否有video:find权限:"  + permitted);


        System.out.println("用户名:" + subject.getPrincipal());

        subject.logout();

        System.out.println("认证结果：" + subject.isAuthenticated());

    }
}
