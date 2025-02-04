package edu.neu.csye7374;

import java.util.Random;

public class BearMarketStrategy implements PriceStrategy {
    private final Random random = new Random();
    
    @Override
    public double calculateNewPrice(double currentPrice) {
        // In a bear market, prices tend to fall
        // Generate a random decrease between 0.5% to 2.5%
        double decreasePercentage = 0.5 + (random.nextDouble() * 2.0);
        return currentPrice * (1 - (decreasePercentage / 100));
    }
}
