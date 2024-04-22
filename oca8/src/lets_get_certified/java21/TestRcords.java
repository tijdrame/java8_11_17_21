package lets_get_certified.java21;

public class TestRcords {
    public static void main(String[] args) {
        records();
    }
    public static void records(){
        Person p1 = new Person("Joe Bloggs", 22);
        System.out.println(p1);
        System.out.println(p1.name() + "; "+ p1.age());
        patternMatching(p1);
        patternMatching("abc");

        Pair<String> pairS = new Pair<>("Sean", "Kennedy");
        Pair<Integer> pairI = new Pair<>(10, 20);
        patternMatching(pairS);
        patternMatching(pairI);

        Person p2 = new Person("Tij Dramé", 46);
        nonNesting(p1);
        Player player1 = new Player(p1, Ability.WEAK);
        Player player2 = new Player(p2, Ability.STRONG);
        Doubles dbles = new Doubles(player1, player2);
        nesting(dbles);
    }
    public static void patternMatching(Object obj){
        if(obj instanceof Person person){
            System.out.println("PM: "+person.name()+"; "+person.age());
        }else if (obj instanceof Pair pair){
            System.out.println("PM: "+pair.x()+"; "+pair.y());
        }
    }
    public static void nonNesting(Object obj){
        if(obj instanceof Person(String s, Integer age)){
            System.out.println(s + "; "+ age);
        }
    }
    public static void nesting(Doubles dbles){
        if(dbles instanceof Doubles(Player pl1, Player pl2)){
            System.out.println(pl1.person() + "; "+ pl2.person());
        }
        if(dbles instanceof Doubles(Player(Person p1, Ability ability), Player pl2)){
            System.out.println(p1.name() +"; "+p1.age()+"; "+ability.name());
        }
    }
}
