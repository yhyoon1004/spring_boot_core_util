package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class OsEnv {
    public static void main(String[] args) {
        Map<String, String> getenv = System.getenv();//시스템의 환경변수를 다읽을 수 있는 메서드
        for (String key : getenv.keySet()) {
            log.info("env {}={}", key, System.getenv());
        }


        //DBURL=dev.db.com 개발 서버
        //DBURL=prod.db.com 운영 서버
        String dburl = System.getenv("DBURL");//이와 같이 시스템 환경변수를 읽어 로직 수행


    }
}
