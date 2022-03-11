package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Field")
public class Field {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int idField;
    @OneToMany(mappedBy = "field")
    private List<Vid> vids;
    @Column(name = "idCellar")
    private int idCellar;

    public Field(int idCellar) {
        vids = new ArrayList<>();
        this.idCellar = idCellar;
    }
    private Field(){

    }
    public int getIdField() {
        return idField;
    }

    public int getIdCellar() {
        return idCellar;
    }

    public List<Vid> getVids() {
        return vids;
    }

    @Override
    public String toString() {
        return "[" +
                "idField=" + idField +
                ", vids=" + vids +
                ", Cellar=" + idCellar +
                ']';
    }
}
