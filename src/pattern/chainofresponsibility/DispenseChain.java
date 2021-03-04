package pattern.chainofresponsibility;

public interface DispenseChain {

    void setNextHandler(DispenseChain dispenseChain);

    void dispense(Currency currency);
}
