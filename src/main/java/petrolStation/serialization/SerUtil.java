/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package petrolStation.serialization;

import petrolStation.model.Order;
import petrolStation.model.Petrol;
import petrolStation.model.Station;

import java.io.File;
import java.util.List;

public class SerUtil {

    public static <T> File initFile(List<T> list) {
        File file = new File("");
        final Object o = list.get(0);
        if (o.getClass() == Station.class) {
            file = Repository.getFileStation();
        } else if (o.getClass() == Petrol.class) {
            file = Repository.getFilePetrol();
        } else if (o.getClass() == Order.class) {
            file = Repository.getFileOrder();
        }
        return file;
    }

    public static <T> File initObject(T o) {
        File file = new File("");
        if (o.getClass() == Station.class) {
            file = Repository.getFileStation();
        } else if (o.getClass() == Petrol.class) {
            file = Repository.getFilePetrol();
        } else if (o.getClass() == Order.class) {
            file = Repository.getFileOrder();
        }
        return file;
    }


}
