package petrolStation.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    public static String readString(){
        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(System.in))){
            return reader.readLine();
        }catch (IOException ex){
            ex.printStackTrace();
            return "Ошибка метода Reader.readString()";
        }
    }

    public static int readInt(){
        try(BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in))){
            return Integer.parseInt(reader.readLine());
        }catch (IOException ex){
            ex.printStackTrace();
            return 0;
        }
    }
}
