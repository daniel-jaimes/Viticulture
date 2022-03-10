package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cellar")
public class Cellar {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int idCellar;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "cellar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vid> vids;
}
