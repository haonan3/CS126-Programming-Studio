package com.example;

import java.awt.*;
import java.util.Random;

public class Rabbit extends Animal {
    private static int count;
    private double hungerDeficit;


    public static int getCount() {
        return count;
    }

    public Rabbit(Cell cell) {
        super(cell, Color.YELLOW, 1);
        this.cell = cell;
        random = new Random();

        type = "rabbit";
        weight = getWeight();
        count += 1;
    }

    public void dies() {
        if (random.nextDouble() < hungerDeficit / weight) {
            starvation = true;
            count -= 1;
        } else if (random.nextDouble() < 0.01) {
            natureDie = true;
            count -= 1;
        } else if (beEaten) {
            count -= 1;
        } else {/*should use enum*/}
    }

    @Override
    public boolean update() {

        double actualEaten; //this variable will record the vegetation one rabbit eat
        double vegetationShare;
        double access = 0;
        double appetite = (weight + 1) / 4;
        double minLoseWeight = weight / 4;
        double maxEaten = 2 * appetite;

        vegetationShare = cell.getVegetationShare();
        Animal randomAnimal;

        //this part used to update access, hungerDeficit and actualEaten
        if (vegetationShare < minLoseWeight) {
            setWeight(weight * 0.98);
            actualEaten = vegetationShare;
            hungerDeficit += appetite - vegetationShare;
        } else if (vegetationShare < appetite) {
            hungerDeficit += appetite - vegetationShare;
            actualEaten = vegetationShare;
        } else if (vegetationShare < maxEaten) {
            access = vegetationShare - appetite;
            actualEaten = vegetationShare;
        } else {
            access = maxEaten - appetite;
            actualEaten = maxEaten;
        }
        cell.consumeVegatation(actualEaten); //eat vegetation on cell

        if (hungerDeficit < access) {
            access -= hungerDeficit;
            hungerDeficit = 0;
            weight += 0.5 * access;
            access = 0;
        } else {
            hungerDeficit -= access;
            access = 0;
        }

        do {        //if there are wolfs in current animal, the animal selested as predator cannot be rabbit
            randomAnimal = cell.getRandomCurrentAnimal();
        } while (randomAnimal.equals(this) || randomAnimal.type.equals("rabbit") && Wolf.getCount() > 0);
        beEaten = attemptToEat(randomAnimal);
        dies();     //update dies before brith
        brith();
        return true;
    }


    //this method is not is the UML, but I think it should be taken from the update method
    public void brith() {
        if (weight > 10 && random.nextDouble() < 0.1 && isAlive()) {
            int bunniesNum = random.nextInt(8);
            for (int i = 0; i < bunniesNum; i++) {
                Rabbit rabbit = new Rabbit(cell);
                cell.addAnimal(rabbit);
            }
            weight -= bunniesNum;
        }
    }
}
