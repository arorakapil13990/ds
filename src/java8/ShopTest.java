package java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ShopTest {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());
        test();
    }

    public static void test() {

        List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"),
                new Shop("ShopEasy"));

        long start = System.nanoTime();

        System.out.println(findPrices(shops, "iphone11"));
        long duration = ((System.nanoTime() - start) / 1000000);
        System.out.println("Done in " + duration + " msecs");
    }

    /*
    // using parallelStream || if using stream then it is synchronously and sequentially
    static List<String> findPrices(List<Shop> shops, String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f",shop.getName(),shop.getPrice(product)))
                .collect(Collectors.toList());
    }*/


    // using completable future
    static List<String> findPrices(List<Shop> shops, String product) {

        List<CompletableFuture<String>> futures = shops.stream()
                .map(shop ->
                        CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))))
                .collect(Collectors.toList());

        return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }


    /*public static void test() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();

        Future<Double> future = shop.getPriceAsSync("my favorite product");
        //System.out.println("Doing something else");
        long invocationTime = ((System.nanoTime() - start) / 1000000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        try {
            double price = future.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1000000);
        System.out.println("Price returned after " + retrievalTime + " msecs");

    }*/


    /*static List<String> findPrice(List<Shop> shops, String product){

        List<CompletableFuture<String>> futures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product)))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote)),executor) )
                .collect(Collectors.toList());

        return return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());;
    }*/
}
