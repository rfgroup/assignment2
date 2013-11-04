package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class Order {
   
	//data members
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Transient
    private Collection<Widget> widgets;

    private String customerName;
  
    //default constructor
    public Order() {
    	widgets = new ArrayList<Widget>();
    	customerName = null;
//    	date = new java.util.Date ();
    }

    //alternate constructor
    public Order(String name){
    	widgets = new ArrayList<Widget>();
//    	date = new java.util.Date();
    	this.customerName = name;
    }

    public long getID() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Order setCustomerName(String customerName) {
        this.customerName = customerName;

        return this;
    }

    public Collection<Widget> getWidgets() {
        return widgets;
    }

    public Order setWidgets(Collection<Widget> widgets) {
        this.widgets = widgets;

        return this;
    }
    public void addItem( Widget w){
		widgets.add( w );
	}

    @PrePersist
    public void created() {
        this.created = this.updated = new Date();
    }

    @PreUpdate
    public void updated() {
        this.updated = new Date();
    }

    @Override
    public String toString(){
    	String result = "[Order #: " + id + ", from: " + customerName + " Created: " + created + ":- ";
		if (widgets != null) 
			for (Widget w : widgets)
				result = result + w;
		return result + " ]";
    }

    @Basic
    private Date created;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Basic
    private Date updated;

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
