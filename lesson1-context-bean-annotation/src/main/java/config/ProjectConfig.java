package config;

import beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean("A") //use this annotation to tell spring to find that particular bean.
    // We can also specify the name like this Bean("A")
    // We can also specify the same name to each bean. And once the name is given to a bean.
    // It can't be called from the method name.
    // @Primary will work as it is in case of different or same bean names @Bean("BeanName")
    @Primary // use this annotation if you want to make a default bean,
    // helpful when you're using the same name for multiple methods or the same name given by the annotation @Bean("BeanName").
    public MyBean myBean1(){
        MyBean b = new MyBean();
        b.setText("Hello");
        return b;
    }

    @Bean("A")
    public MyBean myBean2(){
        MyBean b = new MyBean();
        b.setText("World");
        return b;
    }

}
