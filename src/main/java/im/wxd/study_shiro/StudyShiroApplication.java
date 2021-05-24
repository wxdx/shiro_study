package im.wxd.study_shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("im.wxd.study_shiro.dao")
public class StudyShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyShiroApplication.class, args);
	}

}
