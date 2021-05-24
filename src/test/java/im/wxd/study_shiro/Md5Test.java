package im.wxd.study_shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;

public class Md5Test {

    @Test
    public void run(){
        SimpleHash md5 = new SimpleHash("md5", "123", null, 2);
        System.out.println(md5);
    }
}
