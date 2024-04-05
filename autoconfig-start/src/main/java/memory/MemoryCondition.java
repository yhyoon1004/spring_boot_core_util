package memory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Slf4j
public class MemoryCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // -Dmemory=on  java 환경 정보에 memory=on 일 경우에 호출 되도록 설정
        String memory = context.getEnvironment().getProperty("memory");
        log.info("memory = {}", memory);
        return "on".equals(memory);
    }
}
