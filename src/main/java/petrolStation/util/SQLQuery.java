package petrolStation.util;

public interface SQLQuery {

    String forJoining = "insert into petrol_station (id_station, id_petrol) values (%d, %d);";
    String showJoining = "select stations.id, stations.name, petrol.id, petrol.name, petrol.price" +
            " from petrol_station" +
            " join petrol " +
            "on petrol_station.id_petrol=petrol.id " +
            "join stations " +
            "on petrol_station.id_station = stations.id " +
            "where stations.id = %d;";
//join petrol on petrol_station.id_petrol=petrol.id join stations on petrol_statio

    String deleteAllPetrol = "delete from tbl_petrol;";
    String updatePrice = "update petrol set price = %d where name = %s;";
}
