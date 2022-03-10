package Viticulture.model;

import Viticulture.util.VidType;

import javax.persistence.*;

@Entity
@Table(name = "Vid")
public class Vid {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "type")
    private VidType type;
    @Column(name = "quantity")
    private int quantity;
}
