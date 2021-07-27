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

public class Admin {

    public static boolean write(Station station) {
        try (final ObjectOutputStream oos
                     = new ObjectOutputStream(new FileOutputStream(Files.getFileStations(), true))) {
            List<Station> stations = readStations();
            stations.add(station);
            writeList(stations);
            oos.flush();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean writeList(List<Station> list) {
        try (final ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(Files.getFileStations(), true))) {
            oos.writeObject(list);
            oos.flush();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static List<Station> readStations() {
        try (final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Files.getFileStations()))) {
            return (List<Station>) ois.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static void deleteStation(Station station) {
        final List<Station> stations = readStations();
        Iterator<Station> iterator = stations.listIterator();
        while (iterator.hasNext()) {
            if (iterator.equals(station)) {
                stations.remove(iterator);
            }
        }
        writeList(stations);
    }
}