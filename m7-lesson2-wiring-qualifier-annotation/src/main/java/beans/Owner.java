package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Owner {

    private String name;

   /* @Autowired
    @Qualifier("es")
    private HelloService helloService;

    public void sayHello(String name){
        String msg = helloService.sayHello(getName());
        System.out.println(msg);
    }*/

    private final HelloService helloService;
    private final Cat cat;//We can now make the field final, so that no one can change it after initialization.
    // We have done it because of the dependency injection via constructor below with the @Autowired annotation.


    /*
    * This is something I wanted to test here. By putting to dependencies in the constructor.
    * Both of them are injected via spring context and using the @Qualifier for it.
    * I'm also used the HelloService which is an example of interface-programming.
    * We can also use the @Primary annotation on one of the implementation of the HelloService
    * to mark it as a primary bean. Primary bean will be injected, when @Qualifier is not specified
    * for the injection.
    * */
    @Autowired
    public Owner(@Qualifier("Hosico") Cat cat,
                 @Qualifier("es") HelloService helloService){
        this.cat = cat;
        this.cat.setName("Hosico Cat");
        this.helloService = helloService;

    }

    public void sayHello(String name) {
        String msg = this.helloService.sayHello(getName());
        System.out.println(msg);
    }


    /*@Autowired
    public Owner(@Qualifier("Munchkin") Cat cat, @Qualifier("es") HelloService helloService){
        this.cat = cat;
        this.name = name;
        this.helloService = helloService;
    }*/

    //You can't have constant(final) and setter together.
    /*public void setCat(Cat cat) {
        this.cat = cat;
    }*/

    public Cat getCat() {
        return cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  /*  @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", cat=" + cat +
                '}';
    }
*/

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", helloService=" + helloService.sayHello(getName()) +
                ", cat=" + cat +
                '}';
    }
}
