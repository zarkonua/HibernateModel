package model;

import javax.persistence.*;

@Entity
@Table(name = "ggroup",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class GgroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true, length = 11)
    private int id;
    private int gGroupId;
    private int gScenarioId;

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

    @Basic
    @Column(name = "gScenarioId")
    public int getgScenarioId() {
        return gScenarioId;
    }

    public void setgScenarioId(int gScenarioId) {
        this.gScenarioId = gScenarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GgroupEntity that = (GgroupEntity) o;

        if (id != that.id) return false;
        if (gGroupId != that.gGroupId) return false;
        if (gScenarioId != that.gScenarioId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + gGroupId;
        result = 31 * result + gScenarioId;
        return result;
    }
}
