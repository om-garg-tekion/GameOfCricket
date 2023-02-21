package com.CricketGame.GameOfCricket.model.beans.over;

import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.enums.Runs;
import com.CricketGame.GameOfCricket.model.keys.BallKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(BallKey.class)
public class Ball{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Id
    private Long inningId;

    @Id
    private Long matchId;

    //playedBy
    private Long batsmanId;

    //bowledBy
    private Long bowlerId;

    @Enumerated(EnumType.STRING)
    private Runs runs;

    private int ballNumber;

    @Transient
    private Player playedBy;
}
