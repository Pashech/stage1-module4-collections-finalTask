package com.epam.mjc.collections.combined;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {

        Map<Integer, Set<String>> result = new HashMap<>();
        Set<Integer> keys = new HashSet<>();
        List<String> values = new ArrayList<>();
        Set<String> tempSet = new HashSet<>();

        for (Map.Entry<String, Integer> m : sourceMap.entrySet()) {
            keys.add(m.getKey().length());
            values.add(m.getKey());
        }

        Iterator<Integer> keysIterator = keys.iterator();
        while (keysIterator.hasNext()) {
            int key = keysIterator.next();
            for (int i = 0; i < values.size(); i++) {
                if (values.get(i).length() == key) {
                    tempSet.add(values.get(i));
                }
            }
            result.put(key, tempSet);
            tempSet = new HashSet<>();
        }

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {

        Map<String, Integer> sourceMap = new HashMap<>();
        sourceMap.put("one", 1);
        sourceMap.put("two", 2);
        sourceMap.put("three", 3);
        sourceMap.put("five", 4);
        sourceMap.put("ten", 5);


        MapFromKeysCreator mapFromKeysCreator = new MapFromKeysCreator();
        mapFromKeysCreator.createMap(sourceMap);
    }
}
