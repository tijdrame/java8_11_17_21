package lets_get_certified.lambdas.exostream;

import lets_get_certified.lambdas.exostream.pojos.AnotherBook;
import lets_get_certified.lambdas.exostream.pojos.Book;
import lets_get_certified.lambdas.exostream.pojos.Item;
import lets_get_certified.lambdas.exostream.pojos.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicsStream {
    public static void main(String[] args) {
        var intStream = IntStream.range(0, 5);
        System.out.println(String.format("AVG: %s", intStream.average()));

        var items = Arrays.asList(new Item(1, "Screw"),
                new Item(2, "Nail"), new Item(3, "Bolt"));
        // var resultConcat = items.stream().map(Item::getName).sorted().reduce("", (item1, item2) -> item1.concat(item2));
        // var resultConcat = items.stream().sorted(Comparator.comparing(Item::getName)).map(Item::getName).reduce("", String::concat);
        var resultConcat = items.stream().map(Item::getName).sorted().reduce("", String::concat);
        System.out.println(String.format("Output items: %s", resultConcat));//BoltNailScrew
        items.stream().map(Item::getName).sorted().forEach(System.out::println);

        var streamListString = Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"));
        streamListString.filter(strings -> strings.contains("c")).flatMap(Collection::stream).forEach(System.out::println);

        var intList = Arrays.asList(1, 2, 3);
        System.out.println(String.format("Sum is: %s", intList.stream().mapToInt(value -> value).sum()));
        System.out.println(String.format("Max is: %s", intList.stream().mapToInt(value -> value).max().getAsInt()));

        var people = Arrays.asList(new Person("Alan", "Burke", 22),
                new Person("Zoe", "Peters", 20),
                new Person("Peter", "Castle", 29));
        System.out.println(String.format("The older is: %s", people.stream().max(Comparator.comparing(Person::getAge)).orElse(null)));

        intList = Arrays.asList(10, 47, 33, 23);
        System.out.println(String.format("The max is: %s", intList.stream().reduce(Integer::max).get()));
        System.out.println(String.format("The max is: %s", intList.stream().reduce(Integer.MIN_VALUE, Integer::max)));

        var grade1 = getGrade(50);
        var grade2 = getGrade(55);
        System.out.println(String.format("Grade 1: %s", grade1.orElse("UNKNOWN")));
        if (grade2.isPresent()) {
            grade2.ifPresent(s -> System.out.println(String.format("Grade 2: %s", s)));
        } else {
            grade2.orElse("Empty");
        }

        var books = Arrays.asList(new Book("Thinking in java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipes", 10.0));
        System.out.println(String.format("average with price > 10 is : %s", books.stream().filter(book -> book.getPrice() > 10)
                .mapToDouble(Book::getPrice).average().orElse(0)));
        System.out.println(String.format("average with price > 90 is : %s", books.stream().filter(book -> book.getPrice() > 90)
                .mapToDouble(Book::getPrice).average().orElse(0)));

        books = Arrays.asList(new Book("Atlas Shrugged", 10.0),
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0));
        var bookMap = books.stream().collect(Collectors.toMap(Book::getTitle, Book::getPrice));
        BiConsumer<String, Double> doubleBiConsumer = (s, aDouble) -> {
            if (s.startsWith("A")) {
                System.out.println(aDouble);
            }
        };
        bookMap.forEach(doubleBiConsumer);

        books = Arrays.asList(new Book("Gone with the wind", 5.0),
                new Book("Gone with the wind", 10.0),
                new Book("Atlas shrugged", 15.0));
        bookMap = books.stream().collect(Collectors.toMap(Book::getTitle, Book::getPrice, (aDouble, aDouble2) -> aDouble));
        Consumer<Map.Entry<String, Double>> func = e -> {
            if (e.getKey().startsWith("A")) {
                System.out.println("value: " + e.getValue());
            }
        };
        bookMap.entrySet().forEach(func);

        people = Arrays.asList(new Person("Bob", "Burke", 31),
                new Person("Paul", "Peters", 32),
                new Person("John", "Castle", 33));
        System.out.println(String.format("average is: %s", people.stream().filter(p -> p.getAge() < 30).mapToInt(Person::getAge).average().orElse(0.0)));

        Optional<Double> price = Optional.ofNullable(20.0);
        price.ifPresent(System.out::println);
        System.out.println(price.orElse(0.0));
        System.out.println(price.orElseGet(() -> 0.0));

        price = Optional.ofNullable(null);
        System.out.println(price);
        if (price.isEmpty()) {
            System.out.println("Empty");
        }
        price.ifPresent(System.out::println);

        Double x = price.orElse(44.0);
        System.out.println(x);
        //Double z = price.orElseThrow(()->new RuntimeException("Bad code"));
        //System.out.println(z);

        var anotherBooks = Arrays.asList(new AnotherBook("Gone with the wind", "Fiction"),
                new AnotherBook("Bourne Ultimatum", "Thriller"),
                new AnotherBook("The Client", "Thriller"));
        List<String> genreList = new ArrayList<>();
        genreList = anotherBooks.stream().map(AnotherBook::getGenre).collect(Collectors.toList());
        System.out.println(genreList);

        //12
        DoubleStream is = DoubleStream.of(0, 2, 4);
        System.out.println(String.format("Sum is : %s",is.filter(s -> s % 2 == 0).sum()));
        var od = Stream.of(1.0, 3.0);
        System.out.println(String.format("Avg is : %s",od.filter(s -> s % 2 == 0).mapToDouble(d-> d).average()));

        //13
        List<Integer> ls = Arrays.asList(11, 11, 22, 33, 33, 55, 66);
        System.out.println(String.format("match 11? %s",ls.stream().distinct().anyMatch(i -> i == 11)));
        System.out.println(String.format("match none ? %s",ls.stream().distinct().noneMatch(i -> i%11 > 0)));

        //14


    }

    public static Optional<String> getGrade(int marks) {
        Optional<String> grade = Optional.empty();
        if (marks > 50) {
            grade = Optional.of("PASS");
        } else {
            grade.of("FAIL");
        }
        return grade;
    }
}
