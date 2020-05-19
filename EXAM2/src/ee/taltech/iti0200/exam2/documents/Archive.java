package ee.taltech.iti0200.exam2.documents;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Archive {

    private List<Document> documents = new LinkedList<>();

    public Archive() {
    }

    public boolean addDocument(Document doc) {
        if (doc.isSigned() && !documents.contains(doc)) {
            for (Document document : documents) {
                if (document.getId() == doc.getId()) {
                    return false;
                }
            }
            documents.add(doc);
            return true;
        } else {
            return false;
        }
    }

    public List<Document> getDocumentsByOwner(Person person) {
        List<Document> answer = new LinkedList<>();
        for (Document document : documents) {
            if (document.getOwner().equals(person)) {
                answer.add(document);
            }
        }
        return answer;
    }

    public List<Document> getDocumentsBySigner(Person signer) {
        List<Document> answer = new LinkedList<>();
        for (Document document : documents) {
            if (document.getSigner().isPresent() && document.getSigner().get().equals(signer)) {
                answer.add(document);
            }
        }
        return answer;
    }

    public Optional<Document> getDocumentById(int id) {
        for (Document document : documents) {
            if (document.getId() == id) {
                return Optional.of(document);
            }
        }
        return Optional.empty();
    }

    public List<Document> getDocumentsWithSimilarContent(String stringToLookFor) {
        List<Document> answer = new LinkedList<>();
        for (Document document : documents) {
            if (document.getContent().contains(stringToLookFor)) {
                answer.add(document);
            }
        }
        return answer;
    }

    public List<Document> getDocuments() {
        return documents;
    }
}
