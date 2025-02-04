package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;
    private List<Stock> stocks;
    
    // Private constructor for Singleton
    private StockMarket() {
        stocks = new ArrayList<>();
    }
    
    // Lazy initialization of Singleton
    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }
    
    public void addStock(Stock stock) {
        stocks.add(stock);
    }
    
    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }
    
    public void showAllStocks() {
        if (stocks.isEmpty()) {
            System.out.println("No stocks in the market");
            return;
        }
        
        for (Stock stock : stocks) {
            System.out.println(stock);
            System.out.println("Performance Metric: " + stock.getMetric());
            System.out.println("-------------------");
        }
    }

    public static void demo() {
        System.out.println("============ Stock Market Demo ============");
        
        // Get the stock market instance
        StockMarket market = StockMarket.getInstance();
        
        // Create factories
        StockFactory regularIBMFactory = new IBMStockFactory();
        StockFactory regularGoogleFactory = new GoogleStockFactory();
        StockFactory regularMicrosoftFactory = new MicrosoftStockFactory();
        
        // Get singleton factories
        StockFactory singletonIBMFactory = IBMStockLazySingletonFactory.getInstance();
        StockFactory singletonGoogleFactory = GoogleStockEagerSingletonFactory.getInstance();
        StockFactory singletonMicrosoftFactory = MicrosoftStockLazySingletonFactory.getInstance();
        
        // Create different types of stocks using factories
        Stock ibmStock = singletonIBMFactory.createStock("IBM", 131.15, "IBM Common Stock");
        Stock googleStock = singletonGoogleFactory.createStock("Google", 200, "Google Cloud Stock");
        Stock microsoftStock = singletonMicrosoftFactory.createStock("Microsoft", 350.00, "Microsoft Corporation Stock");
        
        // Create additional stocks using regular factories for demonstration
        Stock ibmStock2 = regularIBMFactory.createStock("IBM2", 132.15, "IBM Second Stock");
        Stock googleStock2 = regularGoogleFactory.createStock("Google2", 201, "Google Second Stock");
        Stock microsoftStock2 = regularMicrosoftFactory.createStock("Microsoft2", 351.00, "Microsoft Second Stock");
        
        // Add stocks to market
        market.addStock(ibmStock);
        market.addStock(googleStock);
        market.addStock(microsoftStock);
        market.addStock(ibmStock2);
        market.addStock(googleStock2);
        market.addStock(microsoftStock2);
        
        // Display initial state
        System.out.println("\nInitial Stock Market State:");
        market.showAllStocks();
        
        // Demonstrate trading with bids
        System.out.println("\nTrading Demonstration:");

        System.out.println("\n========== IBM Stock ==========");
        
        // Place bids for each IBM
        String[] ibmBids = {"120.50", "135.75", "128.90", "140.25", "133.80", "145.00"};
        
        for (String bid : ibmBids) {
            System.out.println("\nPlacing bid: " + bid);
            ibmStock.setBid(bid);
            System.out.println("Updated IBM Stock:");
            System.out.println(ibmStock);
            System.out.println("Performance Metric: " + ibmStock.getMetric());
            System.out.println("--------------------------------");
        }

        System.out.println("\n========== Google Stock ==========");
        // Place bids for Google stock
        String[] googleBids = {"210.50", "220.75", "215.90", "225.25", "230.80", "240.00"};
        
        for (String bid : googleBids) {
            System.out.println("\nPlacing bid: " + bid);
            googleStock.setBid(bid);
            System.out.println("Updated Google Stock:");
            System.out.println(googleStock);
            System.out.println("Performance Metric: " + googleStock.getMetric());
            System.out.println("--------------------------------");
        }

        System.out.println("\n========== Microsoft Stock ==========");
        // Place bids for Microsoft stock
        String[] microsoftBids = {"355.50", "360.75", "358.90", "365.25", "370.80", "375.00"};
        
        for (String bid : microsoftBids) {
            System.out.println("\nPlacing bid: " + bid);
            microsoftStock.setBid(bid);
            System.out.println("Updated Microsoft Stock:");
            System.out.println(microsoftStock);
            System.out.println("Performance Metric: " + microsoftStock.getMetric());
            System.out.println("--------------------------------");
        }

        // Show final market state
        System.out.println("\nFinal Stock Market State:");
        market.showAllStocks();
        
        System.out.println("\n========== Demo Complete ==========");
    }
} 