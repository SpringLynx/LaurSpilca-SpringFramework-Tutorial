package config;

import beans.Cat;
import beans.Owner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "beans")
public class ProjectConfig {

 /*   @Bean
    public Owner owner(){
        Owner o = new Owner();
        o.setName("Mike");
        o.setCat(cat());
        return o;
    }
*/

  /*  @Bean("Hosico")
    public Cat cat(){
        Cat c = new Cat();
        c.setName("Munchkin");
        return c;
    }*/


}
