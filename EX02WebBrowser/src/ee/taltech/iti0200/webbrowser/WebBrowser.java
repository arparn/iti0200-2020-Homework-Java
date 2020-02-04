package ee.taltech.iti0200.webbrowser;
import java.util.*;

public class WebBrowser {
    private String homePage = "google.com";
    private LinkedList<String> history = new LinkedList<>(Collections.singletonList("google.com"));
    private Map<String, Integer> amountOfVisiting = new HashMap<>();
    private LinkedList<String> webPages = new LinkedList<>(Collections.singletonList("google.com"));
    private LinkedList<String> trashHold = new LinkedList<>();
    private LinkedList<String> bookmarks = new LinkedList<>();

    /**
     * Goes to homepage.
     */
    public void homePage() {
        history.add(homePage);
        webPages.add(homePage);
        trashHold.clear();
        if (!amountOfVisiting.containsKey(homePage)) {
            amountOfVisiting.put(homePage, 1);
        } else {
            int amount = amountOfVisiting.get(homePage);
            amountOfVisiting.replace(homePage, amount + 1);
        }
        System.out.println(homePage);
    }

    /**
     * Goes back to previous page.
     */
    public void back() {
        if (webPages.size() > 1) {
            String lastPage = webPages.get(webPages.size() - 2);
            String currentPage = webPages.getLast();
            history.add(lastPage);
            System.out.println(lastPage);
            int amount = amountOfVisiting.get(lastPage);
            amountOfVisiting.replace(lastPage, amount + 1);
            trashHold.add(currentPage);
            webPages.removeLast();
            }
        }

    /**
     * Goes forward to next page.
     */
    public void forward() {
        if (trashHold.size() > 0) {
            String newLastPage = trashHold.getLast();
            history.add(newLastPage);
            int amount = amountOfVisiting.get(newLastPage);
            amountOfVisiting.replace(newLastPage, amount + 1);
            System.out.println(newLastPage);
            webPages.add(newLastPage);
            trashHold.remove(newLastPage);
        }
    }

    /**
     * Go to a webpage.
     *
     * @param url to go to
     */
    public void goTo(String url) {
        history.add(url);
        webPages.add(homePage);
        trashHold.clear();
        if (!amountOfVisiting.containsKey(url)) {
            amountOfVisiting.put(url, 1);
        } else {
            int amount = amountOfVisiting.get(url);
            amountOfVisiting.replace(url, amount + 1);
        }
        System.out.println(url);
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

    public void setHomePage(String newHomePage) {
        homePage = newHomePage;
    }


    /**
     * Get top 3 visited pages.
     *
     * @return a String that contains top three visited pages separated with a newline "\n"
     */
    public String getTop3VisitedPages() {
        HashMap<String, Integer> top3 = new HashMap<>();
        StringBuilder answer = new StringBuilder();
        int topVisits = 0;
        String topWebsite = null;
        for (int i = 0; i < 3; i++) {
            for (Map.Entry mapElement : amountOfVisiting.entrySet()) {
                int amountOfVisits = ((int)mapElement.getValue());
                String website = ((String)mapElement.getKey());
                if (!top3.containsKey(website) && amountOfVisits > topVisits) {
                    topVisits = amountOfVisits;
                    topWebsite = website;
                }
            }
            answer.append(topWebsite).append(" - ").append(topVisits).append("\n");
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
            currentUrl = homePage;
        } else {
            currentUrl = history.getLast();
        }
        return currentUrl;
    }
}