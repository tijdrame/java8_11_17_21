package lets_get_certified.switchs;

sealed abstract class Vehicle permits Car, Boat, Train {}
final class Car extends Vehicle {
    public String onroad() { return "I can move";}
}
final class Boat extends Vehicle {}
final class Train extends Vehicle {}
public class PatternMatchingSwitchExpression {
    public static void ifStatements(Vehicle v) {
        if(v instanceof Car car){//since java 16
            System.out.println("It's a car: "+ car.onroad());
        }else if (v instanceof Boat boat){
            System.out.println("It's a boat");
        }else if (v instanceof Train train){
            System.out.println("It's a train");
        }else {
            throw new IllegalArgumentException("Invalid type");
        }
    }
    public static void patternMatchingSwitch(Vehicle v) {
        switch (v){
            case Car c -> {
                System.out.println("It's a car: "+ c.onroad());
            }
            case Boat b -> System.out.println("It's a boat");
            case Train t -> System.out.println("It's a train");
            default -> throw new IllegalArgumentException("Invalid type");
        }
    }

    public static void main(String[] args) {
        ifStatements(new Car());
        ifStatements(new Boat());
        ifStatements(new Train());

        patternMatchingSwitch(new Car());
        patternMatchingSwitch(new Boat());
        patternMatchingSwitch(new Train());
    }
}
