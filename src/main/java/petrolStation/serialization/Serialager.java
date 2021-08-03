/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package petrolStation.serialization;


import petrolStation.model.Petrol;
import petrolStation.model.Station;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Serialager {
    public static void main(String[] args) {
        Station station = new Station("1");
        Station station1 = new Station("2");
        List<Station> stations = new ArrayList<>();
        writeList(stations,TypeFile.STATION);
        final List<Object> objects = readList(TypeFile.STATION);


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


    public static <T> void writeList(List<T> list, TypeFile typeFile) {
        try (final ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(InitFile.initFile(typeFile), true))) {
            oos.writeObject(list);
            oos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static <T> void writeObject(T t,TypeFile typeFile){
        try(final ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(InitFile.initFile(typeFile)))){
            final List<Object> objects = readList(typeFile);
            objects.add(t);
            writeList(objects,typeFile);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static List<Object> readList(TypeFile typeFile) {
        try (final ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(InitFile.initFile(typeFile)))) {
            return (List<Object>) ois.readObject();

        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static <T> String showList(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (Object tmp : list) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }
}


