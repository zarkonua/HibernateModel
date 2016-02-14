package model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "metricdata",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class MetricdataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true, length = 11)
    private int id;
    private Integer valueInt;
    private Double valueDouble;
    private String valueString;
    private byte[] valueBin;
    private int metricStoreParamId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "valueInt")
    public Integer getValueInt() {
        return valueInt;
    }

    public void setValueInt(Integer valueInt) {
        this.valueInt = valueInt;
    }

    @Basic
    @Column(name = "valueDouble")
    public Double getValueDouble() {
        return valueDouble;
    }

    public void setValueDouble(Double valueDouble) {
        this.valueDouble = valueDouble;
    }

    @Basic
    @Column(name = "valueString")
    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    @Basic
    @Column(name = "valueBin")
    public byte[] getValueBin() {
        return valueBin;
    }

    public void setValueBin(byte[] valueBin) {
        this.valueBin = valueBin;
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

        MetricdataEntity that = (MetricdataEntity) o;

        if (id != that.id) return false;
        if (metricStoreParamId != that.metricStoreParamId) return false;
        if (valueInt != null ? !valueInt.equals(that.valueInt) : that.valueInt != null) return false;
        if (valueDouble != null ? !valueDouble.equals(that.valueDouble) : that.valueDouble != null) return false;
        if (valueString != null ? !valueString.equals(that.valueString) : that.valueString != null) return false;
        if (!Arrays.equals(valueBin, that.valueBin)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (valueInt != null ? valueInt.hashCode() : 0);
        result = 31 * result + (valueDouble != null ? valueDouble.hashCode() : 0);
        result = 31 * result + (valueString != null ? valueString.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(valueBin);
        result = 31 * result + metricStoreParamId;
        return result;
    }
}
