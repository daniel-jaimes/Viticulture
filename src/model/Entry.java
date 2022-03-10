package model;

import javax.persistence.*;

@Entity
@Table(name = "Entrada")
public class Entry {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "instruccion")
    private String instructions;

    public int getId() {
        return id;
    }

    public String getInstructions() {
        return instructions;
    }
}
