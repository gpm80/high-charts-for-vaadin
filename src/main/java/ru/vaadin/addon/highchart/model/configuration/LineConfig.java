package ru.vaadin.addon.highchart.model.configuration;

import ru.vaadin.addon.highchart.model.common.Mapper;
import ru.vaadin.addon.highchart.model.options.XAxis;
import ru.vaadin.addon.highchart.model.options.YAxis;

import ru.vaadin.addon.highchart.model.series.LineSeries;
import ru.vaadin.addon.highchart.model.value.ChartType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Конфигурация графика
 * Created by Petr Gusarov on 28.03.17.
 */
public class LineConfig<X, Y> extends ru.vaadin.addon.highchart.model.configuration.AbstractConfig<LineConfig<X, Y>> {

    private XAxis<LineConfig<X, Y>, X> xAxis;
    private YAxis<LineConfig<X, Y>, Y> yAxis;
    private List<LineSeries<Y>> series;

    /**
     * Конструктор конфигурации для линейного графика
     */
    public LineConfig() {
        super(ChartType.LINE);
        this.series = new ArrayList<>();
    }

    @Override
    LineConfig<X, Y> release() {
        return this;
    }


    public XAxis<LineConfig<X, Y>, X> xAxis() {
        if (xAxis == null) {
            this.xAxis = new XAxis<>(this);
        }
        return xAxis;
    }

    public YAxis<LineConfig<X, Y>, Y> yAxis() {
        if (this.yAxis == null) {
            this.yAxis = new YAxis<>(this);
        }
        return yAxis;
    }

    public LineSeries<Y> addSeries() {
        LineSeries<Y> s = new LineSeries<>();
        series.add(s);
        return s;
    }

    @Override
    public void clear() {
        series.clear();
        xAxis().clear();
    }

    @Override
    public Map<String, Object> toMap() {
//        checkData();
        List<Map<String, Object>> lines = new ArrayList<>();
        for (LineSeries<Y> ls : series) {
            lines.add(ls.toMap());
        }
        return Mapper.builder()
                .putIsExist("series", lines)
                .append(xAxis)
                .append(yAxis)
                .joinMap(super.toMap()
                ).map();
    }

//    /**
//     * Проверяет области данных на соответствие размеров
//     */
//    private void checkData() throws IllegalArgumentException {
//        if (getXAxis() != null && getXAxis().getCategories() != null) {
//            int lenData = getXAxis().getCategories().size();
//            getSeries().stream().forEach(seri -> {
//                if (seri.getData() == null || seri.getData().size() != lenData) {
//                    throw new IllegalArgumentException(String.format("Массив данных %s не соответствует размеру ", seri.getName()));
//                }
//            });
//        }
//    }
}
