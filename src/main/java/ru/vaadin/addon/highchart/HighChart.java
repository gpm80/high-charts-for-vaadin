package ru.vaadin.addon.highchart;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

import java.util.UUID;

/**
 * Линейная диаграма на основе HighCarts
 * Created by Petr Gusarov on 28.03.17.
 */
@JavaScript({"highcharts.js", "controller.js"})
public class HighChart extends AbstractJavaScriptComponent {

    private final ru.vaadin.addon.highchart.model.configuration.Configuration configuration;

    /**
     * Конструктор
     *
     * @param configuration реализация конфигурации диаграммы.
     */
    public HighChart(ru.vaadin.addon.highchart.model.configuration.Configuration configuration) {
        String idDiv = UUID.randomUUID().toString();
        setId(idDiv);
        setSizeFull();
        this.configuration = configuration;
        addFunction("init", jsonArray -> {
            refresh();
        });
    }

    public void refresh() {
        callFunction("draw", getId(), configuration.toMap());
    }
}