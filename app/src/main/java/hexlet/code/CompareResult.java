package hexlet.code;

import lombok.Getter;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

//@AllArgsConstructor
@Getter
public class CompareResult {
    private String key;
    @JsonProperty("old value")
    private Object oldValue;
    @JsonProperty("new value")
    private Object newValue;
    private Status status;

    public CompareResult(String key, Object oldValue, Status status) {
        this.key = key;
        this.oldValue = oldValue;
        this.status = status;
    }

    public CompareResult(String key, Object oldValue, Object newValue, Status status) {
        this.key = key;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.status = status;
    }
}
