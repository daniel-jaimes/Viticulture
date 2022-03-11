package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Field")
public class Field {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int idField;
    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vid> vids;
    @Column(name = "idCellar")
    private int idCellar;

    public Field(int idCellar) {
        this.idCellar = idCellar;
    }

    public int getIdField() {
        return idField;
    }

    public int getIdCellar() {
        return idCellar;
    }
}
