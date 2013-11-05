package WidgetOrder.Entity;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Widget.findAll", query = "select w from Widget w"),
    @NamedQuery(name = "Widget.findById", query = "select w from Widget w where w.id = :id")
})
public class Widget {

    public Widget() {}

    public Widget(int quantity, String name,String description) {
        this.setDescription(description);
        this.name = name;
        this.quantity = quantity;
    }
	 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    @Basic
	private String name;

    public String getName() {
        return name;
    }

    public Widget setName(String name) {
        this.name = name;

        return this;
    }

    @Basic
	private String description;

    public String getDescription() {
        return description;
    }

    public Widget setDescription(String description) {
        this.description = description;

        return this;
    }

    @Basic
	private int quantity;
   
    public int getQuantity() {
        return quantity;
    }

    public Widget setQuantity(int quantity) {
        this.quantity = quantity;

        return this;
    }

	@Override
	public String toString(){
		return "[Widget name: " + name + ", description: " + description + ", quanity: " + quantity + " ]";
		
	}
}
