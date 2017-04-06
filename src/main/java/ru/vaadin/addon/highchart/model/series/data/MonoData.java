package ru.vaadin.addon.highchart.model.series.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Petr Gusarov on 04.04.17.
 */
public class MonoData<Y> implements ru.vaadin.addon.highchart.model.configuration.Configuration {

    private final List<Y> data;

    public MonoData() {
        data = new ArrayList<>();
    }

    public MonoData<Y> data(List<Y> values) {
        data.clear();
        data.addAll(values);
        return this;
    }

    @Override
    public Map<String, Object> toMap() {
        return ru.vaadin.addon.highchart.model.common.Mapper.builder()
                .putIsExist("data", data.toArray())
                .map();
    }
}
