package ee.taltech.iti0200.stream;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KittenStatistics {

    private List<Kitten> kittens;

    public void setKittens(List<Kitten> kittens) {
        this.kittens = kittens;
    }

    public OptionalDouble findKittensAverageAge() {
        int sumOfAges = kittens.stream()
                .mapToInt(Kitten::getAge)
                .sum();
        return OptionalDouble.of(sumOfAges / kittens.size());
    }

    public Optional<Kitten> findOldestKitten() {
        return kittens.stream().reduce((kitten1, kitten2) -> kitten1.getAge() > kitten2.getAge() ? kitten1:kitten2);
    }

    public List<Kitten> findYoungestKittens() {
        List<Kitten> youngest = kittens.stream()
                .filter(kitten -> kitten.getAge() == kittens
                        .stream()
                        .min(Comparator.comparingInt(Kitten::getAge))
                        .get()
                        .getAge())
                .collect(Collectors.toList());
        return youngest;
    }

    public List<Kitten> findKittensAccordingToGender(Kitten.Gender gender) {
        return null;
    }

    public List<Kitten> findKittensBetweenAges(int minAge, int maxAge) {
        return null;
    }

    public Optional<Kitten> findFirstKittenWithGivenName(String givenName) {
        return Optional.empty();
    }

    public List<Kitten> kittensSortedByAgeYoungerFirst() {
        return null;
    }

    public List<Kitten> kittensSortedByAgeOlderFirst() {
        return null;
    }

}