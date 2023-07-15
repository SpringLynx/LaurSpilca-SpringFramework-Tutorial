package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {

    @Autowired
    @Qualifier("es")
    private HelloService hs;

    public void sayHello(String name){
        String msg = hs.sayHello(name);
        System.out.println(msg);
    }
}
