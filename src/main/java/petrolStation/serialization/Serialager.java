/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package petrolStation.serialization;

import petrolStation.model.Station;

import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Serialager {
    public static void main(String[] args) {
        Station station = new Station("3");
        write(station,Repository.getFileStation());
//        Station station = new Station("1");
//        Station station1 = new Station("2");
//        List<Station> list = new ArrayList<>();
//        list.add(station);
//        list.add(station1);
        List<Object> read = read(Repository.getFileStation());
        System.out.println(showList(read));
//        Petrol petrol = new Petrol("1", 11);
//        Petrol petrol1 = new Petrol("2", 22);
//        Petrol petrol2 = new Petrol("3", 33);
//        List<Petrol> listPetrol = new ArrayList<>();
//        listPetrol.add(petrol);
//        listPetrol.add(petrol1);
//        listPetrol.add(petrol2);
//        writeList(listPetrol, TypeFile.PETROL);
//        final List<Object> objects = readList(TypeFile.PETROL);
//        System.out.println(showList(objects));
//        System.out.println();
//        System.out.println("new\n\n");
//        Petrol petrol3 = new Petrol("4",44);
//        writeObject(petrol3,TypeFile.PETROL);
//        final List<Petrol> objects1 = readList(TypeFile.PETROL);
//        System.out.println(showList(objects1));
    }

    public static <T> List<T> read(File file) {
        try (final ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            return Collections.emptyList();
        }
    }

    public static <T> boolean writeList(List<T> list, File file) {
        try (final ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(file, false))) {
            oos.writeObject(list);
            oos.flush();
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static <T> void write(T t, File file) {
        List<T> list = read(file);
        list.add(t);
        System.out.println(showList(list) +"\n\n");
        System.out.println(writeList(list, file));
    }

    public static <T> String showList(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (Object tmp : list) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }
}


