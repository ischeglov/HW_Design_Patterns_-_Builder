import java.util.Objects;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        if (age >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasAddress() {
        if (address != null) {
            return true;
        } else {
            return false;
        }
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age ++;
        }
    }

    @Override
    public String toString() {
        return "{ " +
                "Имя - " + name + "\n" +
                "Фамилия - " + surname + "\n" +
                "Возраст - " + age + "\n" +
                "Город жительства - " + address + " }" + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) &&
                surname.equals(person.surname) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAddress(address);
    }
}