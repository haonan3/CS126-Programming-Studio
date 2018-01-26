package com.example;

import java.awt.*;
import java.util.Random;

public class Wolf extends Animal {
    private static int count;
    private int daysSinceMeal;
    private double attackWolfRate; //there are three more variable excluded from UML
    private double eatPound;
    private double starvationRate;
    public static int getCount() {
        return count;
    }

    public Wolf(Cell cell) {
        super(cell, Color.BLACK, 10);
        this.cell = cell;
        random = new Random();
        weight = getWeight();
        count += 1;
        type = "wolf";
    }

    @Override
    void dies() { //eaten or starvation
        if (random.nextDouble() < starvationRate && eatPound == 0) {
            starvation = true;
            count -= 1;
        } else if (beEaten) {
            count -= 1;
        } else {
        }

    }

    @Override
    boolean update() {

        if (eatPound == 0) {
            weight = 0.98 * weight;
        } else {
            weight += 0.5 * eatPound;
            eatPound = 0;
        }
        //increase attack wolf rate
        if (daysSinceMeal == 0 && eatPound != 0) {
            daysSinceMeal = 1;
        } else {
            daysSinceMeal += 1;
        }
        starvationRate = 0.005 * daysSinceMeal;
        attackWolfRate = 0.05 * daysSinceMeal;
        Animal randomAnimal;//find a wolf but not this one
        do {
            randomAnimal = cell.getRandomCurrentAnimal();
        } while (randomAnimal.equals(this) && count > 1);   //if count = 1; it means equals(this) must true
        beEaten = attemptToEat(randomAnimal);
        dies(); //update dies, before birth
        brith();
        return false;
    }

    //Again, I think brith method should be taken from update()
    public void brith() {
        double brithRate = 0.2;
        if (weight > 50 && random.nextDouble() < brithRate && isAlive()) {
            Wolf litterWolf = new Wolf(cell);
            cell.addAnimal(litterWolf);
            weight -= 20;
        }

    }

    public void setEatPound(double eatPound) {
        this.eatPound = eatPound;
    }

    public double getAttackWolfRate() {
        return attackWolfRate;
    }

    public double getEatPound() {
        return eatPound;
    }

}
