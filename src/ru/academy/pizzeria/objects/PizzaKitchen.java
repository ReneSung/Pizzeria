package ru.academy.pizzeria.objects;

import java.util.*;

public class PizzaKitchen implements IKitchen {

    // Список пицц для меню
    private Set<IProduct> pizzaMenu;

    // Конструктор
    public PizzaKitchen() {

        this.pizzaMenu = new LinkedHashSet<>();
        pizzaMenu.add(new Pepperoni(Pizza.PizzaSize.MIDDLE));
        pizzaMenu.add(new FourCheeses(Pizza.PizzaSize.MIDDLE));
        pizzaMenu.add(new MeatPizza(Pizza.PizzaSize.MIDDLE));
        pizzaMenu.add(new MushroomPizza(Pizza.PizzaSize.MIDDLE));
        pizzaMenu.add(new ChickenPizza(Pizza.PizzaSize.MIDDLE));
    }

    /**
     * Получить список пицц для меню
     * @return коллекция пицц
     */
    @Override
    public Set<IProduct> getMenu() {
        return this.pizzaMenu;
    }

    /**
     * Добавить пиццу в списко заказа блюд
     * @param product пицца
     * @param amount количество
     * @param orderList список блюд к заказу
     */
    public void addProductToOrder(IProduct product, int amount, HashMap<IProduct, Integer> orderList) {

        if (orderList.containsKey(product)) {
            orderList.replace(product, orderList.get(product) + 1);
        }
        else {
            orderList.put(product, amount);
        }

        System.out.println("Пицца " + ((Pizza)product).getName() + " " + ((Pizza)product).getPizzaSizeValue(((Pizza)product).pizzaSize)
                + " см " + "добавлена в список заказов. Количество: " + amount +
                ", стоимость " + (((Pizza)product).getCoast()) * amount);
    }
}
