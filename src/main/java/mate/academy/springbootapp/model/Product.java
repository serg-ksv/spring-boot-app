package mate.academy.springbootapp.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity(name = "product")
public class Product {
    @Id
    private String id;
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
