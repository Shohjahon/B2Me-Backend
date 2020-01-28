package uz.module.commerce.inventory.model.payload;

public class Response<T> {
    private Integer code;
    private String message;
    private T response;

    public Response() {
    }

    public Response(Integer code, String message, T response) {
        this.code = code;
        this.message = message;
        this.response = response;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", response=" + response +
                '}';
    }
}
