package petrolStation.services;

import petrolStation.Console.Reader;
import petrolStation.DAO.AdminDAO;
import petrolStation.DAO.ManagerDAO;
import petrolStation.model.Petrol;

import java.util.List;

public class ManagerService {


    public static void updatePetrolPrice() {
        System.out.println(AdminService.showList(AdminDAO.getAllPetrol()));
        final int id = Reader.readInt("Введите id топлива для изменения стоимости");
        final int price = Reader.readInt("Введите новую стоимость");
        if(!checkInt(price)){
            System.out.println("Ошибка: введена отрицательная сумма");//Исправить логику для отмены операции
            updatePetrolPrice();
        }
        final Petrol petrolById = AdminDAO.getPetrolById(id);
        ManagerDAO.updatePrice(price, petrolById);
    }

    public static boolean checkInt(int check) {
        if (check > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void calcPrice(){
        final int sum = Reader.readInt("Введите сумму для запраки");
        final String petrolName = Reader.readString("Введите название топлива");


        ManagerDAO.calcPrice(sum,idPetrol);
    }
}
