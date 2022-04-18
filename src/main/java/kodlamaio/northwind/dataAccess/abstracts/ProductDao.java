package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//interface interface'i extends eder
public interface ProductDao extends JpaRepository<Product,Integer> {
//JpaRepo- verdiğin veri tipi için (product) primer key alanı (ınteger)
//ürünle ilgili crud operasyonları hazır oldu extends edince
//crud- create, read, update and delete

}
