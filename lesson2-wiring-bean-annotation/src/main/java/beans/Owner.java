package beans;


public class Owner {

    private String name;
    private Cat cat;

    public void setCat(Cat cat) {
        this.cat = cat;
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
