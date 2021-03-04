package pattern.adaptor;

// Object Adapter Pattern
public class GeometricAdaptor implements Shape {
    GeometricShape geometricShape;

    public GeometricAdaptor(GeometricShape geometricShape) {
        this.geometricShape = geometricShape;
    }

    @Override
    public void draw() {
        geometricShape.drawShape();
    }

    @Override
    public void resize() {
        System.out.println("You can't resize");
    }

    @Override
    public void description() {
        if (geometricShape instanceof Triangle) {
            System.out.println("Triangle Object");
        }else if(geometricShape instanceof Rhombus){
            System.out.println("Rhombus Object");
        }else
            System.out.println("Unknown");
    }
}
