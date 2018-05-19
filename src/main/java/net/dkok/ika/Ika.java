package net.dkok.ika;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "IKA")
public class Ika {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Override
    public String toString() {
        return id + ": " + name;
    }
}
