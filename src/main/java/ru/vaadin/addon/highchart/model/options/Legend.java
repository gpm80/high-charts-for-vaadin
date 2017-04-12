package ru.vaadin.addon.highchart.model.options;

import ru.vaadin.addon.highchart.model.common.Mapper;
import ru.vaadin.addon.highchart.model.configuration.Configuration;
import ru.vaadin.addon.highchart.model.value.Align;
import ru.vaadin.addon.highchart.model.value.Orientation;
import ru.vaadin.addon.highchart.model.value.VerticalAlign;

import java.util.Map;

/**
 * Настройки легенды
 * Created by Petr Gusarov on 28.03.17.
 */
public class Legend<T> extends Parent<T> implements Configuration {

    private Orientation orientation;
    private Align align;
    private VerticalAlign verticalAlign;

    /**
     * Конструктор
     *
     * @param parent предок
     */
    public Legend(T parent) {
        super(parent);
        orientation = Orientation.VERTICAL;
        align = Align.RIGHT;
        verticalAlign = VerticalAlign.MIDDLE;
    }

    /**
     * Расположение элементов легенды
     *
     * @param orientation
     * @return
     */
    public Legend<T> orientation(Orientation orientation) {
        this.orientation = orientation;
        return this;
    }

    /**
     * @param align
     * @return
     */
    public Legend<T> align(Align align) {
        this.align = align;
        return this;
    }

    /**
     * @param verticalAlign
     * @return
     */
    public Legend<T> verticalAlign(VerticalAlign verticalAlign) {
        this.verticalAlign = verticalAlign;
        return this;
    }

    @Override
    public Map<String, Object> toMap() {
        return Mapper.builder().putNode("legend",
                Mapper.builder()
                        .putIsExist("layout", orientation)
                        .putIsExist("align", align)
                        .putIsExist("verticalAlign", verticalAlign)
                        .map()
        ).map();
    }


}
