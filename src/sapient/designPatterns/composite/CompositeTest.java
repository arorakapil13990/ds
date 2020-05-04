package sapient.designPatterns.composite;

public class CompositeTest {

    public static void main(String[] args) {

        SalesDepartment sd = new SalesDepartment(1, "sales");
        FinancialDepartment fd = new FinancialDepartment(1, "financial");

        HeadDepartment hd = new HeadDepartment(1, "head");

        hd.addDepartment(sd);
        hd.addDepartment(fd);
        hd.printDepartmentName();
    }
}
