package ru.vaadin.addon.highchart;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;
import org.json.JSONArray;
import org.json.JSONException;
import ru.vaadin.addon.highchart.model.configuration.Configuration;

import java.util.HashMap;
import java.util.UUID;

/**
 * Линейная диаграма на основе HighCarts
 * Created by Petr Gusarov on 28.03.17.
 */
@JavaScript({"highcharts.js", "controller.js"})
public class HighChart extends AbstractJavaScriptComponent {

    private Configuration configuration;

    /**
     * Конструктор
     *
     * @param configuration реализация конфигурации диаграммы.
     */
    public HighChart(Configuration configuration) {
        String idDiv = UUID.randomUUID().toString();
        setId(idDiv);
        setSizeFull();
        this.configuration = configuration;
        addFunction("init", new JavaScriptFunction() {
            @Override
            public void call(JSONArray jsonArray) throws JSONException {
                refresh();
            }
        });
    }

    public HighChart() {
        this(null);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public void refresh() {
        callFunction("draw", getId(), configuration != null ? configuration.toMap() : new HashMap<String, Object>());
    }
}
