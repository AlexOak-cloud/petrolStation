package petrolStation;

import java.util.List;

public class DoIt {

    public static void main(String[] args) {


    }

    public static <T> String showlIst(List<T> list){
        StringBuilder sb = new StringBuilder();
        for (Object tmp : list ){
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }
}
