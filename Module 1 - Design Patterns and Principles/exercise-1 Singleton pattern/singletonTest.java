public class singletonTest {

    public static void main(String[] args) {

        // Get first reference to Logger
        Logger logger1 = Logger.getInstance();
        logger1.log("First message from logger1");

        // Get second reference to Logger
        Logger logger2 = Logger.getInstance();
        logger2.log("Second message from logger2");

        // Step 4: Verify both references point to the SAME instance
        if (logger1 == logger2) {
            System.out.println("Singleton works: logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Singleton failed: different instances were created.");
        }
    }
}