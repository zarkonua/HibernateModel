package model;

import javax.persistence.*;

@Entity
@Table(name = "sourcetype",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class SourcetypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true, length = 11)
    private int id;
    private int sourceId;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sourceId")
    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SourcetypeEntity that = (SourcetypeEntity) o;

        if (id != that.id) return false;
        if (sourceId != that.sourceId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + sourceId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
