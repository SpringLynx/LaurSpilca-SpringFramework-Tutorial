# @Autowired Field Injection


This is the first use case of wiring the beans with @Autowired annotation.

In this exercise I have implemented two simple POJOs Cat and Owner.

The relationship between these two are of has-a relationship.

Owner has-a Cat.

You can notice that we marked both POJOs with the @Component annotation.
To let Spring-Context know that these are the beans you need to manage in the context.

And the use of @Autowired annotation is on the field, in the Owner class.
The annotation is obviously will go to the Cat field. 

And then in the main we get the Owner and the Cat instance from the context. 

You can notice a weird phenomenon that you can create multiple beans of the Cat class.
And only the latest one of them is got picked by the spring context to inject as a member of the Owner instance.

I also played around with the scope. You can do some logical checks in main by commenting 
the @Scope("prototype") annotation.

The things I have observed are as follows.

1. If you create multiple instances of the Cat. Only the last one will be linked with the Owner instance.
2. And same goes for the Owner. Only the most latest one will be picked by the spring context.
3. To change this behaviour you can use the @Scope("prototype") annotation then you can get different and multiple instances of the beans.