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

public class Join {
    public static void writeList(List<Join> list ){
        try(ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(Files.getFileJoin(),true))){
            oos.writeObject(list);
            oos.flush();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static List<Join> readList(){
        try(ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(Files.getFileJoin()))){
            return  (List<Join>) ois.readObject();
        }catch (IOException | ClassNotFoundException ex ){
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static List<Join> get(){
        return  readList();
    }

    public static void write(Join join){
        try(ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(Files.getFileJoin(),true))){
            oos.writeObject(join);
            oos.flush();
        }catch ( IOException ex){
            ex.printStackTrace();
        }
    }

    public static void delete(Join join){
        final List<Join> joins = readList();
        Iterator<Join> iterator = joins.listIterator();
        while(iterator.hasNext()){
            if(iterator.equals(join)){
                iterator.remove();
            }
        }
    }
}