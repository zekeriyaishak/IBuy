package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
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

    Product getByProductNameAndCategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategoryId(String productName, int categoryId);

    List<Product> getByCategoryIdIn(List<Integer> categories);

    //isim ile filtreleme
    List<Product> getByProductNameContains(String productName);

    //ürün ismi şunla başlar filtreleme
    List<Product> getByProductNameStartsWith(String productName);

    //JPQL kodu = JPA Query LookupStrategy
    // : veya ? gibi şey görürsek parametre demek
    @Query("From Product where productName=:productName and categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);


}
