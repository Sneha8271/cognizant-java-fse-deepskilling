public class FinancialForecastTest {

    public static void main(String[] args) {

        double initialValue = 100000;   // starting value, e.g. ₹1,00,000
        double growthRate = 0.08;       // 8% growth per year
        int years = 5;                  // forecast 5 years ahead

        double futureValue = FinancialForecaster.calculateFutureValue(initialValue, growthRate, years);

        System.out.println("Initial Value: " + initialValue);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Years: " + years);
        System.out.println("Forecasted Future Value: " + futureValue);
    }
}