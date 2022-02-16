import controller.ConsoleHandler;
import lib.Injector;
import model.Bet;

public class Main {
    public static void main(String[] args) {

        ConsoleHandler consoleHandler = null;
        try {
            consoleHandler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        consoleHandler.handle();

    }
}
