package pattern.chainofresponsibility;

public class Dollar10Dispenser implements DispenseChain {

    private DispenseChain next;

    @Override
    public void setNextHandler(DispenseChain dispenseChain) {
        this.next = dispenseChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getCurr() >= 10) {
            int numberOfNotes = currency.getCurr() / 10;
            int nextCurr = currency.getCurr() % 10;
            System.out.println(numberOfNotes + " Notes of 10$");
            if (nextCurr != 0)
                this.next.dispense(new Currency(nextCurr));
        } else {
            this.next.dispense(currency);
        }
    }
}
