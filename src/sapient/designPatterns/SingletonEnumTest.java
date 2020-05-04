package sapient.designPatterns;

enum SingletonEnum {
    INSTANCE;
}

public class  SingletonEnumTest{
    public static void main(String[] args) {

        SingletonEnum e1 = SingletonEnum.INSTANCE;
        SingletonEnum e2 = SingletonEnum.INSTANCE;

        System.out.println(e1.hashCode() == e2.hashCode());
    }
}

