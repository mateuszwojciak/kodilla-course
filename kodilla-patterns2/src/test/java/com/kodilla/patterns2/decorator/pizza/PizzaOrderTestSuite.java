package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("You have ordered pizza with cheese and tomato sauce", description);
    }

    @Test
    public void testOrdersWithAddonsGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AddCheeseOrderDecorator(pizzaOrder);
        pizzaOrder = new AddHamOrderDecorator(pizzaOrder);
        pizzaOrder = new AddMushroomsOrderDecorator(pizzaOrder);
        pizzaOrder = new AddOlivesOrderDecorator(pizzaOrder);
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(35), calculatedCost);
    }

    @Test
    public void testOrdersWithAddonsGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AddCheeseOrderDecorator(pizzaOrder);
        pizzaOrder = new AddHamOrderDecorator(pizzaOrder);
        pizzaOrder = new AddMushroomsOrderDecorator(pizzaOrder);
        pizzaOrder = new AddOlivesOrderDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("You have ordered pizza with cheese and tomato sauce + additional cheese + italian cotto ham" +
                " + mushrooms + olives", description);
    }
}
