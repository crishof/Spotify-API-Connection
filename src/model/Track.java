package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Track {

    private String title;
    private List<String> artists;
    private List<String> genres;
    private LocalDate releaseDate;
    private String url;
    private int seconds;
}