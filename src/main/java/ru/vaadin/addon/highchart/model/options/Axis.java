package ru.vaadin.addon.highchart.model.options;

import java.util.Map;

/**
 * Created by Petr Gusarov on 04.04.17.
 */
public abstract class Axis<PARENT, AXIS> extends ru.vaadin.addon.highchart.model.options.Parent<PARENT> implements ru.vaadin.addon.highchart.model.configuration.Configuration {

    public Axis(PARENT parent) {
        super(parent);
    }

    abstract AXIS release();

    protected ru.vaadin.addon.highchart.model.options.TitleAxis<AXIS> title;

    public ru.vaadin.addon.highchart.model.options.TitleAxis<AXIS> title() {
        if (title == null) {
            title = new ru.vaadin.addon.highchart.model.options.TitleAxis<>(release());
        }
        return title;
    }

    @Override
    public Map<String, Object> toMap() {
        return ru.vaadin.addon.highchart.model.common.Mapper.builder()
                .joinMap(title.toMap())
                .map();
    }
}
