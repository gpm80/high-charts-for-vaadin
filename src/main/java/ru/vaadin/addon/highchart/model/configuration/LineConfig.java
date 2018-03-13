package ru.vaadin.addon.highchart.model.configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import ru.vaadin.addon.highchart.model.series.LineSeries;

/**
 * Конфигурация графика
 * Created by Petr Gusarov on 28.03.17.
 */
public class LineConfig<X, Y> extends ru.vaadin.addon.highchart.model.configuration.AbstractConfig<LineConfig<X, Y>> {

    private ru.vaadin.addon.highchart.model.options.XAxis<LineConfig<X, Y>, X> xAxis;
    private ru.vaadin.addon.highchart.model.options.YAxis<LineConfig<X, Y>, Y> yAxis;
    private List<ru.vaadin.addon.highchart.model.series.LineSeries<Y>> series;

    /**
     * Конструктор конфигурации для линейного графика
     */
    public LineConfig() {
        super(ru.vaadin.addon.highchart.model.value.ChartType.LINE);
        this.series = new ArrayList<>();
    }

    @Override
    LineConfig<X, Y> release() {
        return this;
    }


    public ru.vaadin.addon.highchart.model.options.XAxis<LineConfig<X, Y>, X> xAxis() {
        if (xAxis == null) {
            this.xAxis = new ru.vaadin.addon.highchart.model.options.XAxis<>(this);
        }
        return xAxis;
    }

    public ru.vaadin.addon.highchart.model.options.YAxis<LineConfig<X, Y>, Y> yAxis() {
        if (this.yAxis == null) {
            this.yAxis = new ru.vaadin.addon.highchart.model.options.YAxis<>(this);
        }
        return yAxis;
    }

    public ru.vaadin.addon.highchart.model.series.LineSeries<Y> addSeries() {
        ru.vaadin.addon.highchart.model.series.LineSeries<Y> s = new ru.vaadin.addon.highchart.model.series.LineSeries<>();
        series.add(s);
        return s;
    }

    /**
     * Сортировка серий по наименованию
     */
    public void sortSeriesByName() {
        Collections.sort(series, new Comparator<LineSeries<Y>>() {
            @Override
            public int compare(LineSeries<Y> o1, LineSeries<Y> o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
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
        for (ru.vaadin.addon.highchart.model.series.LineSeries<Y> ls : series) {
            lines.add(ls.toMap());
        }
        return ru.vaadin.addon.highchart.model.common.Mapper.builder()
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
