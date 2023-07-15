package beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Qualifier("en")
@Primary
public class HelloServiceEn implements HelloService {

    private String name;

    @Override
    public String sayHello(String name) {

        return " Hello!" + " " + name ;
    }

}
