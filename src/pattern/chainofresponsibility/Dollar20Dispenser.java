package pattern.chainofresponsibility;

public class Dollar20Dispenser implements DispenseChain {

    private DispenseChain next;

    @Override
    public void setNextHandler(DispenseChain dispenseChain) {
        this.next = dispenseChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getCurr() >= 20) {
            int numberOfNotes = currency.getCurr() / 20;
            int nextCurr = currency.getCurr() % 20;
            System.out.println(numberOfNotes + " Notes of 20$");
            if (nextCurr != 0)
                this.next.dispense(new Currency(nextCurr));
        } else {
            this.next.dispense(currency);
        }
    }
}
