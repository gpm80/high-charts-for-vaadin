package ru.vaadin.addon.highchart.model.options;

import java.util.Map;

/**
 * Настройки оси ординат
 * Created by Petr Gusarov on 28.03.17.
 */
public class YAxis<PARENT, Y> extends ru.vaadin.addon.highchart.model.options.Axis<PARENT, YAxis<PARENT, Y>> {

    public YAxis(PARENT parent) {
        super(parent);
    }

    @Override
    YAxis<PARENT, Y> release() {
        return this;
    }

    @Override
    public Map<String, Object> toMap() {
        return ru.vaadin.addon.highchart.model.common.Mapper.builder().putNode("yAxis",
                ru.vaadin.addon.highchart.model.common.Mapper.builder(super.toMap())
                        .map()
        ).map();
    }
}
