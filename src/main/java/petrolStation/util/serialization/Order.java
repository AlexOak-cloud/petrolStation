/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package petrolStation.util.Serialization;

import petrolStation.model.Station;

import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Order {

    public static boolean write(Order order) {
        try (final ObjectOutputStream oos
                     = new ObjectOutputStream(new FileOutputStream(Files.getFileOrders(), true))) {
            List<Order> orders = readOrders();
            orders.add(order);
            writeList(orders);
            oos.flush();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean writeList(List<Order> list) {
        try (final ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(Files.getFileOrders(), true))) {
            oos.writeObject(list);
            oos.flush();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static List<Order> readOrders() {
        try (final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Files.getFileOrders()))) {
            return (List<Order>) ois.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static void deleteStation(Order order) {
        final List<Order> orders = readOrders();
        Iterator<Order> iterator = orders.listIterator();
        while (iterator.hasNext()) {
            if (iterator.equals(order)) {
                iterator.remove();
            }
        }
        writeList(orders);
    }
}

