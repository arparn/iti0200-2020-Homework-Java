package ee.taltech.iti0200.singleton;
import java.util.*;

public class UnicornRegistry {

    Map<Unicorn, UnicornObserver> unicornRegistry = new HashMap<>();

    private static UnicornRegistry instance = null;

    private UnicornRegistry() {}

    public static UnicornRegistry getInstance() {
        if (instance == null) {
            instance = new UnicornRegistry();
        }
        return instance;
    }

    public void registerUnicorn(Unicorn unicorn, UnicornObserver discoverer) {
        if (!unicornRegistry.containsKey(unicorn)) {
            unicornRegistry.put(unicorn, discoverer);
        }
    }

    public Set<Unicorn> getAllDiscoveredUnicorns(){
        return unicornRegistry.keySet();
    }

    public int getUnicornRarityIndex(Unicorn unicorn){
        Map<Unicorn.Size, Integer> size = new HashMap<>();
        size.put(Unicorn.Size.TINY, 1);
        size.put(Unicorn.Size.SMALL, 2);
        size.put(Unicorn.Size.MEDIUM, 3);
        size.put(Unicorn.Size.LARGE, 4);
        LinkedList<Unicorn> unicornList = new LinkedList<>();
        if (!unicornRegistry.containsKey(unicorn)) {
            return 0;
        }
        for (Unicorn uni : unicornRegistry.keySet()) {
            if (unicorn.getLocation().compareTo(uni.getLocation()) == 0) {
                if (unicorn.getColor().compareTo(uni.getColor()) == 0) {
                    if (unicorn.getHornLength() == uni.getHornLength()) {
                        if (size.get(unicorn.getSize()).equals(size.get(uni.getSize()))) {
                            for (Unicorn uni1 : unicornRegistry.keySet()) {
                                if (uni1.equals(unicorn)) {
                                    break;
                                } else if (uni1.equals(uni)) {
                                    unicornList.add(uni);
                                    break;
                                }
                            }
                        } else if (size.get(unicorn.getSize()) > size.get(uni.getSize())) {
                            unicornList.add(uni);
                        }
                    } else if (unicorn.getHornLength() < uni.getHornLength()) {
                        unicornList.add(uni);
                    }
                } else if (unicorn.getColor().compareTo(uni.getColor()) > 0) {
                    unicornList.add(uni);
                }
            } else if (unicorn.getLocation().compareTo(uni.getLocation()) > 0) {
                unicornList.add(uni);
            }
        }
        return unicornList.size() + 1;
    }

    public Set<Unicorn> getUnicornsDiscoveredBy(UnicornObserver observer){
        HashSet<Unicorn> uniSet = new HashSet<>();
        for (Unicorn unicorn : unicornRegistry.keySet()) {
            if (unicornRegistry.get(unicorn).equals(observer)) {
                uniSet.add(unicorn);
            }
        }
        return uniSet;
    }

    public void forgetAllUnicorns(){
        unicornRegistry.clear();
    }
}
