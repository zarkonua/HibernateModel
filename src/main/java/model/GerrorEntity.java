package model;

import javax.persistence.*;

@Entity
@Table(name = "gerror",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class GerrorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true, length = 11)
    private int id;
    private int gRequestId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gRequestId")
    public int getgRequestId() {
        return gRequestId;
    }

    public void setgRequestId(int gRequestId) {
        this.gRequestId = gRequestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GerrorEntity that = (GerrorEntity) o;

        if (id != that.id) return false;
        if (gRequestId != that.gRequestId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + gRequestId;
        return result;
    }
}
