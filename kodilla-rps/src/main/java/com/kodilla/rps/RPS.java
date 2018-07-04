package com.kodilla.rps;

public class RPS {

     private GameInstructions gameInstructions = new GameInstructions();
     private PrerequisitiesRetriever prerequisitiesRetriever = new PrerequisitiesRetriever();
     private GameEngine gameEngine = new GameEngine();

    public void start() {
        prerequisitiesRetriever.retrieveData();
        gameInstructions.getGameInstructions();
        gameEngine.coreGame();
    }
}
