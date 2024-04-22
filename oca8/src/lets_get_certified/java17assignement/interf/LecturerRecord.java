package lets_get_certified.java17assignement.interf;

public record LecturerRecord(String name, Integer age, Faculty faculty, Department department){
    public LecturerRecord {
        if(name.isBlank() || age<0) {
            String errorMsg = """
                    Illegal argument passed:
                    "name": %s,
                    "age": %d
                    """.formatted(name, age);
            throw new IllegalArgumentException("\n" + errorMsg);
        }
    }
    public boolean hasPhd(){
        String prefix = name.toUpperCase().substring(0,3);
        String suffix = name.toUpperCase().substring(name.length()-3);
        return switch (prefix){
            case "DR."-> true;
            default ->
                switch (suffix){
                case "PHD"-> true;
                    default -> false;
                };
        };
    }
    public void wichFaculty(){
        switch (faculty){
            case EngineeringFaculty eng -> {
                System.out.println("Faculty of: "+eng);
                eng.engineering();
            }
            case HumanitiesFaculty hum -> {
                System.out.println("Faculty of: "+hum);
                hum.humanities();
            }
            case BusinessFaculty bus -> {
                System.out.println("Faculty of: "+bus);
                bus.business();
            }
            default -> throw new IllegalArgumentException("Invalid faculty: "+faculty);
        }
    }
    public void wichDept(){
        switch (department){
            case ComputerEngineeringDept ce -> {
                System.out.println("dept of: "+ce);
                ce.compEng();
            }
            case SoftwareEngineeringDept se -> {
                System.out.println("dept of: "+se);
                se.swEng();
            }
            case SocialCareDept sc -> {
                System.out.println("dept of: "+sc);
                sc.socialCare();
            }
            case AccountingDept ac -> {
                System.out.println("dept of: "+ac);
                ac.accounting();
            }
            default -> throw new IllegalArgumentException("Invalid Department: "+department);
        }
    }
}
