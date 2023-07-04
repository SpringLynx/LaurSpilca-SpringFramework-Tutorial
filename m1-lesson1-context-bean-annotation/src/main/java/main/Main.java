package main;

import beans.MyBean;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //If you have specified the name of the bean in the config class. Then you don't need to use the method name to
        //specify the bean. And can be called by name of the bean, specified like this in config class. @Bean("NameOfTheBean")
        //MyBean b1 = context.getBean("A", MyBean.class);
        MyBean b1 = context.getBean("A", MyBean.class);
        System.out.println(b1.getText());

        MyBean b2 = context.getBean("A", MyBean.class);
        System.out.println(b2.getText());
    }

}
