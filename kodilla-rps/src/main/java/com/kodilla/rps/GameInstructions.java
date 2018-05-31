package com.kodilla.rps;

public class GameInstructions {

    private String gameInstructions;

    public GameInstructions() {
        this.gameInstructions =
        "Klawisze do obsługi gry:\n"+
        "klawisz 1 - zagranie \"kamień\"\n"+
        "klawisz 2 - zagranie \"papier\"\n"+
        "klawisz 3 - zagranie \"nożyce\"\n"+
        "klawisz x - zakończenie gry\n"+
        "klawisz n - uruchomienie gry od nowa\n";
    }

    public void getGameInstructions(){
        System.out.println(gameInstructions);
    }
}
