package lets_get_certified.lambdas.exo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdasAndMethodsReference {
    public static void main(String[] args) {
        //staticMR();
        //boundMR();
        //unboundMR();
        constructorMR();
    }
    public static void staticMR() {
        var integers = Arrays.asList(1,2,7,4,5);
        //Consumer<List<Integer>> consumer = l -> l.sort(Integer::compareTo);
        Consumer<List<Integer>> consumer = Collections::sort;
        consumer.accept(integers);
        System.out.println(integers);
    }
    public static void boundMR() {
        var name = "Mr. Joe Bloggs";
        Predicate<String> predicate = name::startsWith;
        System.out.println(predicate.test(name));
        System.out.println(predicate.test("Ms. Ann Bloggs"));
    }
    public static void unboundMR() {
        Predicate<String> predicate = String::isEmpty;
        System.out.println(predicate.test("yoyo"));
        System.out.println(predicate.test(""));

        BiPredicate<String, String> biPredicate = String::startsWith;
        System.out.println(biPredicate.test("Mr. Joe Blogg", "Mr."));
        System.out.println(biPredicate.test("Mr. Joe Blogg", "Ms."));
    }
    public static void constructorMR() {
        Supplier<List<String>> supplier = ArrayList::new;
        var list = supplier.get();
        list.add("lambda");
        System.out.println(list);

        Function<Integer, List<String>> function = ArrayList::new;// (n) -> new ArrayList<>(n);
        var l = function.apply(10);
        l.add("lambda");
        System.out.println(l.size());
    }
}
