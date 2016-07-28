package ru.windwail;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * Created by icetusk on 22.07.16.
 */
@Component
@MyMarker
public class SimpleBean {

    MyController controller = new MyController();

    public SimpleBean() {
        System.out.println("======> Constructor called");
    }

    @PostConstruct
    public void post() {
        System.out.println("======> PostConstruct called");
        try {
            ManagementFactory.getPlatformMBeanServer().registerMBean(controller, new ObjectName("myconnection","name","mycontroller"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void third() {
        System.out.println("======> BeanPostPorcessor  before");
    }

    public void fourth() {
        System.out.println("======> BeanPostPorcessor  after");
    }


}
