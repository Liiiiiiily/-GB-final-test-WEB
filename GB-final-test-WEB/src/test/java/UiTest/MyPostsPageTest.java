package UiTests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyPostsPageTest extends AbstractTest {

    @Test
    @DisplayName("Valid: display posts")
    void postTest() throws IOException, InterruptedException {
        MyPostsPage myPostsPage = new MyPostsPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        assertTrue(myPostsPage.getPost1().isDisplayed());
        assertTrue(myPostsPage.getPost2().isDisplayed());
        assertTrue(myPostsPage.getPost3().isDisplayed());
        assertTrue(myPostsPage.getPost4().isDisplayed());
    }

    @Test
    @DisplayName("Valid: display post titles")
    public void postsTitleTest() throws InterruptedException, IOException {
        MyPostsPage myPostsPage = new MyPostsPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        assertTrue(myPostsPage.getPost1_title().isDisplayed());
        assertTrue(myPostsPage.getPost2_title().isDisplayed());
        assertTrue(myPostsPage.getPost3_title().isDisplayed());
        assertTrue(myPostsPage.getPost4_title().isDisplayed());
    }

    @Test
    @DisplayName("Valid: display post descriptions")
    public void postsDescriptionTest() throws InterruptedException, IOException {
        MyPostsPage myPostsPage = new MyPostsPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        assertTrue(myPostsPage.getPost1_description().isDisplayed());
        assertTrue(myPostsPage.getPost2_description().isDisplayed());
        assertTrue(myPostsPage.getPost3_description().isDisplayed());
        assertTrue(myPostsPage.getPost4_description().isDisplayed());
    }

    @Test
    @DisplayName("Valid: display post images")
    public void postsImgTest() throws InterruptedException, IOException {
        MyPostsPage myPostsPage = new MyPostsPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        assertTrue(myPostsPage.getPost1_img().isDisplayed());
        assertTrue(myPostsPage.getPost2_img().isDisplayed());
        assertTrue(myPostsPage.getPost3_img().isDisplayed());
        assertTrue(myPostsPage.getPost4_img().isDisplayed());
    }

    @Test
    @DisplayName("Valid: step to the previous page (preconditions: first page)")
    public void previousPageTest() throws InterruptedException, IOException {
        MyPostsPage myPostsPage = new MyPostsPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        getDriver().get("https://test-stand.gb.ru/?page=2");
        Thread.sleep(3000);
        myPostsPage.previousPage();
        Thread.sleep(3000);
        assertEquals("https://test-stand.gb.ru/?page=1", getDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Valid: step to the next page (preconditions: more than 5 posts)")
    public void nextPageTest() throws InterruptedException, IOException {
        MyPostsPage myPostsPage = new MyPostsPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        myPostsPage.nextPage();
        Thread.sleep(2000);
        assertEquals("https://test-stand.gb.ru/?page=2", getDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Invalid: step to the previous page")
    public void firstPageTest() throws InterruptedException, IOException {
        MyPostsPage myPostsPage = new MyPostsPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        myPostsPage.previousPage();
        Thread.sleep(2000);
        assertEquals("https://test-stand.gb.ru/", getDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Invalid: step from last page to next")
    public void lastPageTest() throws InterruptedException, IOException {
        MyPostsPage myPostsPage = new MyPostsPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        getDriver().get("https://test-stand.gb.ru/?page=3");
        Thread.sleep(3000);
        myPostsPage.nextPage();
        Thread.sleep(2000);
        assertEquals("https://test-stand.gb.ru/?page=3", getDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Invalid: no posts on the page")
    void postsTest() throws InterruptedException, IOException {
        MyPostsPage myPostsPage = new MyPostsPage(getDriver());
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginLessThanMinChar();
        Thread.sleep(1000);
        assertEquals("No items for your filter", myPostsPage.getMessage());
    }
}
