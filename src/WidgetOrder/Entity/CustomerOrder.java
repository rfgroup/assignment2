package WidgetOrder.Entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class CustomerOrder {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public CustomerOrder() {
        widgets = new ArrayList<Widget>();
    }

    @Basic
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public CustomerOrder setCustomerName(String customerName) {
        this.customerName = customerName;

        return this;
    }

    @OneToMany(cascade = CascadeType.PERSIST)
    private Collection<Widget> widgets;

    public CustomerOrder addWidget(Widget widget) {
        widgets.add(widget);

        return this;
    }

    public CustomerOrder removeWidget(Widget widget) {
        widgets.remove(widget);

        return this;
    }

    public Collection<Widget> getWidgets() {
        return widgets;
    }

    @Basic
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @PrePersist
    public void created() {
        created = new Date();
    }
}
