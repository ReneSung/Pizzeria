import ru.academy.pizzeria.exceptions.EmptyOrderException;
import ru.academy.pizzeria.exceptions.MaxOrdersException;
import ru.academy.pizzeria.objects.*;

class Main {
    public static void main(String[] args) throws MaxOrdersException, EmptyOrderException {
        Person person1 = new Person("Боб");
        person1.goToPizzeria();
    }
}