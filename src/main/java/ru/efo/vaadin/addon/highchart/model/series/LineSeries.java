package ru.efo.vaadin.addon.highchart.model.series;

import ru.efo.vaadin.addon.highchart.model.series.data.MonoData;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Реализация данных линейных диаграмм
 * Created by Petr Gusarov on 03.04.17.
 */
public class LineSeries<Y> extends Series<LineSeries<Y>> {

    private final MonoData<Y> data;

    @Override
    LineSeries<Y> release() {
        return this;
    }

    public LineSeries() {
        data = new MonoData<>();
    }

    /**
     * Устанавливает ряд значений для диаграммы по оси Y
     *
     * @param values массив значений
     * @return
     */
    public LineSeries<Y> data(Y... values) {
        return data(Arrays.asList(values));
    }

    /**
     * Устанавливает ряд значений для диаграммы по оси Y
     *
     * @param values коллекция значений
     * @return
     */
    public LineSeries<Y> data(List<Y> values) {
        data.data(values);
        return this;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = super.toMap();
        map.putAll(data.toMap());
        return map;
    }
}
