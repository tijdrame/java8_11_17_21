package java21.assignment;

abstract public sealed class Department
        permits ComputerEngineeringDept, SoftwareEngineeringDept,
                SocialCareDept, AccountingDept{
}
