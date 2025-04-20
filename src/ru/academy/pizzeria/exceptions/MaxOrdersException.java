package ru.academy.pizzeria.exceptions;

// Исключение при превышении максимального количества заказов
public class MaxOrdersException extends Exception {
    public MaxOrdersException(int maxOrders) {
        super("Достигнуто максимальное количество заказов " + maxOrders);
    }
}
