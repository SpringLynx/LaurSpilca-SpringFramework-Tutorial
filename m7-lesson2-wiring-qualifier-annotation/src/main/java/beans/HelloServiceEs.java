package beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Qualifier("es")
public class HelloServiceEs implements HelloService{

    @Override
    public String sayHello(String name) {
        return "Hola!" + " " + name;
    }

}
