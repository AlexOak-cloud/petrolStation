package petrolStation.Console;

public interface ManagerMassages {

    String newOrder = "1: Новая заправка";
    String cancallations = "2: Отмена заказа";
    String toChangePrice = "3: Изменить стоимость топлива";
    String exit = "0: Выход";

    String managerMenu = newOrder + "\n" + cancallations + "\n" + toChangePrice + "\n" + exit + "\n";

}
