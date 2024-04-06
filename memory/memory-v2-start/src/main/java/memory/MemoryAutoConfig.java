package memory;


import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@AutoConfiguration // springboot 가 제공하는 자동구성 기능을 사용할 때 쓰는 어노테이션
@ConditionalOnProperty(name = "memory", havingValue = "on")
public class MemoryAutoConfig {
    @Bean
    public MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }

    @Bean
    public MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }
}
