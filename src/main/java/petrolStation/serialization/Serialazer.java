/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package petrolStation.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Serialazer implements Serialanager {

    private static final Serialazer serialazer = new Serialazer();

    public static Serialazer action() {
        return serialazer;
    }

    @Override
    public <T> List<T> read(File file) {
        try (final ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public <T> boolean writeList(List<T> list, File file) {
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

    @Override
    public <T> boolean write(T t, File file) {
        List<T> list = this.read(file);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(t);
        return writeList(list, file);
    }

    @Override
    public <T> void delete(T t, File file) {
        List<T> list = this.read(file);
        list.removeIf(t::equals);
        this.writeList(list,file);
    }
}
