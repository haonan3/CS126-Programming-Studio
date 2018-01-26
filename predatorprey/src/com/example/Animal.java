package com.example;

import java.awt.*;
import java.util.Random;

abstract class Animal {
    protected static Random random;
    private Color color;
    protected Cell cell;
    protected double weight;
    protected String type;
    protected boolean starvation = false;
    protected boolean natureDie = false;
    protected boolean beEaten = false;


    public Animal(Cell cell, Color color, double weight) {
        random = new Random();
        this.cell = cell;
        this.color = color;
        this.weight = weight;
    }

    public boolean isAlive() {
        boolean alive = true;
        if (beEaten || starvation || natureDie) {
            alive = false;
        }
        return alive;
    }

    public double getSize() {
        return 1 + Math.sqrt(weight);
    }

    public void draw(Graphics brush) {
        int x = cell.getRandomXInCell();
        int y = cell.getRandomYInCell();
        double size = getSize();
        brush.setColor(color);
        brush.fillRect(x, y, (int) size, (int) size);
    }

    /**
     * we except to get a wolf as a predator, but in some extreme cases, wolf will die out before rabbits,
     * so attemptToEat have a if else to check if it is a extreme case
     * @param predator an animal choose from current animal list randomly
     * @return whether be eaten
     */
    public boolean attemptToEat(Animal predator) {
        boolean success = false;
        if (predator.type.equals("wolf")) {
            Wolf wolf = (Wolf) predator;
            if (random.nextDouble() * predator.weight > 5 * random.nextDouble() * this.weight
                    && wolf.getEatPound() == 0 && this.type.equals("rabbit")) { //a rabbit be eaten by a hungry wolf
                beEaten = true;
                success = true;
                ((Wolf) predator).setEatPound(this.weight);
            }

            if (this.type.equals("wolf") // a wolf be eaten by a hungry wolf
                    && random.nextDouble() < wolf.getAttackWolfRate() && wolf.getEatPound() == 0
                    && random.nextDouble() * predator.weight > 5 * random.nextDouble() * this.weight) {
                beEaten = true;
                success = true;
                ((Wolf) predator).setEatPound(this.weight);
            }
        }else {
            beEaten = false; //a rabbit won't eat other animal
        }
        return success;
    }

    abstract void dies();

    abstract boolean update();

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
