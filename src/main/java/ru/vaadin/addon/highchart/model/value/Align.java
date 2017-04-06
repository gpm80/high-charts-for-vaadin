package ru.vaadin.addon.highchart.model.value;

/**
 * Выравнивание по горизонтали
 * Created by Petr Gusarov on 03.04.17.
 */
public enum Align {
    LEFT("left"),
    CENTER("center"),
    RIGHT("right");
    private final String value;

    Align(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
