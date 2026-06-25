public class FinancialForecaster {

    // Recursive method to calculate future value
    // initialValue: starting amount (e.g., investment, revenue)
    // growthRate: growth rate per period, e.g. 0.08 for 8%
    // years: how many years into the future to forecast
    public static double calculateFutureValue(double initialValue, double growthRate, int years) {

        // Base case: 0 years means no growth applied yet, return the initial value as-is
        if (years == 0) {
            return initialValue;
        }

        // Recursive case: this year's value = (value after one less year) grown by one more period
        return calculateFutureValue(initialValue, growthRate, years - 1) * (1 + growthRate);
    }
}