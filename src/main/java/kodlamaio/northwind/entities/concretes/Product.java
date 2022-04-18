package kodlamaio.northwind.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//2.commit için
//jpa alt yapısını kullanmamızı sağlıyor
@Entity
@Table(name="products")
// sen bir veritabanı nesnesisin
//Product bir entity
//çıplak class kalmasın yoksa ileride sorun çıkartır.
//bu class ın hangı katmana karşılık geldiğini soyutlama tekniği ile vermemiz gerekiyor
// SpringFramework bir class ın hangi katmana karşılık geldiğii sana soruyor.Anatasyonla yapıyor
//anatasyon- bir class'ın çalışma anında derleme anında onunla ilgili bilgi yapmak almak için yapı

@Data // lombok aracını kullandık. Getter/setter atamaya yarıyor/ sol altta structure^dan kontrol edebiliriz.
@AllArgsConstructor //tüm constructorlar geliyo
@NoArgsConstructor //parametresiz constructor
public class Product {
    //veri tabanında hangi tabloya denk geliyo ona bakıyoruz ve kolonlara
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id nin bir bir arttığını söylüyoruz
    @Column(name="product_id")
    private int id; // id numarası

    @Column(name="category_id")
    private int categoryId; // category numarası

    @Column(name="product_name")
    private String productName; // ürün ismi

    @Column(name="unit_price")
    private double unitPrice; // birim fiyatı

    @Column(name="units_in_stock")
    private short unitsInStock; //Stoktaki birim

    @Column(name="quantity_per_unit")
    private String quantityPerUnit; // bir birimde kaç tane var 6 lı kola da kac tane var gibi







}
