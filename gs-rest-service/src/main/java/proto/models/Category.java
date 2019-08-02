package proto.models;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// import org.springframework.data.annotation.CreatedDate;
// import org.springframework.data.annotation.LastModifiedDate;
// import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;



//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createAt", "updateAt"},
//                    allowGetters = true)

@Table(name = "category")
@Entity     // tells hibernate to make a table out of this class
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String imageurl;

    protected  Category() {}

    public Category(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageurl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageurl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageurl = imageUrl;
    }

}