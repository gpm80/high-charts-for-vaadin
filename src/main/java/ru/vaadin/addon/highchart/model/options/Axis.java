package ru.vaadin.addon.highchart.model.options;

import ru.vaadin.addon.highchart.model.common.Mapper;
import ru.vaadin.addon.highchart.model.configuration.Configuration;

import java.util.Map;

/**
 * Created by Petr Gusarov on 04.04.17.
 */
public abstract class Axis<PARENT, AXIS> extends Parent<PARENT> implements Configuration {

    public Axis(PARENT parent) {
        super(parent);
    }

    abstract AXIS release();

    protected TitleAxis<AXIS> title;

    public TitleAxis<AXIS> title() {
        if (title == null) {
            title = new TitleAxis<>(release());
        }
        return title;
    }

    @Override
    public Map<String, Object> toMap() {
        return Mapper.builder()
                .joinMap(title.toMap())
                .map();
    }
}
