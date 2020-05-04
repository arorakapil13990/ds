package sapient.designPatterns.composite;

public class SalesDepartment implements Department {

    private int id;
    private String name;


    public SalesDepartment(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }
}
