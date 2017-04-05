package ru.efo.vaadin.addon.highchart;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.efo.vaadin.addon.highchart.model.configuration.Configuration;

import java.util.UUID;

/**
 * Линейная диаграма на основе HighCarts
 * Created by Petr Gusarov on 28.03.17.
 */
@JavaScript({"highcharts.js", "controller.js"})
public class HighChart extends AbstractJavaScriptComponent {

    private final Configuration configuration;

    /**
     * Конструктор
     *
     * @param configuration реализация конфигурации диаграммы
     */
    public HighChart(Configuration configuration) {
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
