package ru.efo.vaadin.addon.highchart.model.value;

/**
 * Тип макета расположение элементов
 * Created by Petr Gusarov on 03.04.17.
 */
public enum Orientation {
    HORIZONTAL("horizontal"),
    VERTICAL("vertical");
    private final String value;

    Orientation(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
