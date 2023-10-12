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
		Executor executor = Executors.newFixedThreadPool(shops.size(), run -> {
			Thread thread = new Thread(run);
			thread.setDaemon(true);
			return thread;
		});
		List<CompletableFuture<String>> futurePrices =  shops.stream().
				map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s:%.2f", shop.getName(), shop.getPriceFor(product)), executor)).
				collect(Collectors.toList());
		return futurePrices.stream().map(future -> future.join()).toList();
	}
}
