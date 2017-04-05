package ru.efo.vaadin.addon.highchart.model.options;

import ru.efo.vaadin.addon.highchart.model.common.Mapper;
import ru.efo.vaadin.addon.highchart.model.configuration.Configuration;
import ru.efo.vaadin.addon.highchart.model.value.ChartType;

import java.util.Map;

/**
 * Created by Petr Gusarov on 04.04.17.
 */
public class Chart<T> extends Parent<T> implements Configuration {

    private ChartType type;

    public Chart(T parent) {
        super(parent);
    }

    public Chart<T> type(ChartType type) {
        this.type = type;
        return this;
    }

    @Override
    public Map<String, Object> toMap() {
        return Mapper.builder().putNode("chart",
                Mapper.builder()
                        .putIsExist("type", this.type)
                        .map()
        ).map();
    }
}
