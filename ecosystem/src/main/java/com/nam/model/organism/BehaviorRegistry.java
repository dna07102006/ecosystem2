package com.nam.model.organism;

import java.util.HashMap;
import java.util.List;

public class BehaviorRegistry {
    private HashMap<String, List<Behavior>> behaviors = new HashMap<>();

    private HashMap<String, Behavior> behaviorsList = new HashMap<>();

    public BehaviorRegistry() {
        behaviorsList.put("wander", new Wandering());
        behaviorsList.put("photosynthesize", new Photosynthesize());
        behaviorsList.put("eat", new Eat());
        behaviorsList.put("hunt", new Hunt());
        behaviorsList.put("spawn", new Spawn());
    }

    public List<Behavior> get(String speciesId) throws IllegalArgumentException {
        if (!behaviors.containsKey(speciesId)) {
            List<Behavior> behaviorsOf;

            switch (speciesId) {
                case "grass":
                    behaviorsOf = List.of(behaviorsList.get("photosynthesize"), behaviorsList.get("spawn"));
                    break;
                case "rabbit":
                    behaviorsOf = List.of(behaviorsList.get("wander"), behaviorsList.get("eat"), behaviorsList.get("spawn"), behaviorsList.get("hunt"));
                    break;
                case "wolf":
                    behaviorsOf = List.of(behaviorsList.get("wander"), behaviorsList.get("hunt"), behaviorsList.get("spawn"), behaviorsList.get("eat"));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown species: " + speciesId);
            }

            behaviors.put(speciesId, behaviorsOf);
        }

        return behaviors.get(speciesId);
    }
}
