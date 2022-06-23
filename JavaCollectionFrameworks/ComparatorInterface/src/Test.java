import java.util.*;

//конспект ст37

public class Test {
    public static void main(String[] args) {
        List<String> animal = new ArrayList<>();

        animal.add("Dog");
        animal.add("Cat");
        animal.add("Sponge");
        animal.add("Bob");

        Collections.sort(animal);   //естественная сортировка когда без класса расфиряющего компаратор
        System.out.println(animal);

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Bob"));
        persons.add(new Person(5, "Lorry"));
        persons.add(new Person(3, "Ken"));

        Collections.sort(persons, new Comparator<Person>() {      //persons, new Comparator<Person>() - сокращенный синтаксис чтбы не создавать специально класс для компаратора, далее логика как и с примитивами
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                } else if (o1.getId() < o2.getId()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }
}


class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        //o1->o2 =>1
        //o1<-o2 =>-1
        //o1==o2=>0
        //Конвенция логики метода, реалзовать его нужно таким образом чтобы условия возвращали 1.-1. либо 0,каждая цифра закрепляет за собой определенное условие
        if (o1.length() > o2.length()) {
            return -1;
        } else if (o1.length() < o2.length()) {
            return 1;
        } else {
            return 0;
        }
    }
}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
