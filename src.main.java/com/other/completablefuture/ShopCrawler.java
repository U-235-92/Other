package com.other.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class ShopCrawler {

	private List<Shop> shops;

	public ShopCrawler(List<Shop> shops) {
		super();
		this.shops = shops;
	}
	
	public List<String> getPricesStreamFor(String product) {
		return shops.stream().map(shop -> String.format("%s:%.2f", shop.getName(), shop.getPriceFor(product))).collect(Collectors.toList());
	}
	
	public List<String> getPricesParallelStreamFor(String product) {
		return shops.parallelStream().map(shop -> String.format("%s:%.2f", shop.getName(), shop.getPriceFor(product))).collect(Collectors.toList());
	}
	
	public List<String> getPricesFutureFor(String product) {
		Executor executor = getExecutor();
		List<CompletableFuture<String>> futurePrices =  shops.stream().
				map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s:%.2f", shop.getName(), shop.getPriceFor(product)), executor)).
				collect(Collectors.toList());
		return futurePrices.stream().map(future -> future.join()).toList();
	}
	
	public void getPricesWhenReadyFutureFor(String product) {
		Executor executor = getExecutor();
		List<CompletableFuture<String>> futurePrices = shops.stream().
				map(shop -> CompletableFuture.supplyAsync(() -> shop.getDiscountPrice(product), executor)).toList();
		System.out.println(futurePrices.stream().map(future -> future.join()).toList());
		
	}
	
	public void findPrices(String product) {
		Executor executor = getExecutor();
		@SuppressWarnings("rawtypes")
		CompletableFuture[] futurePrices = shops.stream().
				map(shop -> CompletableFuture.supplyAsync(() -> shop.getDiscountPrice(product), executor)).
				map(future -> future.thenApply(Quote::parse)).
				map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor))).
				map(future -> future.thenAccept(System.out::println)).toArray(size -> new CompletableFuture[size]);
		CompletableFuture.allOf(futurePrices).join();
		
		
//		List<CompletableFuture<Void>> futurePrices = shops.stream().
//		map(shop -> CompletableFuture.supplyAsync(() -> shop.getDiscountPrice(product), executor)).
//		map(future -> future.thenApply(Quote::parse)).
//		map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor))).
//		map(future -> future.thenAccept(System.out::println)).toList();
//		futurePrices.stream().map(future -> future.join()).toList();
		
	}
	
	private Executor getExecutor() {
		Executor executor = Executors.newFixedThreadPool(shops.size(), run -> {
			Thread thread = new Thread(run);
			thread.setDaemon(true);
			return thread;
		});
		return executor;
	}
}
