package io.shulie.eventbus;

import io.shulie.eventbus.controller.UserController;
import io.shulie.eventbus.observer.RegNotificationObserver;
import io.shulie.eventbus.observer.RegPromotionObserver;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EventBusApplicationTests {


    @Resource
    RegNotificationObserver regNotificationObserver;

    @Resource
    RegPromotionObserver regPromotionObserver;

    @Test
    void contextLoads() {
        UserController userController = new UserController();
        List<Object>  observers = new ArrayList<>();
        // 将观察者对象注册
        observers.add(regNotificationObserver);
        observers.add(regPromotionObserver);
        userController.setRegObservers(observers);
        userController.register("手机号码123","密码123");
    }

}
