/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package petrolStation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Join {

    private Station station;
    private List<petrolStation.model.Petrol> list = new ArrayList<>();

    public Join(Station station, Petrol petrol) {
        this.station = station;
        this.list.add(petrol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Join join = (Join) o;
        return Objects.equals(station, join.station) && Objects.equals(list, join.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(station, list);
    }

    public Join(Station station, List<Petrol> list) {
        this.station = station;
        this.list = list;
    }

    public Station getStation() {
        return station;
    }

    public List<Petrol> getList() {
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int number = 1;
        for (Petrol tmp : this.list) {
            sb.append(number).append(": ").append(tmp).append("\n");
            number++;
        }
        return "Станция \"" +
                station.getName() + "\"" +
                "\n" + sb;
    }
}
