package http.api;

import lombok.Data;

import java.util.List;
@Data
public class Body {
    private int totalCount;
    private List<Items> items;
    private int pageNo;
    private int numOfRows;
}
