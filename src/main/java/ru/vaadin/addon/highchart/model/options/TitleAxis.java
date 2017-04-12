package ru.vaadin.addon.highchart.model.options;

import ru.vaadin.addon.highchart.model.common.Mapper;
import ru.vaadin.addon.highchart.model.configuration.Configuration;
import ru.vaadin.addon.highchart.model.value.AlignAxis;

import java.util.Map;

/**
 * Наименование осей
 * Created by Petr Gusarov on 29.03.17.
 */
public class TitleAxis<T> extends Parent<T> implements Configuration {

    private String text;
    private AlignAxis align;

    public TitleAxis(T parent) {
        super(parent);
        align = AlignAxis.MIDDLE;
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
    public TitleAxis<T> align(AlignAxis align) {
        this.align = align != null ? align : AlignAxis.MIDDLE;
        return this;
    }

    @Override
    public Map<String, Object> toMap() {
        return Mapper.builder().putNode("title",
                Mapper.builder()
                        .putIsExist("align", align)
                        .putIsExist("text", text)
                        .map()
        ).map();
    }
}
