package com.CricketGame.GameOfCricket.service.validator;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.beans.player.Player;

import java.util.*;

public class BattingOrderNumberValidator {

    private static boolean isInSequence(ArrayList<Integer> battingOrders){
        Collections.sort(battingOrders);

        Iterator<Integer> iter =  battingOrders.iterator();
        Integer current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
//            if (previous.compareTo(current) > 0) {
//                return false;
//            }
            if (previous+1 != current) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    public static boolean isValid(Team team){
        System.out.println("######################################");
        Set<Integer> battingOrders = new HashSet<>();

        for(Player player: team.getPlayers()){
            battingOrders.add(player.getBattingOrderNumber());
        }

        System.out.println(battingOrders.size() != team.getPlayers().size());
        System.out.println(!BattingOrderNumberValidator.isInSequence(new ArrayList<>(battingOrders)));
        return battingOrders.size() == team.getPlayers().size() &&
               BattingOrderNumberValidator.isInSequence(new ArrayList<>(battingOrders));
    }


}
