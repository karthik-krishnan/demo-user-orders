package in.karthiks.demo.users.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Order implements Serializable {
    public Order(String id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    public String id;
    public BigDecimal amount;
}
