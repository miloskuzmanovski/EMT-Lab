package mk.ukim.finki.emt.labbookstore.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Data
public class Country {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String continent;

    public Country() {
    }

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}