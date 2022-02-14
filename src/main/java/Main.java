import controller.ConsoleHandler;
import lib.Injector;
import model.Bet;

public class Main {
    public static void main(String[] args) {

        ConsoleHandler consoleHandler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        consoleHandler.handle();

    }
}
