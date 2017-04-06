package ru.vaadin.addon.highchart.model.options;

import java.util.Map;

/**
 * Created by Petr Gusarov on 04.04.17.
 */
public class Chart<T> extends ru.vaadin.addon.highchart.model.options.Parent<T> implements ru.vaadin.addon.highchart.model.configuration.Configuration {

    private ru.vaadin.addon.highchart.model.value.ChartType type;

    public Chart(T parent) {
        super(parent);
    }

    public Chart<T> type(ru.vaadin.addon.highchart.model.value.ChartType type) {
        this.type = type;
        return this;
    }

    @Override
    public Map<String, Object> toMap() {
        return ru.vaadin.addon.highchart.model.common.Mapper.builder().putNode("chart",
                ru.vaadin.addon.highchart.model.common.Mapper.builder()
                        .putIsExist("type", this.type)
                        .map()
        ).map();
    }
}
