package ru.windwail;

/**
 * Created by icetusk on 22.07.16.
 */
public class MyController implements MyControllerMBean {
    @Override
    public void setEnabled(boolean enabled) {
        System.out.println("==================>>>>>>>>>>>>>>>>>>>> BOOM !!!!!!");
    }
}
