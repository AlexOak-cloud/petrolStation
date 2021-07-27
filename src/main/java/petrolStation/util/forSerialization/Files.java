/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package petrolStation.util.forSerialization;

import java.io.File;
import java.io.IOException;

public class Files {
    public static final File fileStations = new File ("D:/PetrolStation/Stations.eax");
    public static final File filePetrol = new File ("D:/PetrolStation/Petrol.eax");
    public static final File fileOrders = new File ("D:/PetrolStation/Orders.eax");

    public static File getFileStations(){
        try{
            if(!fileStations.exists()){
                fileStations.createNewFile();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return fileStations;
    }

    public static File getFilePetrol(){
        try{
            if(!filePetrol.exists()){
                filePetrol.createNewFile();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return filePetrol;
    }


    public static File getFileOrders(){
        try{
            if(!fileOrders.exists()){
                fileOrders.createNewFile();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return fileOrders;
    }

}
