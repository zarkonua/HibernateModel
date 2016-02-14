package model;

import javax.persistence.*;

@Entity
@Table(name = "metricstoreparam",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class MetricstoreparamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true, length = 11)
    private int id;
    private int metricId;
    private int metricStoreTypeId;
    private int periodId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "metricId")
    public int getMetricId() {
        return metricId;
    }

    public void setMetricId(int metricId) {
        this.metricId = metricId;
    }

    @Basic
    @Column(name = "metricStoreTypeId")
    public int getMetricStoreTypeId() {
        return metricStoreTypeId;
    }

    public void setMetricStoreTypeId(int metricStoreTypeId) {
        this.metricStoreTypeId = metricStoreTypeId;
    }

    @Basic
    @Column(name = "periodId")
    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetricstoreparamEntity that = (MetricstoreparamEntity) o;

        if (id != that.id) return false;
        if (metricId != that.metricId) return false;
        if (metricStoreTypeId != that.metricStoreTypeId) return false;
        if (periodId != that.periodId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + metricId;
        result = 31 * result + metricStoreTypeId;
        result = 31 * result + periodId;
        return result;
    }
}
