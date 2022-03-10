package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Campo")
public class Field {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int idField;
    @OneToMany
    private List<Vid> vids;
    @Column(name = "id_cellar")
    private int idCellar;
}
