package ru.vaadin.addon.highchart.model.configuration;


import ru.vaadin.addon.highchart.model.common.Mapper;
import ru.vaadin.addon.highchart.model.options.Chart;
import ru.vaadin.addon.highchart.model.options.Legend;
import ru.vaadin.addon.highchart.model.options.SubTitle;
import ru.vaadin.addon.highchart.model.options.Title;
import ru.vaadin.addon.highchart.model.value.ChartType;

import java.util.Map;

/**
 * Created by Petr Gusarov on 31.03.17.
 */
public abstract class AbstractConfig<TYPE> implements Configuration {

    private Title<TYPE> title;
    private SubTitle<TYPE> subTitle;
    private Legend<TYPE> legend;
    private Chart<TYPE> chart;

    public AbstractConfig(ChartType type) {
        this.chart = new Chart<>(release());
        chart.type(type);
    }

    /**
     * Метод получения экземпляра реализации класса
     *
     * @return
     */
    abstract TYPE release();

    /**
     * Очистка только данных диаграммы без очистки параметров
     */
    public abstract void clear();

    public Chart<TYPE> chart() {
        return chart;
    }

    /**
     * Заголовок диаграммы
     *
     * @return экземпляр класса заголовка
     */
    public Title<TYPE> title() {
        if (title == null) {
            title = new Title<>(release());
        }
        return title;
    }

    /**
     * Подзаголовок диаграммы
     *
     * @return экземпляр класса подзаголовка
     */
    public SubTitle<TYPE> subtitle() {
        if (this.subTitle == null) {
            this.subTitle = new SubTitle<>(release());
        }
        return subTitle;
    }

    /**
     * Легенда
     *
     * @return экземпляр класса легенды
     */
    public Legend<TYPE> legend() {
        if (legend == null) {
            legend = new Legend<>(release());
        }
        return legend;
    }

    @Override
    public Map<String, Object> toMap() {
        return Mapper.builder()
                .append(chart)
                .append(title)
                .append(subTitle)
                .append(legend)
                .map();
    }
}
