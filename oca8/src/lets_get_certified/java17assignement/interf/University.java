package lets_get_certified.java17assignement.interf;


public class University {
    public static void main(String[] args) {
        LecturerRecord tij = new LecturerRecord("Tidiane", 22, new BusinessFaculty(), new SocialCareDept());
        System.out.println(tij);
        tij.wichFaculty();
    }
}
