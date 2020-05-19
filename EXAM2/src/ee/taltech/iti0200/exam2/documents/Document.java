package ee.taltech.iti0200.exam2.documents;

import java.util.Optional;
import java.util.PrimitiveIterator;

public class Document {

    private int id;
    private Person owner;
    private String content;
    private boolean signed;
    private Person signer;

    public Document(int id, Person owner, String content) {
        this.id = id;
        this.owner = owner;
        this.content = content;
        this.signed = false;
    }

    public int getId() {
        return id;
    }

    public Person getOwner() {
        return owner;
    }

    public String getContent() {
        return content;
    }

    public boolean sign(Person signer) {
        if (!signer.equals(owner)) {
            if (signer.getAge() >= 18 && signer.isLicenceActive() && !signed) {
                signed = true;
                this.signer = signer;
                return true;
            }
        }
        return false;
    }

    public Optional<Person> getSigner() {
        if (signed) {
            return Optional.ofNullable(signer);
        } else {
            return Optional.empty();
        }
    }

    public boolean isSigned() {
        return signed;
    }
}
