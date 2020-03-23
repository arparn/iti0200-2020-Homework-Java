package ee.taltech.iti0200.greenhouse.plantingstrategy;

import java.util.*;

public class PlantInTurns implements PlantingStrategy {

    public HashMap<String, Integer> sortMap(Map<String, Integer> plants) {
        HashMap<String, Integer> answer = new LinkedHashMap<>();
        List<Map.Entry<String, Integer> > listOfPlants =
                new LinkedList<>(plants.entrySet());
        listOfPlants.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        for (Map.Entry<String, Integer> x : listOfPlants) {
            answer.put(x.getKey(), x.getValue());
        }
        return answer;
    }

    @Override
    public String[][] plantPlants(int length, int width, Map<String, Integer> plants) {
        HashMap<String, Integer> sortedPlants = sortMap(plants);
        String[][] greenhouse = new String[length][width];
        HashMap<String, Integer> sortedPlants2 = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                for (Map.Entry<String, Integer> plant : sortedPlants.entrySet()) {
                    if (sortedPlants2.size() == sortedPlants.size()) {
                        sortedPlants2.clear();
                    }
                    String key = plant.getKey();
                    Integer value = plant.getValue();
                    if (greenhouse[i][j] == null && !sortedPlants2.containsKey(key)) {
                        greenhouse[i][j] = key;
                        value -= 1;
                        sortedPlants2.put(key, value);
                    }
                    if (value <= 0) {
                        sortedPlants.remove(key);
                        sortedPlants2.remove(key);
                    } else {
                        sortedPlants.replace(key, value);
                    }
                }
            }
        }
        return greenhouse;
    }
}

