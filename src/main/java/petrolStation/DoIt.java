package petrolStation;

import petrolStation.serialization.Repository;

import java.util.List;

public class DoIt {

    public static void main(String[] args) {
        Repository.getFileStation().delete();
        Repository.getFilePetrol().delete();
        Repository.getFileJoin().delete();
        Repository.getFileOrder().delete();
    }

    public static <T> String showList(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (Object tmp : list) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }
}
