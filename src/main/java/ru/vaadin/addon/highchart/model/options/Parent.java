package ru.vaadin.addon.highchart.model.options;

/**
 * Абстрактный класс для возврата родительского класса
 * Created by Petr Gusarov on 31.03.17.
 */
public abstract class Parent<T> {

    protected T parent;

    public Parent(T parent) {
        this.parent = parent;
    }

    public T and() {
        return parent;
    }

}
