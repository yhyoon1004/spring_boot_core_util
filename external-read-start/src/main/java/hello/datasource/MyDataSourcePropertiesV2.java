package hello.datasource;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Getter
@ConfigurationProperties("my.datasource")   //외부설정(파일, 환경변, 등등..)을 주입받는 객체로 "my.datasource"으로 시작하는 키값으로 시작하는 값을 읽어드릴 것
public class MyDataSourcePropertiesV2 {

    private String url;
    private String username;
    private String password;
    private Etc etc;

    @Getter
    public static class Etc {
        private int maxConnection;
        private Duration timeout;
        private List<String> options;
                                                        //DefaultValue 어노테이션으로 값이 없을 경우 해당 값을 넣어줌
        public Etc(int maxConnection, Duration timeout, @DefaultValue("DEFAULT") List<String> options) {
            this.maxConnection = maxConnection;
            this.timeout = timeout;
            this.options = options;
        }
    }
                                                                                  //해당 객체가 없으면 자동으로 타입에 맞는 default 성 값을 넣어줌
    public MyDataSourcePropertiesV2(String url, String username, String password, @DefaultValue Etc etc) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }
}
