package com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces;

import com.CricketGame.GameOfCricket.model.beans.Innings;

public interface InningsService {

    /** This method will take innings entity and save it in the database
     * @param innings The innings that needs to be saved
     * @return returns innings object from the database.
     */
    Innings saveInnings(Innings innings);
}
