package io.shulie.eventbus.observer;

import io.shulie.eventbus.eventbus.Subscribe;
import io.shulie.eventbus.service.PromotionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RegPromotionObserver {

  @Resource
  private PromotionService promotionService; // 依赖注入

  @Subscribe
  public void handleRegSuccess(Long userId) {
    promotionService.issueNewUserExperienceCash(userId);
  }
}

