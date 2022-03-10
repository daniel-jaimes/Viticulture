package model;

import javax.persistence.*;

@Entity
@Table(name = "Entrada")
public class Entry {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "instrucciones")
    private String instructions;
}
