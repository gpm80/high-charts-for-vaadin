package ru.vaadin.addon.highchart.model.series;

import java.util.Map;

/**
 * Абстрактная реализация ряда
 * Created by Petr Gusarov on 20.02.17.
 */
public abstract class Series<T> implements ru.vaadin.addon.highchart.model.configuration.Configuration {

    protected String name;
    protected String color;

    abstract T release();

    public Series() {
        this.name = "series";
    }

    /**
     * Устанавливает наименование ряда
     *
     * @param name наименование
     * @return
     */
    public T name(String name) {
        this.name = name;
        return release();
    }

    /**
     * Возвращает наименование серии
     *
     * @return
     */
    public String getName() {
        if (name == null) {
            return "";
        }
        return name;
    }

    /**
     * Устанавливает цвет ряда по RGB параметрам
     *
     * @param r красный
     * @param g зеленый
     * @param b синий
     * @return
     */
    public T color(int r, int g, int b) {
        return color(ru.vaadin.addon.highchart.model.common.Color.convertRGBtoString((byte) r, (byte) g, (byte) b));
    }

    /**
     * Устанавливает цвет ряда по 0xFF значению
     *
     * @param color цвет в формате #RRGGBB
     * @return
     */
    public T color(String color) {
        this.color = color;
        return release();
    }

    @Override
    public Map<String, Object> toMap() {
        return ru.vaadin.addon.highchart.model.common.Mapper.builder()
            .putIsExist("name", name)
            .putIsExist("color", color)
            .map();
    }
}
