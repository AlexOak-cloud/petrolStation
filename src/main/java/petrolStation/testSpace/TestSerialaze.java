package petrolStation.testSpace;

import javafx.util.converter.NumberStringConverter;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSerialaze implements Serializable{

    private static final File file = new File("D:/Stations.json");


    public static File getFile() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }


    private static ArrayList<TestSerialaze> getAllStations() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TestSerialaze.getFile()))) {
            Object o = ois.readObject();

            return (ArrayList<TestSerialaze>) o;
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static boolean saveStation(TestSerialaze... test) {
        try (final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, true))) {
            List<TestSerialaze> list = new ArrayList<>();
            Collections.addAll(list, test);
            oos.writeObject(list);
            oos.flush();
            return true;
        } catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    private String name;
    private ArrayList<Number> list = new ArrayList<>();


    public TestSerialaze(String name) {
        this.name = name;

    }

    public void setList(ArrayList<Number> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        TestSerialaze ts = new TestSerialaze("12");
        ts.getList().add(0,new Number(1));
        ts.getList().add(1,new Number(2));
        ts.getList().add(2,new Number(3));
        System.out.println(ts);
//        System.out.println(saveStation(ts));
        ArrayList<TestSerialaze> allStations = getAllStations();
        System.out.println(showListStations(allStations));
    }

    public static  String showListNumbers(ArrayList<Number> numbers) {
        StringBuilder sb = new StringBuilder();
        for (Object tmp : numbers) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }

    public static String showListStations(ArrayList<TestSerialaze> list){
        StringBuilder sb = new StringBuilder();
        for(TestSerialaze tmp : list){
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                showListNumbers(getList());
    }

    public String getName() {
        return name;
    }

    public ArrayList<Number> getList() {
        return list;
    }

    private static class Number implements Serializable {
        private int number;

        public void setNumber(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return String.valueOf(number);
        }

        public int getNumber() {
            return number;
        }

        public Number(int number) {
            this.number = number;
        }
    }




}
