package ru.academy.pizzeria.objects;

import ru.academy.pizzeria.exceptions.EmptyOrderException;
import ru.academy.pizzeria.exceptions.MaxOrdersException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

// Репозиторий кухня
public class KitchenRepository {
    // Кухня пииццы
    private final PizzaKitchen pizzaKitchen;

    // Максимальное количиество заказов
    private static final int MAXORDERS = 10;

    // Меню
    private static Set<IProduct> menu = new LinkedHashSet<>();

    // Коллекция заказов. IProduct - продукты, реализующие интерфейс IProduct, Integer - количество
    private HashMap<IProduct, Integer> orderList = new LinkedHashMap<>();

    // Конструктор
    public KitchenRepository() {
        this.pizzaKitchen = new PizzaKitchen();
    }

    // Показать меню пиццерии
    public void showMenu() {
        menu.addAll(pizzaKitchen.getMenu());

        for (var i : menu) {
            if (i instanceof Pizza pizza) {
                System.out.println("Пицца: " + pizza.getName());

                System.out.println(pizza.getPizzaSizeValue(Pizza.PizzaSize.SMALL) + "см: "
                        + pizza.getSmallPizzaCoast() + "Р");

                System.out.println(pizza.getPizzaSizeValue(Pizza.PizzaSize.MIDDLE) + "см: "
                        + pizza.getMiddlePizzaCoast() + "Р");

                System.out.println(pizza.getPizzaSizeValue(Pizza.PizzaSize.BIG) + "см: "
                        + pizza.getBigPizzaCoast() + "Р" + "\n");
            }
        }
    }

    /**
     * Добавить пиццу в список заказов
     *
     * @param pizza  пицца
     * @param amount количество
     * @throws MaxOrdersException превышено максимальное количество заказов
     */
    public void addPizzaToOrder(Pizza pizza, int amount) throws MaxOrdersException {
        if (countProductsInOrderList() == MAXORDERS) {
            throw new MaxOrdersException(MAXORDERS);
        }

        pizzaKitchen.addProductToOrder(pizza, amount, orderList);
    }

    /**
     * Оформить заказ
     * @param customerName имя клиента
     * @throws EmptyOrderException пустой список блюд
     */
    public void makeOrder(String customerName) throws EmptyOrderException {
        if (customerName.isEmpty()) {
            throw new IllegalArgumentException("Име не должно быть пустым");
        }

        if (this.orderList.isEmpty()) {
            throw new EmptyOrderException();
        }

        OrderService orderService = new OrderService(customerName);
        orderService.getOrder(orderList);

        orderService.cookOrder();
        orderService.giveOrder();
    }

    /**
     * Посчитать количество продуктов в orderList
     *
     * @return количество продуктов
     */
    private int countProductsInOrderList() {
        int sum = 0;
        for (var i : orderList.entrySet()) {
            sum += i.getValue();
        }

        return sum;
    }
}
