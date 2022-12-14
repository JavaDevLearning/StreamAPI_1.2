import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }


        System.out.println("Количество людей младше 18 лет");
        long count = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println(count);

        System.out.println("\nСписок фамилий мужчин призывного возраста");
        persons.stream()
                .filter(person -> person.getSex().equals(Sex.MAN))
                .filter(person -> person.getAge() >= 18 & person.getAge() <= 27)
                .map(person -> person.getFamily())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\nСписок мужчин с высшим образованием в возрасте от 18 до 65");
        persons.stream()
                .filter(person -> person.getSex().equals(Sex.MAN) & person.getEducation().equals(Education.HIGHER))
                .filter(person -> person.getAge() >= 18 & person.getAge() <= 65)
                .map(person -> person.getFamily())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\nСписок женщин с высшим образованием в возрасте от 18 до 60");
        persons.stream()
                .filter(person -> person.getSex().equals(Sex.WOMAN) & person.getEducation().equals(Education.HIGHER))
                .filter(person -> person.getAge() >= 18 & person.getAge() <= 60)
                .map(person -> person.getFamily())
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
