package ee.taltech.iti0200.stream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KittenStatistics {

    private List<Kitten> kittens;

    public void setKittens(List<Kitten> kittens) {
        this.kittens = kittens;
    }

    public OptionalDouble findKittensAverageAge() {
        int sumOfAges = 0;
        sumOfAges = kittens.stream()
                .mapToInt(Kitten::getAge)
                .sum();
        if (sumOfAges > 0 && kittens.size() > 0) {
            return OptionalDouble.of((double) sumOfAges / (double) kittens.size());
        } else {
            return OptionalDouble.empty();
        }
    }

    public Optional<Kitten> findOldestKitten() {
        return kittens.stream().reduce((kitten1, kitten2) -> kitten1.getAge() > kitten2.getAge() ? kitten1:kitten2);
    }

    public List<Kitten> findYoungestKittens() {
        return kittens.stream()
                .filter(kitten -> kitten.getAge() == kittens
                        .stream()
                        .min(Comparator.comparingInt(Kitten::getAge))
                        .get()
                        .getAge())
                .collect(Collectors.toList());
    }

    public List<Kitten> findKittensAccordingToGender(Kitten.Gender gender) {
        return kittens.stream()
                .filter(kitten -> kitten.getGender() == gender)
                .collect(Collectors.toList());
    }

    public List<Kitten> findKittensBetweenAges(int minAge, int maxAge) {
        return kittens.stream()
                .filter(kitten -> minAge <= kitten.getAge() && kitten.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    public Optional<Kitten> findFirstKittenWithGivenName(String givenName) {
        List<Kitten> name = new ArrayList<>();
        name = kittens.stream()
                .filter(kitten -> kitten.getName()
                        .equals(givenName))
                .collect(Collectors.toList());
        if (name.size() > 0) {
            return Optional.ofNullable(name.get(0));
        } else {
            return Optional.empty();
        }
    }

    public List<Kitten> kittensSortedByAgeYoungerFirst() {
        return null;
    }

    public List<Kitten> kittensSortedByAgeOlderFirst() {
        return null;
    }

}