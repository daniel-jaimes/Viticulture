package exceptions;

import java.util.Arrays;
import java.util.List;

public class ExecutionException extends Exception {
    public static final int ERROR_DB = 0;
    private int value;
    private List<String> message = Arrays.asList(
            "<< Ha habido un error al conectarse con la Base de Datos >>"
    );
    public ExecutionException(int value){
        this.value = value;
    }

    @Override
    public String getMessage() {
        return message.get(value);
    }
}
