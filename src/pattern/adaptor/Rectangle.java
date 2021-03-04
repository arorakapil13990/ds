package pattern.adaptor;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
    }

    @Override
    public void resize() {
        System.out.println("Resizing rectangle");
    }

    @Override
    public void description() {
        System.out.println("Circle rectangle");
    }
}

