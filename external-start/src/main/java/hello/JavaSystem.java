package hello;


import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@Slf4j
public class JavaSystem {
    public static void print() {
        //java 코드로 java 시스템 속성 값을 추가해줄수있다
        System.setProperty("init_key_yunhwan", "init_value_sung");
        String init_key = System.getProperty("init_key_yunhwan");
        log.info("key={}", init_key);

        //Java가 가지고 있는 기본적인 값을 읽어오는 메서드
        Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            log.info("prop {}={}", key, System.getProperty(String.valueOf(key)));
        }

        String url = System.getProperty("url");
        String username = System.getProperty("username");
        String password = System.getProperty("password");

        log.info("url={}", url);
        log.info("username={}", username);
        log.info("password={}", password);

        /*jar로 빌드후 java 시스템 속성값을를 주고 싶으면
         * 리눅스 기준
         * java -Durl=devdb -Dusername=yunwhan -Dpassword=sung -jar 빌드한jar파일명.jar
         * 위와 같이 명령어 옵션에 넣어주면 됨
         * */
    }
}
