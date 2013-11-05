package Entity;

import javax.persistence.*;

@Entity
public class CustomerOrder {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public CustomerOrder() {

    }

    @Basic
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
