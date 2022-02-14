package dao;

import model.Bet;

import java.util.ArrayList;
import java.util.List;

public interface BetDAO {
    void add(Bet bet);
    List<Bet> getAll();
}
