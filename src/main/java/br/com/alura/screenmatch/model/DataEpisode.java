package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataEpisode(@JsonAlias("Title") String title,

                          @JsonAlias ("Episode") Integer numberEpisode,

                          @JsonAlias ("imdbRating") String episodeRating,

                          @JsonAlias ("Released") String releaseDate) {

}
