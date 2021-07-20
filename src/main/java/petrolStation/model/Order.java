package petrolStation.model;

import net.bytebuddy.matcher.InheritedAnnotationMatcher;

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
    @Column(name = "time")
    private LocalDateTime time;

    public Order(String petrolName, int sum, LocalDateTime time) {
        this.petrolName = petrolName;
        this.sum = sum;
        this.time = time;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public String getPetrolName() {
        return petrolName;
    }

    public int getSum() {
        return sum;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "petreName='" + petrolName + '\'' +
                ", sum=" + sum +
                ", time=" + time +
                '}';
    }
}
