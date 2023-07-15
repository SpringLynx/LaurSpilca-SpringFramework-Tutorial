# Use of @Qualifier Annotation

I've found two ways to use the @Qualifier annotation. 

It is actually two step process. First you need to tell spring context the name of the beans. 

So, that means @Qualifier annotation requires the explicitly named beans to be called upon 
with the @Qualifier annotation at the time of dependency injection.

#### The use of @Qualifier annotation is a two step process.

1. Name the bean explicitly.
2. Use the @Qualifier annotation where you want the spring context to inject the bean by finding it by name.

Let's have a look at the code snippets where we are naming the beans.

Before moving to that point. Let's understand the system design we are working with in this example.

A class Owner 
A class Cat

Owner has-a relationship with Cat.

Code snippets for naming the beans.

Give a name to the bean with the stereotype annotation @Component in our case.
It can be done via Service & Repository annotations.

    @Component("Hosico")
    @Scope("prototype")
    public class Cat {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
        }
    }


The second way of naming the bean is by naming it inside the ProjectConfig class.
Where you can write a instance method and name it as follows.

    @Bean("Hosico")
    public Cat cat(){
        Cat c = new Cat();
        c.setName("Munchkin");
        return c;
    }


Now it's the time to calling it explicitly with the help of a qualified bean name. 
By using the @Qualifier annotation.

Remember, we can inject the dependency via Field, Setter and the Constructor method. 

Check the code sample below and use of the @Qualifier annotation.


    @Component
    @Scope("prototype")
    public class Owner {

    private String name;
    private final Cat cat;//We can now make the field final, so that no one can change it after initialization.
    // We have done it because of the dependency injection via constructor below with the @Autowired annotation.

    @Autowired
    public Owner(@Qualifier("Hosico") Cat cat){
        this.cat = cat;
        this.cat.setName("Munchkin");
    }

    public Owner(Cat cat, String name){
        this.cat = cat;
        this.name = name;
    }

    public Cat getCat() {
        return cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
            return "Owner{" +
                    "name='" + name + '\'' +
                    ", cat=" + cat +
                    '}';
            }
    }


However, the best use case of using the @Qualifier annotation is when you've multiple beans of same type but with 
some differences in their implementation. Have a look on the following example. 

    public interface PaymentService{
        Boolean validateCreditCard(String number);
    }
    
    @Service("stripePayment")
        public class StripePaymentService implements PaymentService {
        // Stripe-specific implementation
    }

    @Service("paypalPayment")
        public class PaypalPaymentService implements PaymentService {
        // PayPal-specific implementation
    }

And the rest is same. You know how to call a specific bean in any certain scenario.

Above you can see that we used the stereotype annotation to name the bean. But we can use the @Qualifier annotation
as well to name a bean. So, it can act in two ways. To name a bean. And to specify a bean along with @Autowired.


    public interface PaymentService{
        Boolean validateCreditCard(String number);
    }
    
    @Service
    @Qualifier("stripePayment")
        public class StripePaymentService implements PaymentService {
        // Stripe-specific implementation
    }

    @service
    @Qualifier("paypalPayment")
        public class PaypalPaymentService implements PaymentService {
        // PayPal-specific implementation
    }



And it can be called as follows.

    public void Payment{

    @Autowired
    @Qualifier("paypalPayment") //To specify the dependency by name.
    private PaymentService paymentService;    

    }

