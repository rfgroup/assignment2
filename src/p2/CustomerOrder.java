package p2;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String customerName;
	private Collection<Widget> items;

	public CustomerOrder(){
		
		items = new ArrayList<Widget>();
	}

	public CustomerOrder( String c ){
		customerName = c;
		items = new ArrayList<Widget>();
	}

	public long getID(){
		return id;
	}
	
	public String getName(){
		return customerName;
	}
	
	public Collection<Widget> getItems(){
		return items;
	}
	
	public void addItem( Widget w){
		items.add( w );
	}

	@Override
	public String toString() {
		String result = "[CustomerOrder #: " + id + ", from: " + customerName + ":- ";
		if (items != null) 
			for (Widget w : items)
				result = result + w;
		return result + " ]";
	}

}
