/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package petrolStation.serialization;

import petrolStation.model.Join;
import petrolStation.model.Order;
import petrolStation.model.Petrol;
import petrolStation.model.Station;

import java.io.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Serialanager {
        // Petrol_TEST -> complete
        // Station_TEST -> complete
        // Order_TEST -> complete
        // Join_TEST -> complete

    public static <T> List<T> read(File file) {
        try (final ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<>();
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

    public static <T> boolean write(T t, File file) {
        List<T> list = read(file);
        if(list == null){
            list = new ArrayList<>();
        }
        list.add(t);
        return writeList(list, file);
    }

    public static <T> String showList(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (Object tmp : list) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }
}


