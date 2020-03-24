package ee.taltech.iti0200.greenhouse.plantingstrategy;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;;

public class PlantInColumns implements PlantingStrategy {

    public HashMap<String, Integer> sortMap(Map<String, Integer> plants) {
        HashMap<String, Integer> answer = new LinkedHashMap<>();
        List<Map.Entry<String, Integer>> listOfPlants =
                new LinkedList<>(plants.entrySet());
        listOfPlants.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Integer> plant : listOfPlants) {
            answer.put(plant.getKey(), plant.getValue());
        }
        return answer;
    }

    @Override
    public String[][] plantPlants(int length, int width, Map<String, Integer> plants) {
        HashMap<String, Integer> sortedPlants = sortMap(plants);
        String[][] greenhouse = new String[length][width];
        int j = 0;
        for (Map.Entry<String, Integer> plant : sortedPlants.entrySet()) {
            String key = plant.getKey();
            Integer value = plant.getValue();
            while (value > 0) {
                if (j >= width) {
                    break;
                }
                for (int i = 0; i < length; i++) {
                    if (value <= 0) {
                        break;
                    } else if (greenhouse[i][j] == null) {
                        greenhouse[i][j] = key;
                        value -= 1;
                    }
                }
                j += 1;
            }
            j = 0;
        }
        return greenhouse;
    }
}
