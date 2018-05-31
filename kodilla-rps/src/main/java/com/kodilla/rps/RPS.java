package com.kodilla.rps;

public class RPS {

    public void start() {
        PrerequisitiesRetriever prerequisitiesRetriever = new PrerequisitiesRetriever();
        prerequisitiesRetriever.retrieveData();
        GameInstructions gameInstructions = new GameInstructions();
        gameInstructions.getGameInstructions();
        GameEngine gameEngine = new GameEngine();
        gameEngine.coreGame();
    }
}
