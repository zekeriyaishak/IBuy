package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user){
        //? errordata resultta dönebilir succesdataresultta o yuzden ? yazdık
        //valid- validasyondan geçir demek
        return ResponseEntity.ok(this.userService.add(user));
    }
    //global exception handler yazcaz her yerde kullanılacak hata kodları-1 tane try catch yazarız oraya yazarız
    //genel veri tipi-base'i objecttir
    //bu sistemde şu tür hata olursa bu methodu devreye sok-ExceptionHandler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // bu method default olarak 500 hatası dönsün
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String,String>();
        for(FieldError fieldError: exceptions.getBindingResult().getFieldErrors()){
            //user'da olan o alanların tüm hataları oku demek üstteki
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");
        return errors;
        //eğer sistemde doğrulama hatası varsa yakala bad request olarak sarmalla, bir tane hashmap oluştur
        // tum hataları gez hashmap' e ekle errordata resultın ıcıne koy ve hataları döndür diyoruz
    }



}
