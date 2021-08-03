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

    public static <T> void writeList(List<T> list) {
        try (final ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(SerUtil.initFile(list),true))) {
            oos.writeObject(list);
            oos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static <T> void write(T t) {
        try (final ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(SerUtil.initObject(t)))) {
            final List<T> list = readList(t);
            list.add(t);
            writeList(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> readList(T t) {
        try (final ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(SerUtil.initObject(t)))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }


    public static void main(String[] args) {
        Station station = new Station("qwe");
        Petrol petrol = new Petrol("93", 123);
        Petrol petrol1 = new Petrol("94", 123);
        Petrol petrol2 = new Petrol("96", 123);
        Petrol petrol3 = new Petrol("new", 123);
        List<Petrol> petrols = new ArrayList<>();
        petrols.add(petrol);
        petrols.add(petrol1);
        petrols.add(petrol2);
        writeList(petrols);
        final List<Petrol> petrols1 = readList(new Petrol());
        System.out.println(showList(petrols1));
        write(petrol3);
        System.out.println();
        System.out.println("new : \n\n");
        final List<Petrol> petrols2 = readList(new Petrol());
        System.out.println(showList(petrols2));

    }

    public static <T> String showList(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (T tmp : list) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }
}


