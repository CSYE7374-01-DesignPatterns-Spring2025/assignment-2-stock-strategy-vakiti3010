package edu.neu.csye7374;

public abstract class Stock implements Tradeable {
    private String name;
    private double price;
    private String description;
    protected PriceStrategy priceStrategy;  // Added for Strategy pattern
    
    public Stock(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        // Default to Bull market strategy
        this.priceStrategy = new BullMarketStrategy();
    }
    
    // Strategy pattern methods
    public void setPriceStrategy(PriceStrategy strategy) {
        this.priceStrategy = strategy;
    }
    
    public void updatePrice() {
        double newPrice = priceStrategy.calculateNewPrice(getPrice());
        setPrice(newPrice);
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public abstract void setBid(String bid);
    
    @Override
    public abstract String getMetric();
    
    @Override
    public String toString() {
        return String.format("Stock[name=%s, price=%.2f, description=%s]", 
            name, price, description);
    }
}