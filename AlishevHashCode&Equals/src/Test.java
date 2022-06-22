import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<Person> hash = new HashSet<>();
        Person person1 = new Person(1, "Donald");
        Person person2 = new Person(1, "Donald");

        hash.add(person1);
        hash.add(person2);
        System.out.println(hash);

    }
}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
//Без этого по умоланию для программы обьекты являются разными, так как проверка идет по ссылке а обьекты наши имеют разное место в памяти и ссылаться на них нужно по разному конспект стр 35
    @Override
    public boolean equals(Object o) {                     //alt+insert и переопределяем методы хэш и икволз, чтобы показать программе как мы хотим сравнивать наши обьекты
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
