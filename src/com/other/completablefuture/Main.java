package com.other.completablefuture;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Shop> shops = List.of(new Shop("Big sale"), new Shop("Best shop"), new Shop("Just for you"), new Shop("SN"));
		ShopCrawler crawler = new ShopCrawler(shops);
//		System.out.println(crawler.getPricesFutureFor("Orange"));
//		crawler.getPricesWhenReadyFutureFor("Orange");
		crawler.findPrices("Orange");
	}

}
