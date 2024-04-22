package lets_get_certified;

public record CarRecord(String regNumber, String owner) {
    public CarRecord{
        if (!owner.equalsIgnoreCase("tij")) {
            throw new IllegalArgumentException("c tij le bosss");
        }
    }
    public CarRecord(){
        this("      ", "tij");
    }
    @Override
    public String owner(){
        return owner.toUpperCase();
    }
}
class Test {
    public static void main(String[] args) {
        CarRecord car = new CarRecord("135", "tij");
        System.out.println(car);
        System.out.println(car.owner());
        CarRecord car2 = new CarRecord();
        System.out.println(car2);
    }
}
