package ru.efo.vaadin.addon.highchart.model.common;

/**
 * Created by Petr Gusarov on 03.04.17.
 */
public class Color {

    /**
     * Преобразует цвет из RGB в строковое представление типа #FF00BB
     *
     * @param r красный
     * @param g зеленый
     * @param b синий
     * @return
     */
    public static String convertRGBtoString(byte r, byte g, byte b) {
        return String.format("#%02x%02x%02x", r, g, b);
    }
}
