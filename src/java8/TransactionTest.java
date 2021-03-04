package java8;

import sapient.java8.Trader;
import sapient.java8.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class TransactionTest {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        findTransactionInYear2011AndSortByValue(transactions);
        findUniqueCityWhereTraderWorks(transactions);
        findTradersFromCambridgeAndSortByName(transactions);
        getSingleStringNameSortAlphabetically(transactions);
        findTraderBasedInMilan(transactions);
        findAllTransactionValueFromTradersInCambridge(transactions);
        findHighestValueOfTransaction(transactions);
        findSmallestValueTransaction(transactions);

    }

    public static void findTransactionInYear2011AndSortByValue(List<Transaction> transactions) {
        System.out.println("----findTransactionInYear2011AndSortByValue----");
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
    }

    public static void findUniqueCityWhereTraderWorks(List<Transaction> transactions) {
        System.out.println("----findUniqueCityWhereTraderWorks----");
        transactions.stream().map(tr -> tr.getTrader().getCity()).distinct().forEach(System.out::println);
        System.out.println("---findUniqueCityWhereTraderWorks-----");
        transactions.stream().map(tr -> tr.getTrader().getCity()).collect(Collectors.toSet()).forEach(System.out::println);
    }

    public static void findTradersFromCambridgeAndSortByName(List<Transaction> transactions) {
        System.out.println("----findTradersFromCambridgeAndSortByName----");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equalsIgnoreCase("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
    }

    public static void getSingleStringNameSortAlphabetically(List<Transaction> transactions) {
        System.out.println("----getSingleStringNameSortAlphabetically----");
        System.out.println(transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining("-")));
        System.out.println("----getSingleStringNameSortAlphabetically----");
        System.out.println(transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce("", (a,b) -> a+b + "-"));

    }

    public static void findTraderBasedInMilan(List<Transaction> transactions) {
        System.out.println("----findTraderBasedInMilan----");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equalsIgnoreCase("Milan"))
                .forEach(System.out::println);
    }

    public static void findAllTransactionValueFromTradersInCambridge(List<Transaction> transactions) {
        System.out.println("----findAllTransactionValueFromTradersInCambridge----");
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    public static void findHighestValueOfTransaction(List<Transaction> transactions) {
        System.out.println("----findHighestValueOfTransaction----");
        System.out.println(transactions.stream().map(Transaction::getValue).reduce(Integer::max).get());
    }

    public static void findSmallestValueTransaction(List<Transaction> transactions) {
        System.out.println("----findSmallestValueTransaction----");
        System.out.println(transactions.stream().map(Transaction::getValue).reduce(Integer::min).get());
        System.out.println("----findSmallestValueTransaction----");
        System.out.println(transactions.stream().min(Comparator.comparing(Transaction::getValue)));
    }
}
