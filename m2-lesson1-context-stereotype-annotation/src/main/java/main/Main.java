package main;

import beans.MyBean;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        MyBean b1 = context.getBean(MyBean.class);
        System.out.println(b1.getText());

        MyBean b2 = context.getBean(MyBean.class);
        System.out.println(b2.getText());

        MyBean b3 = context.getBean(MyBean.class);
        System.out.println(b3.getText());

    }

}
