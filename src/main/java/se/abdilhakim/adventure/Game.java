
package se.abdilhakim.adventure;

import se.abdilhakim.adventure.model.Burglar;
import se.abdilhakim.adventure.model.Resident;

public class Game {
    private boolean fryingPanFound = false;  // För att hålla reda på om stekpannan har hittats
    private boolean burglarKnockedOut = false; // För att hålla reda på om tjuven är besegrad
    private boolean running = true;
    private Resident resident;
    private Burglar burglar;

    public Game() {
        resident = new Resident();
        burglar = new Burglar();
    }

    public void enterRoom(String room) {
        switch (room.toLowerCase()) {

            case "vardagsrummet":
                System.out.println("Du är i vardagsrummet nu, välja andra rum.");
                break;
            case "köket":
                if (!fryingPanFound) {
                    System.out.println("Du hittar en stekpanna! Din skada ökar.");
                    resident.addDamage(3);
                    fryingPanFound = true;
                } else {
                    System.out.println("köket är tomt nu. Stekpannan är redan tagen.");
                }
                break;
            case "sovrummet":
                System.out.println("Det händer inget här, kolla andra rum.");
                break;
            case "hall":
                startFight();
                break;
            case "kontoret":
                if (burglarKnockedOut) {
                    System.out.println("Du ringer polisen och spelet är över.");
                    running = false;
                } else {
                    System.out.println("kontoret är tomt, men du är för stressad för att tänka klart.");
                }
                break;
            default:
                System.out.println("Det rummet finns inget.");
        }
    }

    private void startFight() {
        System.out.println("Du möter inbrottstjuven!");
        //Loopen körs så länge båda är vid medvetande
        while (resident.isConscious() && burglar.isConscious()) {
            resident.punch(burglar);
            if (burglar.isConscious()) {
                burglar.punch(resident);
            } else {
                burglarKnockedOut = true;
                System.out.println("Du har knockat inbrottstjuven!");
            }
        }
        // Konrollera om spelaren blev knockad
        if (!resident.isConscious()) {
            System.out.println("Du förlorade slagsmålet. Spelet är slut.");
            running = false; // Avslutar spelet om spelaren blir knockad
        }
    }

    public boolean isRunning() {
        return running;
    }
}