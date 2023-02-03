package com.CricketGame.GameOfCricket.model;

public class Player{
    private String name;
    private  int orderNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Batsman getAsABatsman() {
        return asABatsman;
    }

    public void setAsABatsman(Batsman asABatsman) {
        this.asABatsman = asABatsman;
    }

    public Bowler getAsABowler() {
        return asABowler;
    }

    public void setAsABowler(Bowler asABowler) {
        this.asABowler = asABowler;
    }

    private Batsman asABatsman;
    private Bowler asABowler;

}