package com.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;
public class Cell {
    private static Random random;
    private PredatorPreySimulation grid;
    private int x;
    private int y;
    private int cellWidth;
    private int celHeight;
    private List<Animal> nextAnimals;
    private List<Animal> currentAnimals;
    private double vegetation;
    private double maxVegetation;
    private double vegetationShare;
    private double proportionalGrowthRate;
    private double linearGrowthRate;

    public Cell(PredatorPreySimulation predatorPreySimulation, int x, int y, int cellWidth, int cellHeight,
                double vegetation, double maxVegetation, double proportionalGrowthRate, double linearGrowthRate) {
        this.random = new Random();
        grid = predatorPreySimulation;  //???
        this.x = x;
        this.y = y;
        this.cellWidth = cellWidth;
        this.celHeight = cellHeight;
        this.vegetation = vegetation;
        this.maxVegetation = maxVegetation;
        this.proportionalGrowthRate = proportionalGrowthRate;
        this.linearGrowthRate = linearGrowthRate;
        nextAnimals = new ArrayList<Animal>();
        currentAnimals = new ArrayList<Animal>();
    }

    public void addAnimal(Animal animal) {
        nextAnimals.add(animal);
    }

    //generate a random index for current anmiallist
    public Animal getRandomCurrentAnimal() {
        Animal randomCurrentAnimal;
        int currentNum = currentAnimals.size();
        int index = random.nextInt(currentNum);
        randomCurrentAnimal = currentAnimals.get(index);
        return randomCurrentAnimal;
    }

    public void copyNextAnimalsToCurrent() {
        currentAnimals.clear();
        currentAnimals.addAll(nextAnimals);
        nextAnimals.clear();
    }

    //compare temperate vegetation with max so that vegetation will not bigger than max
    public void update() {
        double tempvegetation = vegetation * (1 + proportionalGrowthRate) + linearGrowthRate;
        if (tempvegetation < maxVegetation) {
            vegetation = tempvegetation;
        } else {
            vegetation = maxVegetation;
        }
        for (Animal animal : currentAnimals) {
            animal.update();
            if (animal.isAlive()) {
                addAnimal(animal);
            }
        }
    }

    public double getVegetationShare() {
        vegetationShare = 0.5 * vegetation / currentAnimals.size(); //divide number of animals
        return vegetationShare;
    }

    //amount is the amount of rabbit
    public void consumeVegatation(double amount) {
        vegetation -= amount;
    }

    public void draw(Graphics brush) {
        for (Animal oneAnimal : currentAnimals) {
            oneAnimal.draw(brush);
        }
    }

    public Color getBackgroundColor() {
        double greenRate = vegetation / maxVegetation;
        int green = (int) (greenRate * 255);
        Color backGroundColor = new Color(0, green, 0);
        return backGroundColor;

    }

    public int getRandomXInCell() {
        return (int) (random.nextDouble() * cellWidth);
    }

    public int getRandomYInCell() {
        return (int) (random.nextDouble() * celHeight);
    }

    public PredatorPreySimulation getGrid() {
        return grid;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Animal> getCurrentAnimals() {
        return currentAnimals;
    }


}
