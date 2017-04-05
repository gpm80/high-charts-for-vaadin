package ru.efo.vaadin.addon.highchart.model.value;

/**
 * Выравнивание по вертикали
 * Created by Petr Gusarov on 03.04.17.
 */
public enum VerticalAlign {

    TOP("top"),
    MIDDLE("middle"),
    BOTTOM("bottom");
    private final String value;

    VerticalAlign(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
