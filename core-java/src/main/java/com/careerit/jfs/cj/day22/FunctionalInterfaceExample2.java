package com.careerit.jfs.cj.day22;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

interface Hello{

}
class Mango {

    private String color;
    private double weight;

    public Mango(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }
}



public class FunctionalInterfaceExample2 {

    public static void main(String[] args) {

        List<Mango> list = getMongo();
        // Get the red mangoes

        List<Mango> redMangoes = filter(list, (mango)-> "Red".equals(mango.getColor()));
        System.out.println("Total red mangoes : " + redMangoes.size());

        // Get the green mangoes with weight greater than 1.0

        List<Mango> greenWithWeightGreaterThan1 = filter(list,(mango)-> "Green".equals(mango.getColor()) && mango.getWeight() > 1.0);
        System.out.println("Total green mangoes with weight greater than 1.0 : " + greenWithWeightGreaterThan1.size());

        // Get the yellow mangoes with weight less than 1.0

        List<Mango> yellowWithWeightLessThan1 = filter(list,(mango)-> "Yellow".equals(mango.getColor()) && mango.getWeight() < 1.0);
        System.out.println("Total yellow mangoes with weight less than 1.0 : " + yellowWithWeightLessThan1.size());

        // Get the mangoes with weight between 0.5 and 1.0

        List<Mango> mangoesWithWeightBetween0And1 = filter(list,(mango)->mango.getWeight() > 0.5 && mango.getWeight() < 1.0);
        System.out.println("Total mangoes with weight between 0.5 and 1.0 : " + mangoesWithWeightBetween0And1.size());

    }

    public static List<Mango> filter(List<Mango> mongoes, Predicate<Mango> predicate) {
        List<Mango> filteredMangoes = new ArrayList<>();
        for (Mango m : mongoes) {
            if (predicate.test(m)) {
                filteredMangoes.add(m);
            }
        }
        return filteredMangoes;
    }

    public static List<Mango> getMongo() {
        List<Mango> list = new ArrayList<>();

        list.add(new Mango("Red", 1.0));
        list.add(new Mango("Green", 0.9));
        list.add(new Mango("Yellow", 1.2));
        list.add(new Mango("Red", 1.1));
        list.add(new Mango("Green", 1.05));
        list.add(new Mango("Yellow", 1.15));
        list.add(new Mango("Red", 0.95));
        list.add(new Mango("Green", 1.08));
        list.add(new Mango("Yellow", 0.98));
        list.add(new Mango("Red", 1.25));
        list.add(new Mango("Green", 1.3));
        list.add(new Mango("Yellow", 1.18));
        list.add(new Mango("Red", 1.4));
        list.add(new Mango("Green", 1.22));
        list.add(new Mango("Yellow", 1.05));
        list.add(new Mango("Red", 1.12));
        list.add(new Mango("Green", 1.19));
        list.add(new Mango("Yellow", 1.09));
        list.add(new Mango("Red", 1.03));
        list.add(new Mango("Green", 0.97));
        list.add(new Mango("Yellow", 1.25));
        list.add(new Mango("Red", 1.06));
        list.add(new Mango("Green", 1.13));
        list.add(new Mango("Yellow", 1.01));
        list.add(new Mango("Red", 1.29));
        list.add(new Mango("Green", 1.11));
        list.add(new Mango("Yellow", 0.94));
        list.add(new Mango("Red", 1.17));
        list.add(new Mango("Green", 1.21));
        list.add(new Mango("Yellow", 1.14));
        list.add(new Mango("Red", 0.89));
        list.add(new Mango("Green", 1.07));
        list.add(new Mango("Yellow", 1.2));
        list.add(new Mango("Red", 1.33));
        list.add(new Mango("Green", 1.15));
        list.add(new Mango("Yellow", 1.04));
        list.add(new Mango("Red", 0.92));
        list.add(new Mango("Green", 1.27));
        list.add(new Mango("Yellow", 1.23));
        list.add(new Mango("Red", 1.1));
        list.add(new Mango("Green", 1.16));
        list.add(new Mango("Yellow", 0.99));
        list.add(new Mango("Red", 1.26));
        list.add(new Mango("Green", 0.91));
        list.add(new Mango("Yellow", 1.19));
        list.add(new Mango("Red", 1.08));
        list.add(new Mango("Green", 1.06));
        list.add(new Mango("Yellow", 1.3));
        list.add(new Mango("Red", 1.07));
        list.add(new Mango("Green", 1.04));
        list.add(new Mango("Yellow", 1.12));
        return list;
    }


}
