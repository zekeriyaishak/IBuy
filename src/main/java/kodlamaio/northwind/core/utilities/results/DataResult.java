package kodlamaio.northwind.core.utilities.results;

public class DataResult<T> extends Result {
    //Data döndürmemiz gerek birden fazla veri tipi döndürebiliriz. T data
    private T data;
    public DataResult(T data, boolean success, String message) {
        super(success, message);
        this.data = data;
    }
    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

}
