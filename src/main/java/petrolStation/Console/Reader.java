package petrolStation.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {


    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readString(String s) {
        System.out.println(s);
        try {
            return reader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Ошибка метода Reader.readString(String)");
            return "";
        }
    }


    public static int readInt() {
        try {
            final int i = Integer.parseInt(reader.readLine());
            if (!isItPositive(i)) {
                System.out.println("Введено отрицательное число, попробуте еще раз\n");
                readInt();
            }
            return i;
        } catch (
                IOException ex) {
            ex.printStackTrace();
            System.err.println("Ошибка метода Reader.readInt()");
            return 0;
        }
    }

    public static int readInt(String s, int beginCheck, int endCheck) {
        System.out.println(s);
        try {
            int rtn = Integer.parseInt(reader.readLine());
            if (!checkInt(rtn, beginCheck, endCheck)) {
                System.out.println("Введены невалидные данные, попробуйте еще раз\n");
                readInt(s, beginCheck, endCheck);
            }
            return rtn;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Ошибка метода Reader.readInt(String, int, int)");
            return 0;
        }
    }

    public static int readInt(String s) {
        System.out.println(s);
        try {
            final int i = Integer.parseInt(reader.readLine());
            if (!isItPositive(i)) {
                System.out.println("Введено отрицательное число, попробуте еще раз\n");
                readInt();
            }
            return i;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Ошибка метода Reader.readInt(String)");
            return 0;
        }
    }

    public static boolean checkInt(int value, int begin, int end) {
        if (value < begin && value > end) {
            System.out.println("Введены невалидные данные\n");
            return false;
        } else {
            return true;
        }
    }
    public static boolean isItPositive(int number) {
        if (number > 0) {
            return true;
        } else {
            System.out.println("Введены отрицательные данные (или 0)\n");
            return false;
        }
    }
}
