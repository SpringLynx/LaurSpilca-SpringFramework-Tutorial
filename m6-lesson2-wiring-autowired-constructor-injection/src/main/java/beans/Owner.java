package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Owner {

    private String name;
    private final Cat cat;//We can now make the field final, so that no one can change it after initialization.
    // We have done it because of the dependency injection via constructor below with the @Autowired annotation.

    @Autowired
    Owner(Cat cat){
        this.cat = cat;
        //this.cat.setName("Munchkin");
    }

    Owner(Cat cat, String name){
        this.cat = cat;
        this.name = name;
    }

    //You can't have constant and setter together.
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

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", cat=" + cat +
                '}';
    }
}
