package ru.academy.pizzeria.objects;

import java.util.HashMap;

// Класс обработки заказов
public class OrderService {
    // Имя покупателя
    private final String customerName;

    // Конструктор
    public OrderService(String customerName_) {
        this.customerName = customerName_;
    }

    /**
     * Получить заказ
     * @param orderList спизок заказанных блюд
     */
    public void getOrder(HashMap<IProduct, Integer> orderList) {
        System.out.println("Заказ клиеннта " + customerName + " принят");

        double sum = 0;

        for (var i: orderList.entrySet()) {
            if (i.getKey() instanceof Pizza pizza) {
                System.out.println("Пицца " + (pizza.getName() + " " +
                        pizza.getPizzaSizeValue(pizza.pizzaSize) + "см: " + i.getValue()));
                sum += pizza.getCoast() * i.getValue();
            }
        }

        System.out.println("Сумма заказа " + sum + " рублей");
    }

    // Готовить заказ
    public void cookOrder() {
        System.out.println("заказ клиента " + this.customerName + " готовится");
    }

    // Отдать заказ
    public void giveOrder() {
        System.out.println("заказ клиента " + this.customerName + " готов");
    }
}
