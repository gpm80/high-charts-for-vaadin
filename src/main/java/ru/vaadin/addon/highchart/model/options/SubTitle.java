package ru.vaadin.addon.highchart.model.options;

/**
 * Created by Petr Gusarov on 03.04.17.
 */
public class SubTitle<T> extends ru.vaadin.addon.highchart.model.options.Title<T> {

    public SubTitle(T parent) {
        super(parent);
        key = "subtitle";
    }
}
