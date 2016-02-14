package model;

import javax.persistence.*;

@Entity
@Table(name = "grun",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"RUNID"})})
public class GrunEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RUNID", nullable = false, unique = true, length = 11)
    private int runId;
    private String simulationId;
    private int metricStoreParamId;

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
    }

    @Basic
    @Column(name = "simulationId")
    public String getSimulationId() {
        return simulationId;
    }

    public void setSimulationId(String simulationId) {
        this.simulationId = simulationId;
    }

    @Basic
    @Column(name = "metricStoreParamId")
    public int getMetricStoreParamId() {
        return metricStoreParamId;
    }

    public void setMetricStoreParamId(int metricStoreParamId) {
        this.metricStoreParamId = metricStoreParamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrunEntity that = (GrunEntity) o;

        if (runId != that.runId) return false;
        if (metricStoreParamId != that.metricStoreParamId) return false;
        if (simulationId != null ? !simulationId.equals(that.simulationId) : that.simulationId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = runId;
        result = 31 * result + (simulationId != null ? simulationId.hashCode() : 0);
        result = 31 * result + metricStoreParamId;
        return result;
    }
}
