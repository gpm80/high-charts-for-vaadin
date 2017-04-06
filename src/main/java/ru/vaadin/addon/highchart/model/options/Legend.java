package ru.vaadin.addon.highchart.model.options;

import ru.vaadin.addon.highchart.model.value.Orientation;

import java.util.Map;

/**
 * Настройки легенды
 * Created by Petr Gusarov on 28.03.17.
 */
public class Legend<T> extends ru.vaadin.addon.highchart.model.options.Parent<T> implements ru.vaadin.addon.highchart.model.configuration.Configuration {

    private ru.vaadin.addon.highchart.model.value.Orientation orientation;
    private ru.vaadin.addon.highchart.model.value.Align align;
    private ru.vaadin.addon.highchart.model.value.VerticalAlign verticalAlign;

    /**
     * Конструктор
     *
     * @param parent предок
     */
    public Legend(T parent) {
        super(parent);
        orientation = Orientation.VERTICAL;
        align = ru.vaadin.addon.highchart.model.value.Align.RIGHT;
        verticalAlign = ru.vaadin.addon.highchart.model.value.VerticalAlign.MIDDLE;
    }

    /**
     * Расположение элементов легенды
     *
     * @param orientation
     * @return
     */
    public Legend<T> orientation(ru.vaadin.addon.highchart.model.value.Orientation orientation) {
        this.orientation = orientation;
        return this;
    }

    /**
     * @param align
     * @return
     */
    public Legend<T> align(ru.vaadin.addon.highchart.model.value.Align align) {
        this.align = align;
        return this;
    }

    /**
     * @param verticalAlign
     * @return
     */
    public Legend<T> verticalAlign(ru.vaadin.addon.highchart.model.value.VerticalAlign verticalAlign) {
        this.verticalAlign = verticalAlign;
        return this;
    }

    @Override
    public Map<String, Object> toMap() {
        return ru.vaadin.addon.highchart.model.common.Mapper.builder().putNode("legend",
                ru.vaadin.addon.highchart.model.common.Mapper.builder()
                        .putIsExist("layout", orientation)
                        .putIsExist("align", align)
                        .putIsExist("verticalAlign", verticalAlign)
                        .map()
        ).map();
    }


}
