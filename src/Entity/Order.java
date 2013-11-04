package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import Entity.Widget;
@Entity
public class Order {
   
	//data members
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
    private Collection<Widget> widgets;
    
    @Temporal(TemporalType.TIMESTAMP) 
    private java.util.Date date;
    
    private String customerName;
  
    //default constructor
    public Order() {
    	widgets = new ArrayList<Widget>();
    	customerName = null;
    	date = new java.util.Date ();
    }
    //alternate constructor
    public Order(String name){
    	widgets = new ArrayList<Widget>();
    	date = new java.util.Date();
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
    @Override
    public String toString(){
    	String result = "[Order #: " + id + ", from: " + customerName + " Date: " + date + ":- ";
		if (widgets != null) 
			for (Widget w : widgets)
				result = result + w;
		return result + " ]";
    	
    	
    }
}
