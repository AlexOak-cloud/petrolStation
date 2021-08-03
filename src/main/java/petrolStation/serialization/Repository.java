/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package petrolStation.serialization;

import java.io.File;
import java.io.IOException;

public class Repository {

    public static final File fileStation = new File("D:/PetrolStation/Stations.eax");
    public static final File filePetrol = new File("D:/PetrolStation/Petrol.eax");
    public static final File fileOrder = new File("D:/PetrolStation/Orders.eax");


    public static File getFileStation() {
        try {
            if (!fileStation.exists()) {
                fileStation.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileStation;
    }

    public static File getFilePetrol() {
        try {
            if (!filePetrol.exists()) {
                filePetrol.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return filePetrol;
    }

    public static File getFileOrder() {
        try {
            if (!fileOrder.exists()) {
                fileOrder.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileOrder;
    }


}
