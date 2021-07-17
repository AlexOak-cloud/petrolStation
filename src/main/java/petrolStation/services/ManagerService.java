package petrolStation.services;

import petrolStation.DAO.ManagerDAO;
import petrolStation.model.Petrol;

public class ManagerService {


    public static boolean updatePetrolPrice(int price, Petrol petrol) {
        return ManagerDAO.updatePrice(price, petrol);
    }

    public static boolean checkInt(int check){
        return ManagerDAO.checkInt(check);
    }
}
