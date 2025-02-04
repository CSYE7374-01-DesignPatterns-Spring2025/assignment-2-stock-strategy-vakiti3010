package edu.neu.csye7374;

public class StrategyDemo {
    public static void demonstrateStrategyPattern() {
        // Create stocks with default Bull market strategy
        Stock googleStock = new GoogleStock("GOOGL", 2500.0, "Google Stock");
        Stock microsoftStock = new MicrosoftStock("MSFT", 300.0, "Microsoft Stock");
        Stock ibmStock = new IBMStock("IBM", 150.0, "IBM Stock");
        
        System.out.println("Initial State:");
        System.out.println("Google: " + googleStock.toString() + " Metric: " + googleStock.getMetric());
        System.out.println("Microsoft: " + microsoftStock.toString() + " Metric: " + microsoftStock.getMetric());
        System.out.println("IBM: " + ibmStock.toString() + " Metric: " + ibmStock.getMetric());
        
        // Simulate market activity with different strategies
        System.out.println("\nSimulating Bull Market for Google and Microsoft, Bear Market for IBM:");
        googleStock.setPriceStrategy(new BullMarketStrategy());
        microsoftStock.setPriceStrategy(new BullMarketStrategy());
        ibmStock.setPriceStrategy(new BearMarketStrategy());
        
        // Simulate trading days
        for (int i = 0; i < 3; i++) {
            System.out.println("\nDay " + (i + 1) + " Trading:");
            
            // Update prices using their respective strategies
            googleStock.updatePrice();
            microsoftStock.updatePrice();
            ibmStock.updatePrice();
            
            System.out.println("Google: " + googleStock.toString() + " Metric: " + googleStock.getMetric());
            System.out.println("Microsoft: " + microsoftStock.toString() + " Metric: " + microsoftStock.getMetric());
            System.out.println("IBM: " + ibmStock.toString() + " Metric: " + ibmStock.getMetric());
        }
        
        // Switch market strategies
        System.out.println("\nMarket Sentiment Changes - Switching Strategies:");
        googleStock.setPriceStrategy(new BearMarketStrategy());
        microsoftStock.setPriceStrategy(new BearMarketStrategy());
        ibmStock.setPriceStrategy(new BullMarketStrategy());
        
        // One more round of updates
        googleStock.updatePrice();
        microsoftStock.updatePrice();
        ibmStock.updatePrice();
        
        System.out.println("\nAfter Strategy Switch:");
        System.out.println("Google: " + googleStock.toString() + " Metric: " + googleStock.getMetric());
        System.out.println("Microsoft: " + microsoftStock.toString() + " Metric: " + microsoftStock.getMetric());
        System.out.println("IBM: " + ibmStock.toString() + " Metric: " + ibmStock.getMetric());
    }
}
