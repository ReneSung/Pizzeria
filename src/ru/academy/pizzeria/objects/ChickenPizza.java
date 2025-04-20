package ru.academy.pizzeria.objects;

//Куриная пицца
public class ChickenPizza extends Pizza {

    /**
     * Конструктор
     *
     * @param size размер пиццы
     */
    public ChickenPizza(PizzaSize size) {
        super(size);
        name = "Куриная";

        smallPizzaCoast = 300;
        middlePizzaCoast = 550;
        bigPizzaCoast = 750;

        setCoast();
    }

    // получить количество калорий
    @Override
    public double getCalories() {
        return 200;
    }
}
