package ru.academy.pizzeria.objects;

// Пицца пеперони
public class Pepperoni extends Pizza {
    /**
     * Конструктор
     * @param size размер пиццы
     */
    public Pepperoni(PizzaSize size) {
        super(size);
        name = "Пепперони";

        smallPizzaCoast = 200;
        middlePizzaCoast = 500;
        bigPizzaCoast = 750;

        setCoast();
    }

    // получить количество калорий
    @Override
    public double getCalories() {
        return 350;
    }
}
