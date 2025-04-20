package ru.academy.pizzeria.objects;
// Грибная пицца
public class MushroomPizza extends Pizza {
    /**
     * Конструктор
     * @param size размер пиццы
     */
    public MushroomPizza(PizzaSize size) {
        super(size);

        name = "Грибная";

        smallPizzaCoast = 300;
        middlePizzaCoast = 450;
        bigPizzaCoast = 600;

        setCoast();
    }

    // получить количество калорий
    @Override
    public double getCalories() {
        return 250;
    }
}
