package lets_get_certified.lambdas.exo1.pojos;
import java.util.Objects;

public class Person {
    private Integer age;
    private String name;
    private Double height;

    public Person() {
    }

    public Person(Integer age, String name, Double height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return this.height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Person age(Integer age) {
        setAge(age);
        return this;
    }

    public Person name(String name) {
        setName(name);
        return this;
    }

    public Person height(Double height) {
        setHeight(height);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(age, person.age) && Objects.equals(name, person.name) && Objects.equals(height, person.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, height);
    }

    @Override
    public String toString() {
        return "{" +
            " age='" + getAge() + "'" +
            ", name='" + getName() + "'" +
            ", height='" + getHeight() + "'" +
            "}";
    }
    
}
