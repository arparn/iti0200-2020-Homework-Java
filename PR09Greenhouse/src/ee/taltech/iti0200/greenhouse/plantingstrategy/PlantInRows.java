package ee.taltech.iti0200.greenhouse.plantingstrategy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;


public class PlantInRows implements PlantingStrategy {

    public HashMap<String, Integer> sortMap(Map<String, Integer> plants) {
        HashMap<String, Integer> answer = new LinkedHashMap<>();
        List<Map.Entry<String, Integer> > listOfPlants =
                new LinkedList<>(plants.entrySet());
        listOfPlants.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Integer> x : listOfPlants) {
            answer.put(x.getKey(), x.getValue());
        }
        return answer;
    }

    @Override
    public String[][] plantPlants(int length, int width, Map<String, Integer> plants) {
        HashMap<String, Integer> sortedPlants = sortMap(plants);
        String[][] greenhouse = new String[width][length];
        for (Map.Entry<String, Integer> plant : sortedPlants.entrySet()) {
            String key = plant.getKey();
            Integer value = plant.getValue();
            for (int i = 0; i < width; i++) {
                if (value <= 0) {
                    break;
                }
                for (int j = 0; j < length; j++) {
                    if (value <= 0) {
                        break;
                    } else if (greenhouse[i][j] == null) {
                        greenhouse[i][j] = key;
                        value -= 1;
                    }
                }
            }
        }
        return greenhouse;
    }
}
