package kodlamaio.northwind.entities.concretes;

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
public class Category {
    @Id
    @Column(name="category_id")
    private int categoryId;

    @Column(name="category_name")
    private String categoryName;

    //ilişkilendirmeyi veriyoruz
    //ana yerde bir kere geçer diğer tabloda bir çok kere geçebilir
    @OneToMany(mappedBy = "categories")
    private List<Product> products; //kategorinin ürünleri
}
