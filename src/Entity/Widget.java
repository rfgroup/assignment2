package Entity;

import javax.persistence.*;

@Entity
public class Widget {
	 
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	private String name;
	private String description;
	private int quantity;

	
	public Widget() {
    	name = null;
    	description = null;
    	quantity = 0;
    	}

    public Widget(int quantity, String name,String description) {
    	this.setDescription(description);
    	this.name = name;
    	this.quantity = quantity;
    }
   
    public long getId() {
        return id;
    }

   
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString(){
		return "[Widget name: " + name + ", description: " + description + ", quanity: " + quantity + " ]";
		
	}
}
