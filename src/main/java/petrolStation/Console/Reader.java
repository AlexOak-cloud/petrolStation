package petrolStation.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    public static String readString(String s){
        System.out.println(s);
        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(System.in))){
            return reader.readLine();
        }catch (IOException ex){
            ex.printStackTrace();
            System.err.println("Ошибка метода Reader.readString()");
            return "";
        }
    }

    public static String readString(){
        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(System.in))){
            return reader.readLine();
        }catch (IOException ex){
            ex.printStackTrace();
            System.err.println("Ошибка метода Reader.readString()");
            return "";
        }
    }

    public static int readInt(){
        try(BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in))){
            return Integer.parseInt(reader.readLine());
        }catch (IOException ex){
            ex.printStackTrace();
            System.err.println("Ошибка метода Reader.readInt()");
            return 0;
        }
    }
    public static int readInt(String s){
        System.out.println(s);
        try(BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in))){
            return Integer.parseInt(reader.readLine());
        }catch (IOException ex){
            ex.printStackTrace();
            System.err.println("Ошибка метода Reader.readInt()");
            return 0;
        }
    }

}
