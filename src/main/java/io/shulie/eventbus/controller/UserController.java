package io.shulie.eventbus.controller;

import io.shulie.eventbus.eventbus.AsyncEventBus;
import io.shulie.eventbus.eventbus.EventBus;
import io.shulie.eventbus.service.UserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Executors;



public class UserController {


  @Resource
  private UserService userService; // 依赖注入

  private EventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));;
  private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

  public UserController() {
    userService = new UserService();
  }


  public void setRegObservers(List<Object> observers) {
    for (Object observer : observers) {
      eventBus.register(observer);
    }
  }

  public Long register(String telephone, String password) {
    //省略输入参数的校验代码
    //省略userService.register()异常的try-catch代码
    long userId = userService.register(telephone, password);

    eventBus.post(userId);

    return userId;
  }
}

