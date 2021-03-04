package pattern.adaptor;

public class Test {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        Shape triangle = new GeometricAdaptor(new Triangle());
        Shape rhombus = new GeometricAdaptor(new Rhombus());

        Drawing drawing = new Drawing();
        drawing.addShape(circle);
        drawing.addShape(rectangle);
        drawing.addShape(rhombus);
        drawing.addShape(triangle);

        drawing.drawShape();
    }
}
