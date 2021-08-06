package petrolStation;

import petrolStation.model.Station;
import petrolStation.services.AdminService;

import java.util.List;

public class DoIt {

    public static void main(String[] args) {
        AdminService.create();
    }

    public static <T> String showList(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (Object tmp : list) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }
}
