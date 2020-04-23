package ee.taltech.iti0200.singleton;

import java.util.Set;

public class UnicornObserver {
    private String name;
    private int skill;

    public UnicornObserver(String name, int skill) {
        this.name = name;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public int getSkill() {
        return skill;
    }

    void observe(Unicorn unicorn) {
        if (getSkill() >= 16) {
            UnicornRegistry.getInstance().registerUnicorn(unicorn, UnicornObserver.this);
        } else if (getSkill() >= 10 && (unicorn.getSize().equals(Unicorn.Size.SMALL)
                || unicorn.getSize().equals(Unicorn.Size.MEDIUM) || unicorn.getSize().equals(Unicorn.Size.LARGE))) {
            UnicornRegistry.getInstance().registerUnicorn(unicorn, UnicornObserver.this);
        } else if (getSkill() >= 4 && (unicorn.getSize().equals(Unicorn.Size.MEDIUM)
                || unicorn.getSize().equals(Unicorn.Size.LARGE))) {
            UnicornRegistry.getInstance().registerUnicorn(unicorn, UnicornObserver.this);
        } else if (getSkill() >= 0 && unicorn.getSize().equals(Unicorn.Size.LARGE)) {
            UnicornRegistry.getInstance().registerUnicorn(unicorn, UnicornObserver.this);
        }
    }

    public String brag() {
        Set<Unicorn> uniSet = UnicornRegistry.getInstance().getUnicornsDiscoveredBy(UnicornObserver.this);
        if (uniSet.size() == 0) {
            return "Sadly I have not discovered any unicorns.";
        }
        for (Unicorn unicorn : uniSet) {
            if (UnicornRegistry.getInstance().getUnicornRarityIndex(unicorn) == 1) {
                return "I discovered a " + unicorn.getColor() + " " + unicorn.getSize() + " unicorn at "
                        + unicorn.getLocation() + " and it is the rares unicorn.";
            }
        }
        Unicorn unicorn = null;
        for (Unicorn unicorn1 : uniSet) {
            unicorn = unicorn1;
            break;
        }
        return "I discovered a " + unicorn.getColor() + " " + unicorn.getSize() + " unicorn at " + unicorn.getLocation() + ".";
    }
}
