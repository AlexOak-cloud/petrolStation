package petrolStation.testSpace;

import petrolStation.model.Petrol;
import petrolStation.model.Station;

public class TestSpace {
    public static void main(String[] args) {
        Petrol petrol = new Petrol("92",23);
        Petrol petrol1 = new Petrol("95",25);
        Petrol petrol2 = new Petrol("98",27);
        Station s = new Station("1",petrol,petrol1,petrol2);

        System.out.println(s);
    }
}
