package hello.config;

import memory.Memory;
import memory.MemoryCondition;
import memory.MemoryController;
import memory.MemoryFinder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Conditional(MemoryCondition.class) //이 어노테이션을 사용하여 미리 만들어준 조건 클래스를 넣어 조건에 맞게 초기화 되도록 설정할 수 있다.
@ConditionalOnProperty(name = {"memory"} , havingValue = "on")
public class MemoryConfig {
    @Bean
    public MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }

    @Bean
    public MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }
}
