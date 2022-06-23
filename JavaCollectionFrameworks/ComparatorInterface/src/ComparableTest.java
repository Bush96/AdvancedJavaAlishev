import java.util.*;
//конс 37
public class ComparableTest {
    public static void main(String[] args) {
        List<Person1> peopleArray = new ArrayList<>();
        Set<Person1> peopleTree = new TreeSet<>();

        addPeoples(peopleArray);
        addPeoples(peopleTree);

        Collections.sort(peopleArray);
        //необходимости сортирова тьТрисет нет, он жедает это по умолчанию, но обязательно сперва Компарбл вьебать

        System.out.println(peopleArray);
        System.out.println(peopleTree);
    }

    public static void addPeoples(Collection collection) {     //все ясно как божий день
        collection.add(new Person1(1, "Bob"));
        collection.add(new Person1(5, "Jerry"));
        collection.add(new Person1(3, "Mike"));
    }
}

class Person1 implements Comparable<Person1> {      //implements Comparable<Person1> - штука дрюка которая делает обьект способным сравнивать себя с другими обьектами, практиески то же то и компаратор, который сам выступал в качестве сравнивателя
    private int id;
    private String name;

    public Person1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person1 person1 = (Person1) o;
        return id == person1.id && Objects.equals(name, person1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person1 o) {                 //способ сравнививать свои обьекты по длине их имени, контракт тот же что и у компаратора
        if (this.name.length() > o.getName().length()) {
            return 1;
        } else if (this.name.length() < o.getName().length()) {
            return -1;
        } else {
            return 0;
        }
    }
}