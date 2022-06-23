import java.util.Objects;

public class Persons {
    private int id;
    private String name;

    public Persons(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persons persons = (Persons) o;
        return id == persons.id && name.equals(persons.name);
    }

    //(Object)->(int)
    //Сопоставляем обьекту целое число потому что числа сравнивать проще
    // Конспект ст 36
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
