package sapient.designPatterns.strategyNew;

import java.math.BigDecimal;

public interface Discounter {
    BigDecimal discount(BigDecimal amount);
}
