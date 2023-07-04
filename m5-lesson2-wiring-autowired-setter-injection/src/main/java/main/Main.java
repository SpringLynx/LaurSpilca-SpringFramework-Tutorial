package main;

import beans.Cat;
import beans.Owner;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Owner o1 = context.getBean(Owner.class);
        o1.setName("Wasim");

        Owner o2 = context.getBean(Owner.class);
        o2.setName("Shahzad");

        Owner o3 = context.getBean(Owner.class);
        o3.setName("Jerry");

        Cat c1 = context.getBean(Cat.class);
        c1.setName("Hosico");
        o1.setCat(c1);

        Cat c2 = context.getBean(Cat.class);
        c2.setName("Munchkin");
        o2.setCat(c2);

        Cat c3 = context.getBean(Cat.class);
        c3.setName("Tom");
        o3.setCat(c3);

        System.out.println(o1.toString());

        System.out.println(o2.toString());

        System.out.println(o3.toString());

        System.out.println(c1 == c2);

    }

}
