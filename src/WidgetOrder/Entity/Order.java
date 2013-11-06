package WidgetOrder.Entity;

import javax.persistence.*;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * <p>Title: Widget Inventory s</p>
 * <p>Description: CS 343 Assignment #2</p>
 * @author Aaron Cook, Kyle Kornetske, Michael Haas, Kyle Kolstad
 * @email aaron.cook@my.uwrf.edu, michael.haas@my.uwrf.edu,
 * 			kyle.kornetske@my.uwrf.edu kyle.kolstad@my.uwrf.edu
 * @date November 5th 2013
 * @team Group 4
 */
@Entity(name = "CustomerOrder")
@NamedQueries({
        @NamedQuery(name = "Order.findAll", query = "select o from CustomerOrder o"),
        @NamedQuery(name = "Order.findById", query = "select o from CustomerOrder o where o.id = :id")
})
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Order() {
        widgets = new ArrayList<Widget>();
    }
    public Order(String s){
    	 customerName = s;
    	 widgets = new ArrayList<Widget>();
    }

    @Basic
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public Order setCustomerName(String customerName) {
        this.customerName = customerName;

        return this;
    }

    @OneToMany(cascade = CascadeType.PERSIST)
    private Collection<Widget> widgets;

    public Order addWidget(Widget widget) {
        widgets.add(widget);

        return this;
    }

    public Order removeWidget(Widget widget) {
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
    @Override
	public String toString() {
		String result = "[Order #: " + id + ", from: " + customerName + ":- ";
		if (widgets != null) 
			for (Widget w : widgets)
				result = result + w;
		return result + " ]";
	}
}
