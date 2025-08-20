package com.careerit.jfs.cj.day19;
interface Game {
    void start();
    void play();
    void stop();
}
abstract class AbstractGame implements Game {
    public void start() {
        System.out.println("The game "+ this.getClass().getSimpleName() + " started");
    }
    public void stop() {
        System.out.println("The game "+ this.getClass().getSimpleName() + " stopped");
    }
}
class Bike extends AbstractGame implements Game {

    public void play() {
        System.out.println("You are playing " + this.getClass().getSimpleName()+" game, please wear helmet");
    }

}
class Car extends AbstractGame implements Game {

    public void play() {
        System.out.println("You are playing " + this.getClass().getSimpleName()+" game, please wear seatbelt and ensure co passengers are wearing seatbelt");
    }

}

class Boat extends AbstractGame implements Game {

    public void play() {
        System.out.println("You are playing " + this.getClass().getSimpleName()+" game, please wear life jacket and oxygen mask");
    }

}
public class GameManager {
    public static void main(String[] args) {
        Game[] games = new Game[]{new Bike(), new Car(), new Boat(), new Boat(), new Car(), new Bike(), new Boat()};

        for (Game game : games) {
            game.start();
            game.play();
            game.stop();
            System.out.println("------------------------------------");
        }
    }
}
