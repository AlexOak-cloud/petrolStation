package petrolStation.util;

public interface SQLQuery {

    String forJoining = "insert into petrol_and_stations (id_petrol, id_stations) values (%d, %d);";
}
