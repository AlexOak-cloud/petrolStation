/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package petrolStation.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Join implements Serializable {

    private int id_station;
    private List<Petrol> listPetrol;

    @Override
    public String toString() {
        return "Join{" +
                "id_station=" + id_station +
                ", listPetrol=" + listPetrol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Join join = (Join) o;
        return id_station == join.id_station && Objects.equals(listPetrol, join.listPetrol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_station, listPetrol);
    }

    public int getId_station() {
        return id_station;
    }

    public List<Petrol> getListPetrol() {
        return listPetrol;
    }

    public Join() {
    }

    public Join(int id_station, List<Petrol> listPetrol) {
        this.id_station = id_station;
        this.listPetrol = listPetrol;
    }
}
