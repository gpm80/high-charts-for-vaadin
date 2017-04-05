package ru.efo.vaadin.addon.highchart.model.options;

/**
 * Created by Petr Gusarov on 03.04.17.
 */
public class SubTitle<T> extends Title<T> {

    public SubTitle(T parent) {
        super(parent);
        key = "subtitle";
    }
}
