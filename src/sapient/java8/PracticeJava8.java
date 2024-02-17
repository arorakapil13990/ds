package sapient.java8;

import java.util.*;
import java.util.stream.Collectors;

// https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062

public class PracticeJava8 {

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
        findUniqueCityWhereTraderWorks(traders);
        findTradersFromCambridgeAndSortByName(traders);
        getSingleStringNameSortAlphabetically(transactions);
        findTraderBasedInMilan(traders);
        findAllTransactionValueFromTradersInCambridge(transactions);
        findHighestValueOfTransaction(transactions);
        findSmallestValueTransaction(transactions);

    }

    public static void findTransactionInYear2011AndSortByValue(List<Transaction> transactions) {

        transactions.stream()
                .filter(d -> d.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::print);
        System.out.println();
    }

    public static void findUniqueCityWhereTraderWorks(List<Trader> traders) {
        traders.stream()
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::print);
        System.out.println();
    }

    public static void findTradersFromCambridgeAndSortByName(List<Trader> traders) {
        traders.stream()
                .filter(d -> d.getCity().equalsIgnoreCase("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::print);
        System.out.println();
    }

    public static void getSingleStringNameSortAlphabetically(List<Transaction> transactions) {
       String name = transactions.stream()
                .map(d -> d.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));

        System.out.println(name);
    }

    public static void findTraderBasedInMilan(List<Trader> traders) {
        traders.stream()
                .filter(d -> d.getCity().equalsIgnoreCase("Milan"))
                .forEach(System.out::print);

        traders.stream().anyMatch(d -> d.getCity().equalsIgnoreCase("Milan"));
        System.out.println();
    }

    public static void findAllTransactionValueFromTradersInCambridge(List<Transaction> transactions) {
        transactions.stream()
                .filter(d -> d.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::print);

        System.out.println();
    }

    public static void findHighestValueOfTransaction(List<Transaction> transactions){

        transactions.stream().mapToInt(Transaction::getValue).max().ifPresent(System.out::print);

        System.out.println();

        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .ifPresent(System.out::print);

        System.out.println();
    }

    public static void findSmallestValueTransaction(List<Transaction> transactions){
        transactions.stream()
                .reduce((a,b) -> a.getValue() < b.getValue()? a: b)
                .ifPresent(System.out::print);
        System.out.println();

        transactions.stream().min(Comparator.comparing(Transaction::getValue)).ifPresent(System.out::print);

        System.out.println();

        transactions.stream().collect(Collectors.minBy(Comparator.comparing(Transaction::getValue))).ifPresent(System.out::print);
    }
}
