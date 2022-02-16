package controller;

import dao.BetDAO;
import db.Storage;
import lib.Inject;
import model.Bet;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private BetDAO betDao;

   //@Inject
   // private Car car;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        int value;
        int risk;

        System.out.println("Введіть ставку та ризик для вашої ставки");
        while (true) {
            String[] betData = scanner.nextLine().split(" ");
            value = Integer.parseInt(betData[0]);
            risk = Integer.parseInt(betData[1]);

            Bet bet = new Bet(value, risk);
            betDao.add(bet);

            if (value < 5 & value > 0) {
                System.out.println("betAdd - " + value);
                Storage.bets.add(bet);
                break;
            } else {
                System.out.println("Ставка невірна.");
                System.out.println("Введіть ставку ");
            }
        }


    }
}
