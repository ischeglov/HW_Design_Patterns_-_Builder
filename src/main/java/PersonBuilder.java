public class PersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) throws IllegalArgumentException{
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не введено");
        } else {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException{
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Фамилия не введена");
        } else {
            this.surname = surname;
        } return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException{
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        } else {
            this.age = age;
        } return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalArgumentException{
        Person person;
        if (name == null || name.isEmpty() || surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Объекту не переданы обязательные поля");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        } else person = new Person(name, surname, age);
        person.setAddress(address);
        return person;
    }
}
