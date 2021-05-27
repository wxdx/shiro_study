package im.wxd.study_shiro.config;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;
import java.util.UUID;

public class CustomSessionGenerator implements SessionIdGenerator {
    @Override
    public Serializable generateId(Session session) {
        return "wxd" + UUID.randomUUID().toString().replace("-","");
    }
}
