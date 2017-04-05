package ru.efo.vaadin.addon.highchart.model.options;

import ru.efo.vaadin.addon.highchart.model.common.Mapper;

import java.util.Map;

/**
 * Настройки оси ординат
 * Created by Petr Gusarov on 28.03.17.
 */
public class YAxis<PARENT, Y> extends Axis<PARENT, YAxis<PARENT, Y>> {

    public YAxis(PARENT parent) {
        super(parent);
    }

    @Override
    YAxis<PARENT, Y> release() {
        return this;
    }

    @Override
    public Map<String, Object> toMap() {
        return Mapper.builder().putNode("yAxis",
                Mapper.builder(super.toMap())
                        .map()
        ).map();
    }
}
