/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package petrolStation.util.Serialization;

import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Join {

    public static Map<Key, Integer> map = new HashMap<>();

    public static void write(Map<Key,Integer> map){
        try(final ObjectOutputStream oos = new ObjectOutputStream())


    }




    public static class Key {
        int key;

        public Key(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }
    }
}
