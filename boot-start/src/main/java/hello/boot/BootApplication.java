package hello.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) {
		//본 클래스를 넘겨준 이유는 @SpringBootApplication 어노테이션의 기능 때문에
		//@SpringBootApplication 안에는 컴포넌트 스캔을 포함한 여러기능을 포함한 여러 기능이 설정되어 있음
		SpringApplication.run(BootApplication.class, args);
		// 핵심은 2가지 1. 스프링컨테이너 생성  2. WAS 내장 톰캣 생성
	}

}
