package main;

import beans.Cat;
import beans.Owner;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // It is just requesting to get the bean by name.
        // Has nothing to do with this exercise of @Qualifier annotation
        Cat c1 = context.getBean("Hosico", Cat.class);
        c1.setName("Hosico");

        Owner o1 = context.getBean(Owner.class);
        o1.setName("Wasim");

        Owner o2 = context.getBean(Owner.class);
        o2.setName("Shahzad");

        Owner o3 = context.getBean(Owner.class);
        o3.setName("Jerry");


        System.out.println(o1.toString());

        System.out.println(o2.toString());

        System.out.println(o3.toString());

        System.out.println(c1 == o1.getCat());

    }

}
