package ru.academy.pizzeria.objects;

// Мясная пицца
public class MeatPizza extends Pizza{
    /**
     * Конструктор
     * @param size размер пиццы
     */
    public MeatPizza(PizzaSize size) {
        super(size);

        name = "Мясная";

        smallPizzaCoast = 400;
        middlePizzaCoast = 700;
        bigPizzaCoast = 900;

        setCoast();
    }

    // получить количество калорий
    @Override
    public double getCalories() {
        return 400;
    }
}
