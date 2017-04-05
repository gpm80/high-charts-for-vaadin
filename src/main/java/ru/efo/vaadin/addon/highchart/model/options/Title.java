package ru.efo.vaadin.addon.highchart.model.options;

import ru.efo.vaadin.addon.highchart.model.common.Mapper;
import ru.efo.vaadin.addon.highchart.model.configuration.Configuration;
import ru.efo.vaadin.addon.highchart.model.value.Align;
import ru.efo.vaadin.addon.highchart.model.value.VerticalAlign;

import java.util.Map;

/**
 * Элемент title
 * Created by Petr Gusarov on 28.03.17.
 */
public class Title<T> extends Parent<T> implements Configuration {

    protected String key;
    private String text;
    private Align align;
    private VerticalAlign verticalAlign;

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
    public Title<T> align(Align align) {
        this.align = align;
        return this;
    }

    /**
     * Выравнивание по вертикали
     *
     * @param verticalAlign тип выравнивания
     * @return
     */
    public Title<T> verticalAlign(VerticalAlign verticalAlign) {
        this.verticalAlign = verticalAlign;
        return this;
    }

    @Override
    public Map<String, Object> toMap() {
        return Mapper.builder().putNode(key,
                Mapper.builder()
                        .putIsExist("text", text)
                        .putIsExist("align", align)
                        .putIsExist("verticalAlign", verticalAlign)
                        .map()
        ).map();
    }
}
