package Entity;

import javax.persistence.*;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class Order {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany
    @JoinTable(name="OrderWidget")
    private Collection<Widget> widgets;
    private Date date;
    private String customerName;
   
    public Order() {
    	widgets = new ArrayList<Widget>();
    	customerName = null;
    	date = new java.util.Date();
    }
    public Order(String name){
    	widgets = new ArrayList<Widget>();
    	date = new java.util.Date();
    	this.customerName = name;
    	 
    }
    public long getId() {
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
}
