package lets_get_certified.lambdas.exo1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.Function;

import lets_get_certified.lambdas.exo1.interfaces.Evaluate;
import lets_get_certified.lambdas.exo1.interfaces.Functionable;
import lets_get_certified.lambdas.exo1.interfaces.Printable;
import lets_get_certified.lambdas.exo1.interfaces.Retrievable;
import lets_get_certified.lambdas.exo1.pojos.Person;

public class BasicLambdas {
    public static void main(String[] args) {
        BasicLambdas basicLambdas = new BasicLambdas();
        //basicLambdas.consumer();
        //basicLambdas.supplier();
        //basicLambdas.predicate();
        //basicLambdas.function();
        var listPeople = getPeople();
        //basicLambdas.sortAge(listPeople);
        //basicLambdas.sortName(listPeople);
        basicLambdas.sortHeight(listPeople);
    }

    public void consumer() {
        Printable<String> lambdaPrint = p -> System.out.println(p);
        Printable<String> lambdaRef = System.out::println;
        lambdaPrint.print("test1");
        lambdaRef.print("test2");

        Consumer<String> consLambda = p -> System.out.println(p);
        Consumer<String> consRef = System.out::println;
        consLambda.accept("consumer1");
        consRef.accept("consumer2");
    }

    void supplier() {
        Retrievable<Integer> lambdaRetrieve = () -> 77;
        System.out.println(lambdaRetrieve.retrieve());
        Supplier<Integer> supRetrieve = () -> 77;
        System.out.println(supRetrieve.get());
    }

    void predicate() {
        Evaluate<Integer> evLambda = p -> p < 0;
        System.out.println(evLambda.isNegative(-1));
        System.out.println(evLambda.isNegative(+1));
        Predicate<Integer> evPredicate = p -> p < 0;
        System.out.println(evPredicate.test(-1));
        System.out.println(evPredicate.test(+1));

        System.out.println("check");
        System.out.println(check(4, p -> p % 2 == 0));
        System.out.println(check(7, p -> p % 2 == 0));

        System.out.println(check("Mr. Joe Bloggs", p -> p.startsWith("Mr.")));
        System.out.println(check("Mr. Joe Bloggs", p -> p.startsWith("Mr.")));

        Person mike = new Person(33, "Mike", 1.8);
        Person Ann = new Person(13, "Ann", 1.4);
        System.out.println("Mike " + check(mike, p -> p.getAge() >= 18));
        System.out.println("Ann " + check(Ann, p -> p.getAge() >= 18));
    }

    public static <T> boolean check(T test, Predicate<T> predicate) {
        return predicate.test(test);
    }

    void function() {
        Functionable<Integer, String> funcLambda = n -> String.format("Number is: %s", n);
        Function<Integer, String> funcFunction = n -> String.format("Number is: %s", n);
        System.out.println(funcLambda.applyThis(25));
        System.out.println(funcFunction.apply(25));
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person(33, "Mike", 1.8));
        result.add(new Person(25, "Mary", 1.4));
        result.add(new Person(34, "Alan", 1.7));
        result.add(new Person(30, "Zoe", 1.5));
        return result;
    }

    public void sortAge(List<Person> people) {
       people.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
    }

    public void sortName(List<Person> people) {
        people.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
    }

    public void sortHeight(List<Person> people) {
        people.stream().sorted(Comparator.comparing(Person::getHeight)).forEach(System.out::println);
    }
}
