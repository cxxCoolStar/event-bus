package io.shulie.eventbus.service;

import org.springframework.stereotype.Service;

/**
 * @author chenxingxing
 * @date 2022/12/11 12:15 下午
 */
@Service
public class PromotionService {
    public void issueNewUserExperienceCash(Long userId) {
        System.out.println("调用PromotionService#issueNewUserExperienceCash#userId:"+userId);
    }
}
