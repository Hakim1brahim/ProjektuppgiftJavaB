package se.abdilhakim.adventure;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Välkommen till spelet! Du vaknar upp i ditt hus och hör ett ljud...");
        System.out.println("Kolla runt huset för att se vad som pågår.");

        while (game.isRunning()) {
            System.out.println("Välj rum (vardagsrummet, köket, sovrummet, hall eller kontoret)");
            String room = scanner.nextLine();
            game.enterRoom(room);
        }
        System.out.println("Spelaren är skyddad. Tack för att du spelade!");
        scanner.close();
    }
}