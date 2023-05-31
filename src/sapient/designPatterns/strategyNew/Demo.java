package sapient.designPatterns.strategyNew;

import java.math.BigDecimal;
// https://www.digitalocean.com/community/tutorials/strategy-design-pattern-in-java-example-tutorial

// We could have used composition to create instance variable for strategies
// but we should avoid that as we want the specific strategy to be applied for a particular task.
// Same is followed in Collections.sort() and Arrays.sort() method that take comparator as argument.
public class Demo {
    public static void main(String[] args) {

        Discounter easterDiscount = amount -> amount.multiply(BigDecimal.valueOf(0.5)); // 50% discount

        System.out.println(easterDiscount.discount(new BigDecimal(100)));

        Discounter christmasDiscount = amount -> amount.multiply(BigDecimal.valueOf(0.9)); // 10% discount
        System.out.println(christmasDiscount.discount(new BigDecimal(100)));
    }
}
