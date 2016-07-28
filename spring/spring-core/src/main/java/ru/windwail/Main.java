package ru.windwail;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by icetusk on 22.07.16.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("spring-config.xml");
        context.refresh();


        context.getBeanFactory();

        SimpleBean b = (SimpleBean) context.getBean(SimpleBean.class);

        System.out.println(b);

        while(true) {
            Thread.sleep(1000);
        }

    }
}
