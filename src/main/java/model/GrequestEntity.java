package model;

import javax.persistence.*;

@Entity
@Table(name = "grequest",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class GrequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true, length = 11)
    private int id;
    private int gGroupId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gGroupId")
    public int getgGroupId() {
        return gGroupId;
    }

    public void setgGroupId(int gGroupId) {
        this.gGroupId = gGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrequestEntity that = (GrequestEntity) o;

        if (id != that.id) return false;
        if (gGroupId != that.gGroupId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + gGroupId;
        return result;
    }
}
