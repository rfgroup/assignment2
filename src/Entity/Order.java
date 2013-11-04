package Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Order {
    public Order() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public Order setCustomerName(String customerName) {
        this.customerName = customerName;

        return this;
    }

    @ManyToMany
    @JoinTable(name="OrderWidget")
    private Collection<Widget> widgets;

    public Collection<Widget> getWidgets() {
        return widgets;
    }

    public Order setWidgets(Collection<Widget> widgets) {
        this.widgets = widgets;

        return this;
    }
}
