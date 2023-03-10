package com.CricketGame.GameOfCricket.model.beans;

import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.keys.TeamKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@IdClass(TeamKey.class)
@Table(name = "team",
       indexes = {@Index(name = "idx_team_name", columnList = "name"),
               @Index(name = "idx_match_id", columnList = "match_id")})
public class Team{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Id
    @Column(name = "match_id")
    private Long matchId;

    @Transient
    private List<Player> players;

    private int totalRuns = 0;

    private int wickets = 0;

    @Column(name = "name")
    private String name;

    public Team(String name){
        this.name = name;
    }

}
