package petrolStation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "petrol_name")
    private String petrolName;
    @Column(name = "sum")
    private int sum;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "time")
    private LocalDateTime time;

    public int getId() {
        return id;
    }

    public String getPetrolName() {
        return petrolName;
    }

    public int getSum() {
        return sum;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Order() {
    }

    public Order(String petrolName, int sum, int quantity, LocalDateTime time) {
        this.petrolName = petrolName;
        this.sum = sum;
        this.quantity = quantity;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "petrolName='" + petrolName + '\'' +
                ", sum=" + sum +
                ", quantity=" + quantity +
                ", time=" + time +
                '}';
    }
    /**
     *
     *
     * Таблица для хранения мнформации о заказах ->
     *
     *        CREATE TABLE orders (id INT AUTO_INCREMENT PRIMARY KEY,
     *                             petrol_name VARCHAR(255)NOT NULL,
     *                             sum int NOT NULL CHECK(SUM>0),
     *                             quantity INT NOT NULL CHECK(quantity>0),
     *                             time TIMESTAMP NOT NULL);
     */
}
