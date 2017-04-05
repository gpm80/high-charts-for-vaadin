package ru.efo.vaadin.addon.highchart.model.configuration;

import java.util.Map;

/**
 * Интерфейс конфигурации диаграммы
 * Created by Petr Gusarov on 29.03.17.
 */
public interface Configuration {

    Map<String, Object> toMap();
}
