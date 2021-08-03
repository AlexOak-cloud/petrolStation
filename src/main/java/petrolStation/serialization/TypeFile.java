/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package petrolStation.serialization;

import javax.xml.soap.SAAJResult;

public enum TypeFile {
    STATION("D:/PetrolStation/Stations.eax"),
    PETROL("D:/PetrolStation/Petrol.eax"),
    ORDER("D:/PetrolStation/Orders.eax"),
    JOIN("D:/PetrolStation/Joins.eax");

    private String nameFile;

    TypeFile(String nameFile) {
        this.nameFile = nameFile;
    }
}
