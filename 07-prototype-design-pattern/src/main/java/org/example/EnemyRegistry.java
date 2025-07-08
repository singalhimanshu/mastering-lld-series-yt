package org.example;

import java.util.HashMap;
import java.util.Map;

public class EnemyRegistry {
    private Map<String, Enemy> registry;

    public EnemyRegistry() {
        this.registry = new HashMap<>();
    }


    public void register(final String type, final Enemy enemy) {
        this.registry.put(type, enemy);
    }

    public Enemy spawn(String type) {
        if (!registry.containsKey(type)) {
            throw new RuntimeException("type not found in registry, give type: " + type);
        }
        return registry.get(type).clone();
    }
}
