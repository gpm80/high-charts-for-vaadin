package ru.vaadin.addon.highchart.model.options;

import ru.vaadin.addon.highchart.model.common.Mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Элемент оси X
 * Created by Petr Gusarov on 29.03.17.
 */
public class XAxis<PARENT, X> extends Axis<PARENT, XAxis<PARENT, X>> {

    private List<X> categories;

    public XAxis(PARENT parent) {
        super(parent);
        this.categories = new ArrayList<>();
    }

    @Override
    XAxis<PARENT, X> release() {
        return this;
    }

    public void clear() {
        categories.clear();
    }

    /**
     * Устанавливает данные катерогий диаграммы
     *
     * @param values коллекция данных
     * @return
     */
    public XAxis<PARENT, X> categories(List<X> values) {
        if (this.categories == null) {
            this.categories = new ArrayList<>();
        }
        categories.clear();
        categories.addAll(values);
        return this;
    }

    /**
     * Устанавливает данные катерогий диаграммы
     *
     * @param values массив данных
     * @return
     */
    public XAxis<PARENT, X> categories(X... values) {
        return categories(Arrays.asList(values));
    }

    @Override
    public Map<String, Object> toMap() {
        return Mapper.builder().putNode("xAxis",
                Mapper.builder()
                        .putIsExist("categories", categories)
                        .joinMap(super.toMap())
                        .map()
        ).map();
    }
}
