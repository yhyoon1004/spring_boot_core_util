package hello;

import hello.config.MyDataSourceConfigV1;
import hello.config.MyDataSourceConfigV2;
import hello.config.MyDataSourceEnvConfig;
import hello.config.MyDataSourceValueConfig;
import hello.datasource.MyDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Import;

//@Import(MyDataSourceValueConfig.class)
//@Import(MyDataSourceConfigV1.class)
@Import(MyDataSourceConfigV2.class)
@SpringBootApplication(scanBasePackages = {"hello.datasource","hello.pay"})
@ConfigurationPropertiesScan({"hello"})//이 어노테이션을 사용하면 프로퍼티 직접등록할 때 @EnableConfigurationProperties 하나하나 넣어줄 필요가 없음
public class ExternalReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalReadApplication.class, args);
    }

}
