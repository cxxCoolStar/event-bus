package io.shulie.eventbus.service;

import org.springframework.stereotype.Service;

/**
 * @author chenxingxing
 * @date 2022/12/11 12:19 下午
 */
@Service
public class NotificationService {
    public void sendInboxMessage(Long userId, String s) {
        System.out.println("调用PromotionService#issueNewUserExperienceCash#userId"+userId+"s:"+s);
    }
}
