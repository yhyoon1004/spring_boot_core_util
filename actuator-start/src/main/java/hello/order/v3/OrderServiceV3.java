package hello.order.v3;

import hello.order.OrderService;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderServiceV3 implements OrderService {

    private final MeterRegistry registry;
    //재고 수량
    AtomicInteger stock = new AtomicInteger(100); // 멀티 스레드 상황에 안전하게 값을 넣거나 뺄수있음

    public OrderServiceV3(MeterRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void order() {
        Timer timer = Timer.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "order")
                .description("order")
                .register(registry);
        timer.record(()->{
            log.info("주문");
            stock.decrementAndGet();
            sleep(500);
        });

    }

    @Override
    public void cancel() {
        Timer timer = Timer.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "cancel")
                .description("order")
                .register(registry);
        timer.record(()->{
            log.info("취소");
            stock.incrementAndGet();
            sleep(200);
        });
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
