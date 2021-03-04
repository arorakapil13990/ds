package pattern.chainofresponsibility;

public class Dollar50Dispenser implements DispenseChain {

    private DispenseChain next;

    @Override
    public void setNextHandler(DispenseChain dispenseChain) {
        this.next = dispenseChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getCurr() >= 50) {
            int numberOfNotes = currency.getCurr() / 50;
            int nextCurr = currency.getCurr() % 50;
            System.out.println(numberOfNotes + " Notes of 50$");
            if (nextCurr != 0)
                this.next.dispense(new Currency(nextCurr));
        } else {
            this.next.dispense(currency);
        }
    }
}
