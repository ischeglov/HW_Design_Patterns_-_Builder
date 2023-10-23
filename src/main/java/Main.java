public class Main {

    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("у " + mom + " есть сын, " + "\n" + son);

        try {
            // Не хватает обязательных полей
            Person friend = new PersonBuilder()
                    .setName("Евгений")
                    .setAge(32)
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            Person girlfriend = new PersonBuilder()
                    .setName("Катерина")
                    .setSurname("Иванова")
                    .setAge(-100)
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
