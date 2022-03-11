package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cellar")
public class Cellar {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "cellar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vid> vids;

    public Cellar(String nameCellar) {
        this.name = nameCellar;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cellar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
