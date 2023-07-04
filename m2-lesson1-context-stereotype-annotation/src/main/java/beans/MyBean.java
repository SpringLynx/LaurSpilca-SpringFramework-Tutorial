package beans;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/*
 * Adding the @Component annotation will not enable the Spring to recognize it as a bean.
 * We also need to add another annotation on the ProjectConfig class, namely @ComponentScan(basePackages = "beansPackageName").
 * Things to remember:
 * 1. Keep in mind that adding @Component on the bean class and the @ComponentScan on the config class will not be enough.
 * 2. When you'll run the application you can see that the output would be null. Which means that Spring only declares the bean.
 * 3. In order to see something in action, some sort of default values for the bean instance needs to be provided.
 * 4. It means that you have to initialize the bean by yourself, using the @PostConstruct annotation which is borrowed from JEE by Spring.
 * 5. You can notice the commented code in the init method which is annotated with the @PostConstruct. Try to uncomment the
 * commented code and comment the uncommented code. And you'll see that nothing will happen and the output will be the same as of
 * on the 1st point. It shows that the initialization is something you have to do by yourself and notice the use of this pointer.
 * No new object instance is required. Spring is only responsible of the instances which are created by the Spring context.
 * 6. We can't create multiple instances of the same bean while using the @Component annotation.
 * Spring context will return the same instance always. That means it is by default Singleton.
 *
 * */
@Component
public class MyBean {

    private String text;

    @PostConstruct
    private void init(){
        /*MyBean b = new MyBean();
        b.setText("Hello");*/
        this.text = "Hello, from @PostConstruct";

    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
