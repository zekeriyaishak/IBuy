package kodlamaio.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"}) //sana söylediğim kadar mapping yap, verdiğim kadar sorgu yap // sürekli datayı tekrar tekrar getirmemizi sağlar
public class Category {
    @Id
    @Column(name="category_id")
    private int categoryId;

    @Column(name="category_name")
    private String categoryName;

    //ilişkilendirmeyi veriyoruz
    //ana yerde bir kere geçer diğer tabloda bir çok kere geçebilir
    @OneToMany(mappedBy = "category")
    private List<Product> products; //kategorinin ürünleri
}
