package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Cellar")
public class Cellar {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "cellar")
    private List<Vid> vids;
    private Cellar(){

    }
    public Cellar(String nameCellar) {
        vids = new ArrayList<>();
        this.name = nameCellar;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setVids(List<Vid> vids) {
        this.vids = vids;
    }

    @Override
    public String toString() {
        return "[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vids=" + vids +
                ']';
    }
}
