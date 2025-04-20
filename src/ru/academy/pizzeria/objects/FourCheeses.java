package ru.academy.pizzeria.objects;

// Пицца 4 сыра
public class FourCheeses extends Pizza {
    /**
     * Конструктор
     * @param size размер пиццы
     */
    public FourCheeses(PizzaSize size) {
        super(size);

        name = "4 сыра";

        smallPizzaCoast = 300;
        middlePizzaCoast = 600;
        bigPizzaCoast = 800;

        setCoast();
    }

    // Получить количество калории
    @Override
    public double getCalories() {
        return 400;
    }
}
