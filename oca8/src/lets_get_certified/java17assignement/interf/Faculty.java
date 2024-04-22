package lets_get_certified.java17assignement.interf;

sealed interface Educational permits Faculty { }
public sealed abstract class Faculty implements Educational
        permits EngineeringFaculty, HumanitiesFaculty, BusinessFaculty {

}
final class EngineeringFaculty extends Faculty {
    public void engineering() {
        System.out.println("We teach computer sciences");
    }

    @Override
    public String toString() {
        return "Engineering";
    }
}
final class HumanitiesFaculty extends Faculty {
    public void humanities(){
        System.out.println("We teach social care, European studies etc..");
    }

    @Override
    public String toString() {
        return "Humanities";
    }
}
final class BusinessFaculty extends Faculty {
    public void business(){
        System.out.println("We teach accountancy, law, economics etc...");
    }

    @Override
    public String toString() {
        return "Business";
    }
}

