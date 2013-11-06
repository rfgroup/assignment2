package WidgetOrder.Entity;
/**
 * <p>Title: Widget Inventory s</p>
 * <p>Description: CS 343 Assignment #2</p>
 * @author Aaron Cook, Kyle Kornetske, Michael Haas, Kyle Kolstad
 * @email aaron.cook@my.uwrf.edu, michael.haas@my.uwrf.edu,
 * 			kyle.kornetske@my.uwrf.edu kyle.kolstad@my.uwrf.edu
 * @date November 5th 2013
 * @team Group 4
 */ 
import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "Widget.findAll", query = "select w from Widget w"),
        @NamedQuery(name = "Widget.findById", query = "select w from Widget w where w.id = :id"),
        @NamedQuery(name = "Widget.findByName", query = "select w from Widget w where w.name = :name")
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
