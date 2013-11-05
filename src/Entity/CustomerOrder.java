package Entity;

import javax.persistence.*;
import java.util.Collection;

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

    @ManyToMany
    private Collection<Widget> manyToMany;

    public Collection<Widget> getManyToMany() {
        return manyToMany;
    }

    public void setManyToMany(Collection<Widget> manyToMany) {
        this.manyToMany = manyToMany;
    }
}
