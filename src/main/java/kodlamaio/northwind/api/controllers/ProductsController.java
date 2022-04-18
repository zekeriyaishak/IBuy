package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//s- api isimlendirme kuralı- çoğul verilir
@RestController //RESTFULL android,ios iletişimde bulunabilir
@RequestMapping("/api/products") // ürün,kategori,sepet işlemleri için ayrı kontroller olabilir bununla yapıyoruz.
public class ProductsController {
//Controller nedir-Android,ios,web in bizim backend kodumuzla anlaşması için yazılır
//dış dünyanın sistemimizle iletişim kurduğu yer
//servisimizin operasyonlarını yazalım
//veri istediğinde getMapping kullanılır

    private ProductService productService;//elimizde productmanager var
    //neden direkt manager kullanmıyoruz. iş nesnemizi değiştirebiliriz
    //unıttest-kodu kodla test edilir.controller test edilirken servis veri erişime gidilmez.
    //sahte manager oluşturuyoruz.sahte nesne oluşturuyoruz

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){ //requestbody json objesi gönderir hem istek yapıyo hem datan bu diyo
        return this.productService.add(product);
    }

}
