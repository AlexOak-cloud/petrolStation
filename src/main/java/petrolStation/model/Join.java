/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package petrolStation.model;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;


public class Join implements Serializable {

    private int idStation;
    private int idPetrol;

    @Override
    public String toString() {
        return "Join{" +
                "idStation=" + idStation +
                ", idPetrol=" + idPetrol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Join join = (Join) o;
        return idStation == join.idStation && idPetrol == join.idPetrol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStation, idPetrol);
    }

    public int getIdStation() {
        return idStation;
    }

    public int getIdPetrol() {
        return idPetrol;
    }

    public Join() {
    }

    public Join(int idStation, int idPetrol) {
        this.idStation = idStation;
        this.idPetrol = idPetrol;
    }
}
