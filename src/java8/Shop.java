package java8;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    String name;

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    /*public Future<Double> getPriceAsSync(String product) {
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = getPrice(product);
                future.complete(price);
            }catch (Exception ex){
                future.completeExceptionally(ex);
            }

        }).start();
        return future;
    }*/

    public Future<Double> getPriceAsSync(String product) {
        return CompletableFuture.supplyAsync(() -> getPrice(product));
    }
}
