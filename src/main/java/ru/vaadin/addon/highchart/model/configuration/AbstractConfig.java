package ru.vaadin.addon.highchart.model.configuration;

import java.util.Map;

/**
 * Created by Petr Gusarov on 31.03.17.
 */
public abstract class AbstractConfig<TYPE> implements ru.vaadin.addon.highchart.model.configuration.Configuration {

    private ru.vaadin.addon.highchart.model.options.Title<TYPE> title;
    private ru.vaadin.addon.highchart.model.options.SubTitle<TYPE> subTitle;
    private ru.vaadin.addon.highchart.model.options.Legend<TYPE> legend;
    private ru.vaadin.addon.highchart.model.options.Chart<TYPE> chart;

    public AbstractConfig(ru.vaadin.addon.highchart.model.value.ChartType type) {
        this.chart = new ru.vaadin.addon.highchart.model.options.Chart<>(release());
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

    public ru.vaadin.addon.highchart.model.options.Chart<TYPE> chart() {
        return chart;
    }

    /**
     * Заголовок диаграммы
     *
     * @return экземпляр класса заголовка
     */
    public ru.vaadin.addon.highchart.model.options.Title<TYPE> title() {
        if (title == null) {
            title = new ru.vaadin.addon.highchart.model.options.Title<>(release());
        }
        return title;
    }

    /**
     * Подзаголовок диаграммы
     *
     * @return экземпляр класса подзаголовка
     */
    public ru.vaadin.addon.highchart.model.options.SubTitle<TYPE> subtitle() {
        if (this.subTitle == null) {
            this.subTitle = new ru.vaadin.addon.highchart.model.options.SubTitle<>(release());
        }
        return subTitle;
    }

    /**
     * Легенда
     *
     * @return экземпляр класса легенды
     */
    public ru.vaadin.addon.highchart.model.options.Legend<TYPE> legend() {
        if (legend == null) {
            legend = new ru.vaadin.addon.highchart.model.options.Legend<>(release());
        }
        return legend;
    }

    @Override
    public Map<String, Object> toMap() {
        return ru.vaadin.addon.highchart.model.common.Mapper.builder()
                .append(chart)
                .append(title)
                .append(subTitle)
                .append(legend)
                .map();
    }
}
