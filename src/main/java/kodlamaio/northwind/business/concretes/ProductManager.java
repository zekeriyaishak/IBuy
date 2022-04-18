package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccesResult;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//ProductService referansı tutansın= implements
@Service
public class ProductManager implements ProductService {
    //Dataaccessdeki productdao ya ulaşmamız lazım
    private ProductDao productDao;
    //injektion yapıyoz.ProductDao interface(git).JpaRepo o da interface class yok yani.
    //Generic olarak çalışıyo arka planda verdiğimiz değerlere göre spring repo class ı oluşturuyo
    //Springden gelir. beans proje class ı demek. factory fabrika tasarım deseninin çalıştırır
    // spring arka planda buna karşılık gelebilcek productDao nun instance olabilcek sınıfı üretiyo.
    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll()
    {
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);//save methodu ıle ekleme guncelleme hızlıca yapılır
        return new SuccesResult("Ürün eklendi");
    }
}
