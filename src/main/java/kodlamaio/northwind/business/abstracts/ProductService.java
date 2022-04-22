package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

import java.util.List;
//Controller'ın kkullanacağı servisleri yazıyoruz
public interface ProductService {
    DataResult<List<Product>>  getAll();
    //sayfalama kodu-7.sayfayı atıyorum istiyorsun
    DataResult<List<Product>>  getAll(int pageNo,int pageSize);
    //Datayı istediğiö gibi getir
    DataResult<List<Product>>  getAllSorted();
    DataResult<List<Product>>  getAllSortedGrowing();
    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

    //isim ile filtreleme
    DataResult<List<Product>> getByProductNameContains(String productName);

    //ürün ismi şunla başlar filtreleme
    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();


}
