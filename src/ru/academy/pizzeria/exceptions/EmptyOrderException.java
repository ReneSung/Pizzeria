package ru.academy.pizzeria.exceptions;

// Исключение при попытке оформить заказ из пустого списка блюд
public class EmptyOrderException extends Exception {
    public EmptyOrderException() {
        super("Списко заказов не долэен быть пуст");
    }
}
