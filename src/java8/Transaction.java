package java8;

public class Transaction {

    private final int year;
    private final int value;
    private final Trader trader;

    public Transaction(int year, int value, Trader trader) {
        this.year = year;
        this.value = value;
        this.trader = trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    public Trader getTrader() {
        return trader;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "year=" + year +
                ", value=" + value +
                ", trader=" + trader +
                '}';
    }
}
