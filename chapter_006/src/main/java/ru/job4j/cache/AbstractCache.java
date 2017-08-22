package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract cache.
 * @param <K> - key of cache.
 * @param <String> - value of cache.
 */
public abstract class AbstractCache<K, String> {
    /**
     * Cache storage.
     */
    private Map<SoftReference<K>, String> cacheMap = new HashMap<>();

    /**
     * Methods adds new pair.
     * @param key - key of cache.
     * @param value - value of key in cache.
     */
    public void addNewPair(K key, String value) {
        this.cacheMap.put(new SoftReference<>(key), value);
    }

    /**
     * Method return value of param key in cache.
     * @param key of cache.
     * @return value of key.
     */
    public String getValue(K key) {
        return this.cacheMap.get(new SoftReference<K>(key));
    }

    /**
     * Method checks existence of fileName content. If there is no content, then put it in cache and
     * return content of param fileName. Else only return content of fileName.
     * @param fileName - file name with content.
     * @return content of fileName.
     */
    abstract String getContentFrom(String fileName);
}
