package pattern.chainofresponsibility;

public class Test {

    public static void main(String[] args) {

        Currency currency = new Currency(120);
        DispenseChain dispenseChainOf50 = new Dollar50Dispenser();
        DispenseChain dispenseChainOf20 = new Dollar20Dispenser();
        DispenseChain dispenseChainOf10 = new Dollar10Dispenser();

        dispenseChainOf50.setNextHandler(dispenseChainOf20);
        dispenseChainOf20.setNextHandler(dispenseChainOf10);

        dispenseChainOf50.dispense(currency);

    }
}
