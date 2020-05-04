package sapient.designPatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class HeadDepartment implements Department {

    private int id;
    private String name;

    private List<Department> departments = new ArrayList<>();

    public HeadDepartment(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void printDepartmentName() {
        departments.forEach(Department::printDepartmentName);
    }


    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }
}
