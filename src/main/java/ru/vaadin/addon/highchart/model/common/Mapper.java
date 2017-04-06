package ru.vaadin.addon.highchart.model.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для заполнения карты
 * Created by Petr Gusarov on 03.04.17.
 */
public class Mapper {

    private final Map<String, Object> map;

    private Mapper(Map<String, Object> map) {
        this.map = map;
    }

    private Mapper() {
        this(new HashMap<>());
    }

    /**
     * Возвращает текущий экземпляр мапы
     *
     * @return
     */
    public Map<String, Object> map() {
        return map;
    }

    /**
     * Вставляет значение в мапу, только если значение не null
     *
     * @param key   ключ
     * @param value значение
     * @return
     */
    public Mapper putIsExist(String key, Object value) {
        if (value != null) {
            if (value instanceof Enum) {
                map.put(key, value.toString());
            } else {
                map.put(key, value);
            }
        }
        return this;
    }

    /**
     * Присоединение мапы
     *
     * @param map объединяемая карта
     * @return
     */
    public Mapper joinMap(Map<String, Object> map) {
        this.map.putAll(map);
        return this;
    }

    /**
     * Добавляет элемент конфигурации
     *
     * @param configuration конфигурация
     * @return
     */
    public Mapper append(ru.vaadin.addon.highchart.model.configuration.Configuration configuration) {
        if (configuration != null) {
            joinMap(configuration.toMap());
        }
        return this;
    }

    /**
     * @param key
     * @param value
     * @return
     */
    public Mapper putNode(String key, Map<String, Object> value) {
        if (value != null && !value.isEmpty()) {
            map.put(key, value);
        }
        return this;
    }

    /**
     * Создает билдер с мапой по умолчанию
     *
     * @return
     */
    public static Mapper builder() {
        return new Mapper();
    }

    /**
     * Создает билдер с переданной реализацией карты
     *
     * @param map экземпляр карты
     * @return
     */
    public static Mapper builder(Map<String, Object> map) {
        return new Mapper(map);
    }
}
