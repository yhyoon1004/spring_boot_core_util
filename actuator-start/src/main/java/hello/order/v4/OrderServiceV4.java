package hello.order.v4;

import hello.order.OrderService;

import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Timed(value = "my.order")//타입이나 메서드에 적용가는 타입-> 모든 public 메서드에 타이머 적용
@Slf4j
public class OrderServiceV4 implements OrderService {
    //재고 수량
    AtomicInteger stock = new AtomicInteger(100); // 멀티 스레드 상황에 안전하게 값을 넣거나 뺄수있음


    @Override
    public void order() {
            log.info("주문");
            stock.decrementAndGet();
            sleep(500);
    }

    @Override
    public void cancel() {
            log.info("취소");
            stock.incrementAndGet();
            sleep(200);
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
