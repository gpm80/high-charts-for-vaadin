package ru.vaadin.addon.highchart.model.options;

import java.util.Map;

/**
 * Наименование осей
 * Created by Petr Gusarov on 29.03.17.
 */
public class TitleAxis<T> extends ru.vaadin.addon.highchart.model.options.Parent<T> implements ru.vaadin.addon.highchart.model.configuration.Configuration {

    private String text;
    private ru.vaadin.addon.highchart.model.value.AlignAxis align;

    public TitleAxis(T parent) {
        super(parent);
        align = ru.vaadin.addon.highchart.model.value.AlignAxis.MIDDLE;
    }

    /**
     * Заголовок оси
     *
     * @param text заголовок
     * @return
     */
    public TitleAxis<T> text(String text) {
        this.text = text;
        return this;
    }

    /**
     * Выравнивание заголовка оси
     *
     * @param align выравнивание
     * @return
     */
    public TitleAxis<T> align(ru.vaadin.addon.highchart.model.value.AlignAxis align) {
        this.align = align != null ? align : ru.vaadin.addon.highchart.model.value.AlignAxis.MIDDLE;
        return this;
    }

    @Override
    public Map<String, Object> toMap() {
        return ru.vaadin.addon.highchart.model.common.Mapper.builder().putNode("title",
                ru.vaadin.addon.highchart.model.common.Mapper.builder()
                        .putIsExist("align", align)
                        .putIsExist("text", text)
                        .map()
        ).map();
    }
}
