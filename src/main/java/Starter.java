import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class Starter {
    public static void main(String[] args) {
        SourceEntity source = new SourceEntity("garlic 1");

        //Get Session
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(source);

        System.out.println("Source Table: " + "Source ID=" + source.getId() + " Name=" + source.getName());

        SourcetypeEntity sourcetypeEntity = new SourcetypeEntity();
        sourcetypeEntity.setName("Source Type Name 1");
        sourcetypeEntity.setSourceId(source.getId());
        session.save(sourcetypeEntity);

        System.out.println("SourceType Table: " + "SourceType ID=" + sourcetypeEntity.getId() + " Name=" + sourcetypeEntity.getName() + " Source ID=" + sourcetypeEntity.getSourceId());

        MetricEntity metricEntity = new MetricEntity();
        metricEntity.setName("metric name 1");
        metricEntity.setDescription("metric description 1");
        metricEntity.setSourceTypeId(sourcetypeEntity.getSourceId());

        session.save(metricEntity);

        System.out.println("Metric Table: " + "Metric ID=" + metricEntity.getId() + " Name=" + metricEntity.getName() + " SourceType ID=" + metricEntity.getSourceTypeId());

        MetricstoretypeEntity metricstoretypeEntity = new MetricstoretypeEntity();
        metricstoretypeEntity.setName("metricstoretypeEntity name 1");
        metricstoretypeEntity.setPoints("Points 1");
        metricstoretypeEntity.setSpan(343);

        session.save(metricstoretypeEntity);

        System.out.println("Metricstoretype Table: " + "Metricstoretype ID=" + metricstoretypeEntity.getId() + " Name=" + metricstoretypeEntity.getName());

        PeriodEntity periodEntity = new PeriodEntity();
        periodEntity.setStart(new Date());
        periodEntity.setEnd(new Date());

        session.save(periodEntity);

        System.out.println("PeriodEntity Table: " + "PeriodEntity ID=" + periodEntity.getId() + " Name=" + periodEntity.getStart());

        MetricstoreparamEntity metricstoreparamEntity = new MetricstoreparamEntity();
        metricstoreparamEntity.setMetricStoreTypeId(metricstoretypeEntity.getId());
        metricstoreparamEntity.setPeriodId(periodEntity.getId());
        metricstoreparamEntity.setMetricId(metricEntity.getId());

        session.save(metricstoreparamEntity);

        System.out.println("MetricstoreparamEntity Table: " + "MetricstoreparamEntity ID=" + metricstoreparamEntity.getId() + " getPeriodId=" + metricstoreparamEntity.getPeriodId() + " getMetricStoreTypeId=" + metricstoreparamEntity.getMetricStoreTypeId());

        byte[] bytes = "".getBytes();
        MetricdataEntity metricdataEntity = new MetricdataEntity();
        metricdataEntity.setValueBin(bytes);
        metricdataEntity.setValueDouble(1d);
        metricdataEntity.setValueInt(2);
        metricdataEntity.setValueString("value");
        metricdataEntity.setMetricStoreParamId(metricstoreparamEntity.getId());

        session.save(metricdataEntity);

        System.out.println("MetricdataEntity Table: " + "MetricdataEntity ID=" + metricdataEntity.getId() + " getMetricStoreParamId=" + metricdataEntity.getMetricStoreParamId());

        GrunEntity grunEntity = new GrunEntity();
        grunEntity.setSimulationId("simulation Id 1");
        grunEntity.setMetricStoreParamId(metricstoreparamEntity.getId());

        session.save(grunEntity);

        System.out.println("GrunEntity Table: " + "GrunEntity ID=" + grunEntity.getRunId() + " getMetricStoreParamId=" + grunEntity.getMetricStoreParamId());

        GscenarioEntity gscenarioEntity = new GscenarioEntity();
        gscenarioEntity.setgRunId(grunEntity.getRunId());

        session.save(gscenarioEntity);

        System.out.println("GscenarioEntity Table: " + "GscenarioEntity ID=" + gscenarioEntity.getId() + " getMetricStoreParamId=" + gscenarioEntity.getgRunId());

        GgroupEntity ggroupEntity = new GgroupEntity();
        ggroupEntity.setgScenarioId(gscenarioEntity.getId());
//        ggroupEntity.setgGroupId(1);

        session.save(ggroupEntity);

        System.out.println("GgroupEntity Table: " + "GgroupEntity ID=" + ggroupEntity.getId() + " getgGroupId=" + ggroupEntity.getgGroupId());

        GrequestEntity grequestEntity = new GrequestEntity();
        grequestEntity.setgGroupId(ggroupEntity.getId());

        session.save(grequestEntity);

        System.out.println("GrequestEntity Table: " + "GrequestEntity ID=" + grequestEntity.getId() + " getgGroupId=" + grequestEntity.getgGroupId());

        GerrorEntity gerrorEntity = new GerrorEntity();
        gerrorEntity.setgRequestId(grequestEntity.getId());

        session.save(gerrorEntity);
        session.getTransaction().commit();

        System.out.println("GerrorEntity Table: " + "GerrorEntity ID=" + gerrorEntity.getId() + " GerrorEntity=" + gerrorEntity.getgRequestId());

        //terminate session factory, otherwise program won't end
        sessionFactory.close();
    }
}

