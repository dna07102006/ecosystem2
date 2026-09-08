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
        behaviorsList.put("metabolize", new Metabolize());
    }

    public List<Behavior> get(String speciesId) throws IllegalArgumentException {
        if (!behaviors.containsKey(speciesId)) {
            List<Behavior> behaviorsOf;

            switch (speciesId) {
                case "grass":
                    behaviorsOf = List.of(behaviorsList.get("photosynthesize"), behaviorsList.get("spawn"));
                    break;
                case "rabbit":
                    behaviorsOf = List.of(behaviorsList.get("hunt"), behaviorsList.get("wander"), behaviorsList.get("eat"), behaviorsList.get("spawn"), behaviorsList.get("metabolize"));
                    break;
                case "wolf":
                    behaviorsOf = List.of(behaviorsList.get("hunt"), behaviorsList.get("wander"), behaviorsList.get("eat"), behaviorsList.get("spawn"), behaviorsList.get("metabolize"));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown species: " + speciesId);
            }

            behaviors.put(speciesId, behaviorsOf);
        }

        return behaviors.get(speciesId);
    }
}
