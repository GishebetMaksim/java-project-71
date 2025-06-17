package hexlet.code;

import lombok.Getter;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@AllArgsConstructor
@Getter
public class CompareResult {
    private String key;
    @JsonProperty("old value")
    private Object oldValue;
    @JsonProperty("new value")
    private Object newValue;
    private Status status;
}
