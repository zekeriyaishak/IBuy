package kodlamaio.northwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDto {
    //Data object transfer- çok tablo oluyo ama biz kullandığımız buraya yazıp çekelım
    //tek tabloda dto kullanmak erişilebilirlik ve yeni özellik katmak için kullanılabilir
    private int id;
    private String productName;
    private String categoryName;

}
