package ee.taltech.iti0200.webbrowser;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Map;
import java.util.List;

public class WebBrowser {
    private String currentHomePage = "google.com";
    private LinkedList<String> history = new LinkedList<>(Collections.singletonList("google.com"));
    private LinkedList<String> webPages = new LinkedList<>(Collections.singletonList("google.com"));
    private LinkedList<String> trashHold = new LinkedList<>();
    private LinkedList<String> bookmarks = new LinkedList<>();

    /**
     * Goes to homepage.
     */
    public void homePage() {
        history.add(currentHomePage);
        webPages.add(currentHomePage);
        trashHold.clear();
        }

    /**
     * Goes back to previous page.
     */
    public void back() {
        if (webPages.size() > 1) {
            history.add(webPages.get(webPages.size() - 2));
            trashHold.add(webPages.removeLast());
            }
        }

    /**
     * Goes forward to next page.
     */
    public void forward() {
        if (trashHold.size() > 0) {
            history.add(trashHold.getLast());
            webPages.add(trashHold.removeLast());
        }
    }

    /**
     * Go to a webpage.
     *
     * @param url to go to
     */
    public void goTo(String url) {
        history.add(url);
        webPages.add(url);
        trashHold.clear();
    }

    /**
     * Add a webpage as a bookmark.
     */
    public void addAsBookmark() {
        String currentUrl = getCurrentUrl();
        if (!bookmarks.contains(currentUrl)) {
            bookmarks.add(currentUrl);
        }
    }

    /**
     * Remove a bookmark.
     *
     * @param bookmark to remove
     */
    public void removeBookmark(String bookmark) {
        bookmarks.remove(bookmark);
    }

    public List<String> getBookmarks() {
        return bookmarks;
    }

    public void setCurrentHomePage(String newHomePage) {
        currentHomePage = newHomePage;
    }

    private HashMap<String, Integer> getMapOfVisits() {
        HashMap<String, Integer> answer = new HashMap<>();
        for (String webPage : history) {
            if (!answer.containsKey(webPage)) {
                answer.put(webPage, 1);
            } else {
                answer.replace(webPage, answer.get(webPage) + 1);
            }
        }
        return answer;
    }

    /**
     * Get top 3 visited pages.
     *
     * @return a String that contains top three visited pages separated with a newline "\n"
     */
    public String getTop3VisitedPages() {
        HashMap<String, Integer> top3 = new HashMap<>();
        StringBuilder answer = new StringBuilder();
        int identificationNumber;
        int topVisits = 0;
        int index = webPages.size();
        HashMap<String, Integer> mapOfVisits = getMapOfVisits();
        String topWebsite = null;
        if (mapOfVisits.size() == 1) {
            identificationNumber = 1;
        } else if (mapOfVisits.size() == 2) {
            identificationNumber = 2;
        } else {
            identificationNumber = 3;
        }
        for (int i = 0; i < identificationNumber; i++) {
            for (Map.Entry mapElement : mapOfVisits.entrySet()) {
                int amountOfVisits = ((int) mapElement.getValue());
                String website = ((String) mapElement.getKey());
                if (!top3.containsKey(website) && amountOfVisits >= topVisits && webPages.indexOf(website) < index) {
                    topVisits = amountOfVisits;
                    topWebsite = website;
                }
            }
            if (topVisits > 1) {
                answer.append(topWebsite).append(" - ").append(topVisits).append(" visits\n");
            } else {
                answer.append(topWebsite).append(" - ").append(topVisits).append(" visit\n");
            }
            top3.put(topWebsite, topVisits);
            topVisits = 0;
            topWebsite = "";
        }
        return answer.toString();
    }

    /**
     * Returns a list of all visited pages.
     *
     * Not to be confused with pages in your back-history.
     *
     * For example, if you visit "facebook.com" and hit back(),
     * then the whole history would be: ["google.com", "facebook.com", "google.com"]
     * @return list of all visited pages
     */
    public List<String> getHistory() {
        return history;
    }


    /**
     * Returns the active web page (string).
     *
     * @return active web page
     */
    public String getCurrentUrl() {
        String currentUrl;
        if (history.size() == 0) {
            currentUrl = currentHomePage;
        } else {
            currentUrl = history.getLast();
        }
        return currentUrl;
    }

    public static void main(String[] args) {
        WebBrowser webBrowserTest = new WebBrowser();
        //webBrowserTest.homePage();
        webBrowserTest.goTo("twitter.com");
        //webBrowserTest.back();
        //webBrowserTest.forward();
        System.out.println(webBrowserTest.webPages);
        System.out.println(webBrowserTest.getTop3VisitedPages());

    }
}


