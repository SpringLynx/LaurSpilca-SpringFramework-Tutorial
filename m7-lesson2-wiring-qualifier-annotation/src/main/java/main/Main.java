package main;

import beans.Cat;
import beans.Owner;
import beans.Person;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person p = context.getBean(Person.class);
        p.sayHello("Wasim");


        // It is just requesting to get the bean by name.
        // Has nothing to do with this exercise of @Qualifier annotation
        Cat c1 = context.getBean("Hosico", Cat.class);
        c1.setName("Hosico");

        Owner o1 = context.getBean(Owner.class);
        o1.setName("Wasim");
        o1.sayHello(o1.getName());


        Owner o2 = context.getBean(Owner.class);
        o2.setName("Shahzad");
        o2.sayHello(o2.getName());

        Owner o3 = context.getBean(Owner.class);
        o3.setName("Jerry");
        o3.sayHello(o3.getName());


        System.out.println(o1.toString());

        System.out.println(o2.toString());

        System.out.println(o3.toString());

        System.out.println(c1 == o1.getCat());

    }

}
