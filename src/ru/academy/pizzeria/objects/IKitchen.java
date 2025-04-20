package ru.academy.pizzeria.objects;

import java.util.HashMap;
import java.util.Set;

public interface IKitchen {

    // Получить меню
    public Set<IProduct> getMenu();

    // Добавить блюдо в список заказанных блюд
    public void addProductToOrder(IProduct product, int amount, HashMap<IProduct, Integer> orderList);
}
