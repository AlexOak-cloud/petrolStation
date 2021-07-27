/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package petrolStation.util.Serialization;

import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Petrol {

    public static boolean write(Petrol petrol) {
        try (final ObjectOutputStream oos
                     = new ObjectOutputStream(new FileOutputStream(Files.getFilePetrol(), true))) {
            List<Petrol> petrols = readPetrol();
            petrols.add(petrol);
            writeList(petrols);
            oos.flush();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean writeList(List<Petrol> list) {
        try (final ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(Files.getFilePetrol(), true))) {
            oos.writeObject(list);
            oos.flush();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static List<Petrol> readPetrol() {
        try (final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Files.getFilePetrol()))) {
            return (List<Petrol>) ois.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static void deletePetrol(Petrol petrol) {
        final List<Petrol> petrolList = readPetrol();
        Iterator<Petrol> iterator = petrolList.listIterator();
        while (iterator.hasNext()) {
            if (iterator.equals(petrol)) {
                petrolList.remove(iterator);
            }
        }
        writeList(petrolList);
    }
}
