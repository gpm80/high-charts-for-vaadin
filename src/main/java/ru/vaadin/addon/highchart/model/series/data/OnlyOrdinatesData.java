package ru.vaadin.addon.highchart.model.series.data;

import ru.vaadin.addon.highchart.model.common.Mapper;
import ru.vaadin.addon.highchart.model.configuration.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Данные со значениями только по оси ординат
 * Created by Petr Gusarov on 04.04.17.
 */
public class OnlyOrdinatesData<Y> implements Configuration {

    private final List<Y> data;

    public OnlyOrdinatesData() {
        data = new ArrayList<>();
    }

    public OnlyOrdinatesData<Y> data(List<Y> values) {
        data.clear();
        data.addAll(values);
        return this;
    }

    @Override
    public Map<String, Object> toMap() {
        return Mapper.builder()
                .putIsExist("data", data.toArray())
                .map();
    }
}
