package main;

import beans.Owner;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Owner o = context.getBean(Owner.class);
        System.out.println(o.toString());

    }

}
