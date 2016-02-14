package model;

import javax.persistence.*;

@Entity
@Table(name = "gscenario",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class GscenarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true, length = 11)
    private int id;
    private int gRunId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gRunId")
    public int getgRunId() {
        return gRunId;
    }

    public void setgRunId(int gRunId) {
        this.gRunId = gRunId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GscenarioEntity that = (GscenarioEntity) o;

        if (id != that.id) return false;
        if (gRunId != that.gRunId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + gRunId;
        return result;
    }
}
