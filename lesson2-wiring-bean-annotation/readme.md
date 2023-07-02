#First Wiring Exercise

In this exercise, we learn that how we can create the wiring between two beans.

In the beans package, we have a pojo for Owner and for a Cat.

Owner has a relationship with Cat. That's why you can see that the Cat instance
as a private member of the Owner class. 

In this exercise I didn't used any stereotype annotation for the beans.

Everything is done inside the ProjectConfig class. 

Where we can see that we have two helper methods which are helping us to create and return the instance
of the Owner and the Cat class. 

The only magic that you can see is happening in the config class.

Look at these two methods.

    @Bean
    public Owner Owner(){
        Owner o = new Owner();
        o.setName("Mike");
        o.setCat(cat());
        return o;
    }

    @Bean
    public Cat cat(){
        Cat c = new Cat();
        c.setName("Munchkin");
        return c;
    }
    
    Output:
    Owner{name='Mike', cat=Cat{name='Munchkin'}}


You can see that we are setting the cat in the owner bean method.

And inside that setCat call you can see we are not creating a new instance.
But we are calling our cat bean method to have an instance from the spring context.



    @Bean
    public Owner Owner(){
        Owner o = new Owner();
        o.setName("Mike");
        o.setCat(new Cat());
        return o;
    }

    @Bean
    public Cat cat(){
        Cat c = new Cat();
        c.setName("Munchkin");
        return c;
    }
    
    Output:
    Owner{name='Mike', cat=Cat{name='null'}}

You can notice that if we'll not use the instance managed by the spring context,
then we'll get the null for the cat name. However, the instance is still created
but its not returned by the context and we have to manage it throughout by ourselves.

Which is not a good idea.

