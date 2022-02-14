package dao.impl;

import dao.BetDAO;
import db.Storage;
import lib.Dao;
import model.Bet;

import java.util.List;

@Dao
public class BetDaoImpl implements BetDAO {
    @Override
    public void add(Bet bet) {
        Storage.bets.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.bets;
    }
}
