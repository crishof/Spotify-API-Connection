package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Artist {

    private String id;
    private String name;
    private List<String> genres;
    private int popularity;
}
