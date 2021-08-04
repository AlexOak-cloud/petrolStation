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

    private static final File fileStation = new File("D:/PetrolStation/Stations.json");
    private static final File filePetrol = new File("D:/PetrolStation/Petrol.json");
    private static final File fileOrder = new File("D:/PetrolStation/Order.json");
    private static final File fileJoin = new File("D:/PetrolStation/Join.json");

    public static File getFileJoin(){
        try{
            if(!fileJoin.exists()){
                fileJoin.createNewFile();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return fileJoin;
    }

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
