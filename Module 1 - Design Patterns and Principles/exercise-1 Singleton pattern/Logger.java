public class Logger {

    // Step 2: private static instance of itself
    private static final Logger instance = new Logger();

    private int logCount = 0;

    // Step 2: private constructor
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Step 2: public static method to get the instance
    public static Logger getInstance() {
        return instance;
    }

    // Logging behavior
    public void log(String message) {
        logCount++;
        System.out.println("[LOG #" + logCount + "]: " + message);
    }
}