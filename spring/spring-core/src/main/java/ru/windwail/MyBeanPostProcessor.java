package ru.windwail;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(bean.getClass().isAnnotationPresent(MyMarker.class)) {
            try {
                Method m = bean.getClass().getMethod("third", null);
                m.setAccessible(true);
                m.invoke(bean, null);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if(bean.getClass().isAnnotationPresent(MyMarker.class)) {
            try {
                Method m = bean.getClass().getMethod("fourth", null);
                m.setAccessible(true);
                m.invoke(bean, null);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return bean;
    }
}
