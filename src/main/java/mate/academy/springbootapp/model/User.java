package mate.academy.springbootapp.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    private String id;
    private String profileName;
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
}
