package ru.vaadin.addon.highchart.model.options;

import java.util.Map;

/**
 * Элемент title
 * Created by Petr Gusarov on 28.03.17.
 */
public class Title<T> extends ru.vaadin.addon.highchart.model.options.Parent<T> implements ru.vaadin.addon.highchart.model.configuration.Configuration {

    protected String key;
    private String text;
    private ru.vaadin.addon.highchart.model.value.Align align;
    private ru.vaadin.addon.highchart.model.value.VerticalAlign verticalAlign;

    public Title(T parent) {
        super(parent);
        key = "title";
    }

    /**
     * Устанавливает наименование графика
     *
     * @param text наименование
     * @return
     */
    public Title<T> text(String text) {
        this.text = text;
        return this;
    }

    /**
     * Выравнивание по горизонтали
     *
     * @param align тип выравнивания
     * @return
     */
    public Title<T> align(ru.vaadin.addon.highchart.model.value.Align align) {
        this.align = align;
        return this;
    }

    /**
     * Выравнивание по вертикали
     *
     * @param verticalAlign тип выравнивания
     * @return
     */
    public Title<T> verticalAlign(ru.vaadin.addon.highchart.model.value.VerticalAlign verticalAlign) {
        this.verticalAlign = verticalAlign;
        return this;
    }

    @Override
    public Map<String, Object> toMap() {
        return ru.vaadin.addon.highchart.model.common.Mapper.builder().putNode(key,
                ru.vaadin.addon.highchart.model.common.Mapper.builder()
                        .putIsExist("text", text)
                        .putIsExist("align", align)
                        .putIsExist("verticalAlign", verticalAlign)
                        .map()
        ).map();
    }
}
