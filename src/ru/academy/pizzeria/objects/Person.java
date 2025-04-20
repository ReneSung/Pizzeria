package ru.academy.pizzeria.objects;

import ru.academy.pizzeria.exceptions.EmptyOrderException;
import ru.academy.pizzeria.exceptions.MaxOrdersException;

public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }
    public void goToPizzeria() {
        KitchenRepository kitchen = new KitchenRepository();

        kitchen.showMenu();

        try {
            kitchen.addPizzaToOrder(new Pepperoni(Pizza.PizzaSize.MIDDLE), 2);
            kitchen.addPizzaToOrder(new Pepperoni(Pizza.PizzaSize.MIDDLE), 1);
            kitchen.addPizzaToOrder(new MeatPizza(Pizza.PizzaSize.BIG), 1);
            kitchen.addPizzaToOrder(new MeatPizza(Pizza.PizzaSize.SMALL), 1);
            kitchen.addPizzaToOrder(new MushroomPizza(Pizza.PizzaSize.MIDDLE), 1);
            kitchen.addPizzaToOrder(new ChickenPizza(Pizza.PizzaSize.MIDDLE), 3);

            kitchen.makeOrder(this.name);


        } catch (MaxOrdersException | EmptyOrderException e) {
            System.out.println(e.getMessage());
        }
    }
}
