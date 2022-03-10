package Viticulture.model;

import javax.persistence.*;

@Entity
@Table(name = "Cellar")
public class Entry {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "instrucciones")
    private String instructions;
}
