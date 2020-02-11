package ee.taltech.iti0200.webbrowser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class WebBrowserTest {
    WebBrowser webBrowser;


    @BeforeEach
    void setUp() {
        webBrowser = new WebBrowser();
    }

    @Test
    void homePage() {
        webBrowser.homePage();
        assertEquals("google.com", webBrowser.getCurrentUrl());
    }

    @Test
    void homePageReturn() {
        webBrowser.goTo("mail.ru");
        webBrowser.homePage();
        assertEquals("google.com", webBrowser.getCurrentUrl());
    }

    @Test
    void back() {
        webBrowser.goTo("youtube.com");
        webBrowser.goTo("facebook.com");
        webBrowser.back();
        assertEquals("youtube.com", webBrowser.getCurrentUrl());
    }

    @Test
    void forward() {
        webBrowser.goTo("facebook.com");
        webBrowser.back();
        webBrowser.forward();
        assertEquals("facebook.com", webBrowser.getCurrentUrl());
    }

    @Test
    void goTo() {
        webBrowser.goTo("ained.ttu.ee");
        webBrowser.goTo("reddit.com");
        assertEquals("reddit.com", webBrowser.getCurrentUrl());
    }

    @Test
    void addAsBookmark() {
        webBrowser.goTo("ained.ttu.ee");
        webBrowser.addAsBookmark();
        LinkedList<String> bookMark = new LinkedList<>(Collections.singletonList("ained.ttu.ee"));
        assertEquals(bookMark, webBrowser.getBookmarks());
    }

    @Test
    void removeBookmark() {
        webBrowser.goTo("ained.ttu.ee");
        webBrowser.addAsBookmark();
        webBrowser.goTo("facebook.com");
        webBrowser.addAsBookmark();
        webBrowser.removeBookmark("ained.ttu.ee");
        LinkedList<String> bookMark = new LinkedList<>(Collections.singletonList("facebook.com"));
        assertEquals(bookMark, webBrowser.getBookmarks());
    }

    @Test
    void getBookmarks() {
        webBrowser.goTo("youtube.com");
        webBrowser.addAsBookmark();
        webBrowser.goTo("facebook.com");
        webBrowser.addAsBookmark();
        LinkedList<String> bookMark = new LinkedList<>(Arrays.asList("youtube.com", "facebook.com"));
        assertEquals(bookMark, webBrowser.getBookmarks());
    }

    @Test
    void setHomePage() {
        webBrowser.setCurrentHomePage("yandex.ru");
        webBrowser.homePage();
        assertEquals("yandex.ru", webBrowser.getCurrentUrl());
    }

    @Test
    void getTop3VisitedPages() {
        webBrowser.goTo("youtube.com");
        webBrowser.goTo("youtube.com");
        webBrowser.goTo("youtube.com");
        webBrowser.goTo("twitter.com");
        webBrowser.goTo("twitter.com");
        assertEquals("youtube.com - 3 visits\ntwitter.com - 2 visits\ngoogle.com - 1 visit\n", webBrowser.getTop3VisitedPages());
    }

    @Test
    void getHistory() {
        webBrowser.goTo("youtube.com");
        webBrowser.goTo("facebook.com");
        webBrowser.goTo("twitter.com");
        webBrowser.back();
        LinkedList<String> history = new LinkedList<>(Arrays.asList("google.com", "youtube.com", "facebook.com", "twitter.com", "facebook.com"));
        assertEquals(history, webBrowser.getHistory());
    }

    @Test
    void getCurrentUrl() {
        webBrowser.goTo("facebook.com");
        webBrowser.goTo("twitter.com");
        assertEquals("twitter.com", webBrowser.getCurrentUrl());
    }
}