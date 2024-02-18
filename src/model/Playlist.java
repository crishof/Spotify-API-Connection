package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Playlist {

    private String title;
    private String description;
    private List<Track> tracks;
    private List<String> comments;
    private LocalDate creationDate;
}
