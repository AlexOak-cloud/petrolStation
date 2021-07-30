package petrolStation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "petrol_name")
    private String petrolName;
    @Column(name = "sum")
    private double sum;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "time")
    private LocalDateTime time;

    public int getId() {
        return id;
    }

    public String getPetrolName() {
        return petrolName;
    }

    public double getSum() {
        return sum;
    }

    public double getQuantity() {
        return quantity;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Order() {
    }

    public Order(String petrolName, double sum, double quantity, LocalDateTime time) {
        this.petrolName = petrolName;
        this.sum = sum;
        this.quantity = quantity;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Double.compare(order.sum, sum) ==
                0 && Double.compare(order.quantity, quantity) ==
                0 && Objects.equals(petrolName, order.petrolName) && Objects.equals(time, order.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, petrolName, sum, quantity, time);
    }

    @Override
    public String toString() {
        return "Закза номер " + id + "( " + petrolName +
                ", сумма= " + sum +
                ", колличества топлива= " + quantity +
                "(л), время заказа= " + time +
                ")";
    }
    /**
     *
     *
     * Таблица для хранения мнформации о заказах ->
     *
     *        CREATE TABLE orders (id INT AUTO_INCREMENT PRIMARY KEY,
     *                             petrol_name VARCHAR(255)NOT NULL,
     *                             sum DOUBLE NOT NULL CHECK(SUM>0),
     *                             quantity DOUBLE  NOT NULL CHECK(quantity>0),
     *                             time TIMESTAMP NOT NULL);
     */
}
