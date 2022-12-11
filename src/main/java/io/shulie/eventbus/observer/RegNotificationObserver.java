package io.shulie.eventbus.observer;

import io.shulie.eventbus.eventbus.Subscribe;
import io.shulie.eventbus.service.NotificationService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RegNotificationObserver {

  @Resource
  private NotificationService notificationService;

  @Subscribe
  public void handleRegSuccess(Long userId) {
    notificationService.sendInboxMessage(userId, "...");
  }
}