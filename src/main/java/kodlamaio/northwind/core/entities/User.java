package kodlamaio.northwind.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
//core katmanı sadece northwind değil ileride başka yerde de kullanırız dıye kodladım
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    @Email
    @NotBlank //boş geçilmesi yasak-message = "National ID is mandatory."
    @NotNull //message = "National ID is mandatory.
    private String email;

    @Column(name = "password")
    @NotBlank
    @NotNull
    private String password;
}
