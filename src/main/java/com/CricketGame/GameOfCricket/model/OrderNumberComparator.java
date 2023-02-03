package com.CricketGame.GameOfCricket.model;

import java.util.Comparator;

public class OrderNumberComparator implements Comparator<Player>
{
    public int compare(Player c1, Player c2) {
        return c1.getOrderNumber() - c2.getOrderNumber();
    }
}