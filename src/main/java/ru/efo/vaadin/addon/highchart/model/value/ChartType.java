package ru.efo.vaadin.addon.highchart.model.value;

/**
 * Типы графиков и диаграмм
 * Created by Petr Gusarov on 20.02.17.
 */
public enum ChartType {

    /**
     * Линейный график
     */
    LINE("line");

    private String value;

    ChartType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
