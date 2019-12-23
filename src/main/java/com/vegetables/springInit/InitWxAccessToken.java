package com.vegetables.springInit;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * spring容器初始化的时候  调用微信AccessToken线程
 *
 * @author Administrator
 */
public class InitWxAccessToken implements ApplicationListener<ContextRefreshedEvent> {


    /**
     * 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
     * <p>
     * 但是这个时候，会存在一个问题，在web 项目中（spring mvc），系统会存在两个容器，一个是root application context ,
     * 另一个就是我们自己的 projectName-servlet context（作为root application context的子容器）。
     * 这种情况下，就会造成onApplicationEvent方法被执行两次。为了避免上面提到的问题，
     * 我们可以只在root application context初始化完成后调用逻辑代码，其他的容器的初始化完成，则不做任何处理
     */
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {//root application context 没有parent，他就是老大.


           /* System.out.println("--------------------------------------------------");
            System.out.println("------spring容器初始化时调用获取微信token线程-------");
            System.out.println("--------------------------------------------------");
            new Thread(new TokenThread()).start();*/
        }
    }

}
