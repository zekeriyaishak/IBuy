package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//interface interface'i extends eder
//JpaRepo- verdiğin veri tipi için (product) primer key alanı (ınteger)
//ürünle ilgili crud operasyonları hazır oldu extends edince
//crud- create, read, update and delete
public interface ProductDao extends JpaRepository<Product,Integer> {
    //get i gördüğü anda tablolara bakıyo ilgili kolona göre ver koşulu veriyo
    Product getByProductName(String productName);

    //bana data getir neye göre produc name ve category'e göre
    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);

    //isim ile filtreleme
    List<Product> getByProductNameContains(String productName);

    //ürün ismi şunla başlar filtreleme
    List<Product> getByProductNameStartsWith(String productName);

    //JPQL kodu = JPA Query LookupStrategy
    // : veya ? gibi şey görürsek parametre demek
    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);

    @Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner join c.products p")
    //bu üç alanı productWithcategory'e aktar demek.
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
    //ne işe yarar dersen tam olarak sql e şunu yaz
    //select p.product_id, p.product_name, c.category_name from categories c inner join products p
    //on c.category_id= p.category_id
    //diğer sorgu ise
    //select p.product_id,p.product_name,c.category_name,p.unit_price from products p inner join categories c
    //on p.category_id= c.category_id
}
