package hello.selector;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.*;

public class ImportSelectTest {

    @Test
    void staticConfig() {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(StaticConfig.class);
        HelloBean bean = appContext.getBean(HelloBean.class);
        assertThat(bean).isNotNull();
    }

    @Test
    void selectorConfig() {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SelectorConfig.class);
        HelloBean bean = appContext.getBean(HelloBean.class);
        assertThat(bean).isNotNull();
    }

    /**설정할 클래스를 Import 어노테이션을 직접 선언하여 넣어주는 정적 방식*/
    @Configuration
    @Import(HelloBean.class)
    public static class StaticConfig{
    }

    /**ImportSelector 구현체를 이용해 로직을 태워서 넣어주는 동적 방식*/
    @Configuration
    @Import(HelloImportSelector.class)  // 구현체를 클래스를 상용하여 설정 정보 사용
    public static class SelectorConfig {

    }

}
