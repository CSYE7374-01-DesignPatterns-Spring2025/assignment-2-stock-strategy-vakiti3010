package edu.neu.csye7374;

import java.util.Random;

public class BullMarketStrategy implements PriceStrategy {
    private final Random random = new Random();
    
    @Override
    public double calculateNewPrice(double currentPrice) {
        // In a bull market, prices tend to rise
        // Generate a random increase between 0.5% to 3%
        double increasePercentage = 0.5 + (random.nextDouble() * 2.5);
        return currentPrice * (1 + (increasePercentage / 100));
    }
}
