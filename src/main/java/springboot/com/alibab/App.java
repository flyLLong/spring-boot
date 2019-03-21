package springboot.com.alibab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("springboot.com.alibab.demo.mapper")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println(111);
	}

}
