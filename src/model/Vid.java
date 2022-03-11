package model;

import util.VidType;

import javax.persistence.*;

@Entity
@Table(name = "Vid")
public class Vid {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "type")
    private VidType type;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne()
    @JoinColumn(name = "idCellar")
    private Cellar cellar;
    @ManyToOne()
    @JoinColumn(name = "idField")
    private Field field;

    public Vid(String type, int quantity, Field field) {
        this.type = VidType.valueOf(type.toUpperCase());
        this.quantity = quantity;
        this.field = field;
    }

    @Override
    public String toString() {
        return "Vid{" +
                "type=" + type +
                ", quantity=" + quantity +
                '}';
    }
}
