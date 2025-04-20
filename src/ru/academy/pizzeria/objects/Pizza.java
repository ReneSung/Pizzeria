package ru.academy.pizzeria.objects;

import java.util.HashMap;
import java.util.Objects;

// Абстрактный клсс для пиццы
public abstract class Pizza implements IProduct {
    // Название пиццы
    protected String name;

    // Размер пиццы
    protected PizzaSize pizzaSize;

    // Стоимость заказанной пиццы
    protected double coast;

    // Стоимость маленькой пиццы
    protected double smallPizzaCoast;

    // Стоимость средней пиццы
    protected double middlePizzaCoast;

    // Стоимость большой пиццы
    protected double bigPizzaCoast;

    // HashMap - значение из enum размер пиццы, размер в int
    protected static final HashMap<PizzaSize, Integer> pizzaSizeMap = new HashMap<>();

    /**
     * Конструктор
     * @param size размер пиццы
     */
    public Pizza(PizzaSize size) {
        this.pizzaSize = size;

        addValuesToPizzaSizeMap();
    }

    // Добавление значений в pizzaSizeMap в соответствии с размерами пиццы
    public void addValuesToPizzaSizeMap() {
        pizzaSizeMap.put(PizzaSize.SMALL, 25);
        pizzaSizeMap.put(PizzaSize.MIDDLE, 30);
        pizzaSizeMap.put(PizzaSize.BIG, 35);
    }

    // Установить текущую цену пиццы в соответствии с переданным размером пиццы
    protected void setCoast() {
        switch (pizzaSize) {
            case SMALL -> coast = smallPizzaCoast;
            case MIDDLE -> coast = middlePizzaCoast;
            case BIG -> coast = bigPizzaCoast;
        }
    }

    // Получить стоимость пиццыв соответствии с переданным размером пиццы
    public double getCoast() {
        return coast;
    }

    // Получить стоимость средней пиццы
    public double getMiddlePizzaCoast() {
        return middlePizzaCoast;
    }

    // Получить стоимость маленькой пиццы
    public double getSmallPizzaCoast() {
        return smallPizzaCoast;
    }

    // Получить стоимость большой пиццы
    public double getBigPizzaCoast() {
        return bigPizzaCoast;
    }

    // Получить название пиццы
    public String getName() {
        return name;
    }

    /**
     * Получить значение размера пиццы
     * @param pizzaSize размер пиццы из enum
     * @return значение размера
     */
    public int getPizzaSizeValue(PizzaSize pizzaSize) {
        return pizzaSizeMap.get(pizzaSize);
    }

    // Переопределение equals, необходимо для работы с HashMap при оформлении заказов
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pizza)) return false;

        Pizza p = (Pizza) obj;

        return name.equals(p.name) && pizzaSize.equals(p.pizzaSize);
    }

    // Переопределение equals, необходимо для работы с HashMap при оформлении заказов
    @Override
    public int hashCode() {
        return Objects.hash(name, pizzaSize);
    }

    // Размеры пиццы
    public enum PizzaSize {
        SMALL,
        MIDDLE,
        BIG
    }
}


