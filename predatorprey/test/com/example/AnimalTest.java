package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    Wolf wolf;
    Wolf anotherWolf;
    Rabbit rabbit;
    Rabbit anotherRabbit;
    Cell cell;
    @Before
    public void setup() throws Exception {
        ParameterBlock parameterBlock =new ParameterBlock();
        double vegetation = 1000.0;
        PredatorPreySimulation predatorPreySimulation = new PredatorPreySimulation(parameterBlock);
        cell = new Cell(predatorPreySimulation, 0, 0, parameterBlock.getScreenWidth(),
                parameterBlock.getScreenHeight(),
                vegetation, parameterBlock.getMaxVegetation(),
                parameterBlock.getVegetationProportionalGrowthRate(),
                parameterBlock.getVegetationLinearGrowthRate());
        wolf = new Wolf(cell);
        anotherWolf = new Wolf(cell);
        rabbit = new Rabbit(cell);
        anotherRabbit = new Rabbit(cell);
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void rabbitEatenByWolf() throws Exception {
        boolean success = true;
        assertEquals(success, rabbit.attemptToEat(wolf));
    }

    @Test
    public void wolfEatenByWolf() throws Exception {
        boolean success = false;
        assertEquals(success, anotherWolf.attemptToEat(wolf));
    }

    @Test
    public void wolfEatenByRabbit() throws Exception {
        boolean success = false;
        assertEquals(success, anotherWolf.attemptToEat(rabbit));
    }

    @Test
    public void rabbitEatenByRabbit() throws Exception {
        boolean success = false;
        assertEquals(success, anotherRabbit.attemptToEat(rabbit));
    }

}