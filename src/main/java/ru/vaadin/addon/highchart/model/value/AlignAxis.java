package ru.vaadin.addon.highchart.model.value;

/**
 * Выравнивание наименования оси
 * Created by Petr Gusarov on 03.04.17.
 */
public enum AlignAxis {
    LOW("low"),
    MIDDLE("middle"),
    HIGH("high");

    private final String value;

    AlignAxis(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
