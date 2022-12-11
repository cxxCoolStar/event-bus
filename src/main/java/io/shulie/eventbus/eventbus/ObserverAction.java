package io.shulie.eventbus.eventbus;

import org.assertj.core.util.Preconditions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.util.Objects.requireNonNull;

/**
 * @author chenxingxing
 * @date 2022/12/11 11:56 上午
 * 观察者行为
 */
public class ObserverAction {
    private Object target;
    private Method method;

    public ObserverAction(Object target, Method method) {
        this.target = requireNonNull(target);
        this.method = method;
        this.method.setAccessible(true);
    }

    public void execute(Object event) { // event是method方法的参数
        try {
            method.invoke(target, event);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}