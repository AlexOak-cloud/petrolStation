package petrolStation.util;

public interface SQLQuery {

    String forJoining = "insert into petrol_and_stations (id_petrol, id_station) values (%d, %d);";
    String showJoining = "select tbl_petrol.* from tbl_stations left join tbl_petrol on tbl_stations.id_station = %d;";
    String deleteAllPetrol = "delete from tbl_petrol;";
    String updatePrice = "update petrol set price = ? where name = ?;";
}
