package http.api;

import lombok.Data;

@Data
public class Response {
    private Header header;
    private Body body;
}
