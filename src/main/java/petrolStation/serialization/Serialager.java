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

    public static <T> void writeList(List<T> list) {
        try (final ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(SerUtil.initFile(list)))) {
            oos.writeObject(list);
            oos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static <T> void write(T t) {
        try (final ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(SerUtil.initObject(t)))) {


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> readObject(T t){
        try(final ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(SerUtil.initObject(t)))){
            return  (List<T>) ois.readObject();
        }catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }


    public static void main(String[] args) {
//        final Station station = new Station("123");
//        final Station station1 = new Station("321");
//        final ArrayList<Station> stations = new ArrayList<>();
//        stations.add(station);
//        stations.add(station1);
//        writeList(stations);
//        final List<Object> objects = readList(new Station());
//        showList(objects);

        readList()

    }

    public static<T> String showList(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for(T tmp : list){
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }
}


