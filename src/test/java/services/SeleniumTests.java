package services;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SeleniumTests {

    @Test
    void testMainPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/");
        assertEquals("Семейное древо", driver.findElement(By.tagName("h3")).getText());
        driver.quit();
    }

    @Test
    void testMainPageToPlaces() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/");
        driver.findElement(By.partialLinkText("Места")).click();
        assertEquals("Список всех резиденций", driver.findElement(By.tagName("h1")).getText());
        driver.quit();
    }

    @Test
    void testMainPageToPersons() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/");
        driver.findElement(By.partialLinkText("Люди")).click();
        assertEquals("Список всех людей", driver.findElement(By.tagName("h1")).getText());
        driver.quit();
    }

    @Test
    void testMainPageToMain() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/");
        driver.findElement(By.partialLinkText("На главную")).click();
        assertEquals("Семейное древо", driver.findElement(By.tagName("h3")).getText());
        driver.quit();
    }

    // Main Page Tested
    @Test
    void testPersonsPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/persons");
        assertEquals("Список всех людей", driver.findElement(By.tagName("h1")).getText());
        driver.quit();
    }

    @Test
    void testPersonsPageToPersons() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/persons");
        driver.findElement(By.partialLinkText("Люди")).click();
        assertEquals("Список всех людей", driver.findElement(By.tagName("h1")).getText());
        driver.quit();
    }
    @Test
    void testPersonsPageToMain() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/persons");
        driver.findElement(By.partialLinkText("На главную")).click();
        assertEquals("Семейное древо", driver.findElement(By.tagName("h3")).getText());
        driver.quit();
    }
    @Test
    void testPersonsPageToPlaces() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/persons");
        driver.findElement(By.partialLinkText("Места")).click();
        assertEquals("Список всех резиденций", driver.findElement(By.tagName("h1")).getText());
        driver.quit();
    }

    @Test
    void testPersonsPageToAdd(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/persons");
        driver.findElement(By.cssSelector("button.btn")).click();
        driver.findElement(By.name("FullName")).sendKeys("Тестовая персона");
        driver.findElement(By.name("birthday")).sendKeys("1988-05-04");
        driver.findElement(By.name("deathday")).sendKeys("1988-05-04");
        driver.findElement(By.cssSelector("button.btn")).click();
        driver.quit();
        PersonsPageToDelete("Тестовая персона");

    }

    void PersonsPageToAdd(String name){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/persons");
        driver.findElement(By.cssSelector("button.btn")).click();
        driver.findElement(By.name("FullName")).sendKeys(name);
        driver.findElement(By.name("birthday")).sendKeys("1988-05-04");
        driver.findElement(By.name("deathday")).sendKeys("1988-05-04");
        driver.findElement(By.cssSelector("button.btn")).click();
        driver.quit();
    }

    @Test
    void testPersonsPageToDelete(){
        PersonsPageToAdd("Персона для удаления");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/persons");
        int size = driver.findElements(By.tagName("tr")).size()-1;
        int i = 1;
        List<WebElement> elems = null;
        WebElement test;
        while (i < driver.findElements(By.tagName("tr")).size()){
            test = driver.findElements(By.tagName("tr")).get(i);
            elems = test.findElements(By.tagName("td"));
            if (Objects.equals(elems.get(0).getText(),"Персона для удаления")){
                break;
            }
            i++;
        }
        elems.get(0).findElement(By.partialLinkText("Персона для удаления")).click();
        driver.findElements(By.cssSelector("button.btn")).get(2).click();
        driver.get("http://localhost:8080/persons");
        assertEquals(size, driver.findElements(By.tagName("tr")).size());
        driver.quit();
    }

    void PersonsPageToDelete(String name){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/persons");
        int size = driver.findElements(By.tagName("tr")).size()-1;
        int i = 1;
        List<WebElement> elems = null;
        WebElement test;
        while (i < driver.findElements(By.tagName("tr")).size()){
            test = driver.findElements(By.tagName("tr")).get(i);
            elems = test.findElements(By.tagName("td"));
            if (Objects.equals(elems.get(0).getText(),name)){
                break;
            }
            i++;
        }
        elems.get(0).findElement(By.partialLinkText(name)).click();
        driver.findElements(By.cssSelector("button.btn")).get(2).click();
        driver.quit();
    }

    @Test
    void testPersonsPageToEdit(){
        PersonsPageToAdd("Персона для изменения");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/persons");
        int size = driver.findElements(By.tagName("tr")).size()-1;
        int i = 1;
        List<WebElement> elems = null;
        WebElement test;
        while (i < driver.findElements(By.tagName("tr")).size()){
            test = driver.findElements(By.tagName("tr")).get(i);
            elems = test.findElements(By.tagName("td"));
            if (Objects.equals(elems.get(0).getText(),"Персона для изменения")){
                break;
            }
            i++;
        }
        elems.get(0).findElement(By.partialLinkText("Персона для изменения")).click();
        driver.findElements(By.cssSelector("button.btn")).get(0).click();
        driver.findElement(By.name("deathday")).sendKeys("1999-05-04");
        driver.findElement(By.cssSelector("button.btn")).click();

        assertEquals("Дата смерти: 1999-05-04",driver.findElements(By.tagName("p")).get(1).getText());
        driver.quit();
        PersonsPageToDelete("Персона для изменения");
    }

    //Persons Test ends
    @Test
    void testPersonsToRelatives(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/persons");
        int size = driver.findElements(By.tagName("tr")).size()-1;
        int i = 1;
        List<WebElement> elems = null;
        WebElement test;
        while (i < driver.findElements(By.tagName("tr")).size()){
            test = driver.findElements(By.tagName("tr")).get(i);
            elems = test.findElements(By.tagName("td"));
            if (Objects.equals(elems.get(0).getText(),"Test")){
                break;
            }
            i++;
        }
        elems.get(0).findElement(By.partialLinkText("Test")).click();
        driver.findElements(By.cssSelector("button.btn")).get(1).click();
        assertEquals("Ближайшие родственники", driver.findElement(By.tagName("h1")).getText());
        driver.quit();
    }

    @Test
    void addRelationship(){
        PersonsPageToAdd("Брат 1");
        PersonsPageToAdd("Брат 2");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/persons");
        int size = driver.findElements(By.tagName("tr")).size()-1;
        int i = 1;
        List<WebElement> elems = null;
        WebElement test;
        while (i < driver.findElements(By.tagName("tr")).size()){
            test = driver.findElements(By.tagName("tr")).get(i);
            elems = test.findElements(By.tagName("td"));
            if (Objects.equals(elems.get(0).getText(),"Брат 1")){
                break;
            }
            i++;
        }
        elems.get(0).findElement(By.partialLinkText("Брат 1")).click();
        driver.findElements(By.cssSelector("button.btn")).get(1).click();
        driver.findElements(By.cssSelector("button.btn")).get(0).click();
        WebElement selectElement = driver.findElement(By.name("id_person_2"));
        Select select = new Select(selectElement);
        select.selectByVisibleText("Брат 2");
        selectElement = driver.findElement(By.name("relationshipTypes_2"));
        select = new Select(selectElement);
        select.selectByVisibleText("Brother");
        selectElement = driver.findElement(By.name("relationshipTypes_1"));
        select = new Select(selectElement);
        select.selectByVisibleText("Brother");
        selectElement = driver.findElement(By.name("roleType_2"));
        select = new Select(selectElement);
        select.selectByVisibleText("brotherhood");
        selectElement = driver.findElement(By.name("roleType_1"));
        select = new Select(selectElement);
        select.selectByVisibleText("brotherhood");
        driver.findElement(By.cssSelector("button.btn")).click();
        assertEquals(driver.findElements(By.tagName("p")).get(2).getText(),"Братья:  Брат 2");
        driver.findElements(By.tagName("a")).get(3).click();
        driver.findElements(By.cssSelector("button.btn")).get(1).click();
        assertEquals(driver.findElements(By.tagName("p")).get(2).getText(),"Братья:  Брат 1");
        driver.quit();
        PersonsPageToDelete("Брат 1");
        PersonsPageToDelete("Брат 2");

    }

    @Test
    void deleteRelationship(){
        PersonsPageToAdd("Брат 1");
        PersonsPageToAdd("Брат 2");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/persons");
        int size = driver.findElements(By.tagName("tr")).size()-1;
        int i = 1;
        List<WebElement> elems = null;
        WebElement test;
        while (i < driver.findElements(By.tagName("tr")).size()){
            test = driver.findElements(By.tagName("tr")).get(i);
            elems = test.findElements(By.tagName("td"));
            if (Objects.equals(elems.get(0).getText(),"Брат 1")){
                break;
            }
            i++;
        }
        elems.get(0).findElement(By.partialLinkText("Брат 1")).click();
        driver.findElements(By.cssSelector("button.btn")).get(1).click();
        driver.findElements(By.cssSelector("button.btn")).get(0).click();
        WebElement selectElement = driver.findElement(By.name("id_person_2"));
        Select select = new Select(selectElement);
        select.selectByVisibleText("Брат 2");
        selectElement = driver.findElement(By.name("relationshipTypes_2"));
        select = new Select(selectElement);
        select.selectByVisibleText("Brother");
        selectElement = driver.findElement(By.name("relationshipTypes_1"));
        select = new Select(selectElement);
        select.selectByVisibleText("Brother");
        selectElement = driver.findElement(By.name("roleType_2"));
        select = new Select(selectElement);
        select.selectByVisibleText("brotherhood");
        selectElement = driver.findElement(By.name("roleType_1"));
        select = new Select(selectElement);
        select.selectByVisibleText("brotherhood");
        driver.findElement(By.cssSelector("button.btn")).click();
        driver.findElements(By.cssSelector("button.btn")).get(1).click();

        selectElement = driver.findElement(By.name("id_relationship"));
        select = new Select(selectElement);
        select.selectByVisibleText("Брат 2");
        driver.findElement(By.cssSelector("button.btn")).click();
        assertEquals(driver.findElements(By.tagName("p")).get(2).getText(),"Братья:  информация отсутствует.");
        driver.get("http://localhost:8080/persons");
        size = driver.findElements(By.tagName("tr")).size()-1;
        i = 1;
        elems = null;
        while (i < driver.findElements(By.tagName("tr")).size()){
            test = driver.findElements(By.tagName("tr")).get(i);
            elems = test.findElements(By.tagName("td"));
            if (Objects.equals(elems.get(0).getText(),"Брат 2")){
                break;
            }
            i++;
        }
        elems.get(0).findElement(By.partialLinkText("Брат 2")).click();
        driver.findElements(By.cssSelector("button.btn")).get(1).click();
        assertEquals(driver.findElements(By.tagName("p")).get(2).getText(),"Братья:  информация отсутствует.");
        driver.quit();
        PersonsPageToDelete("Брат 1");
        PersonsPageToDelete("Брат 2");

    }

    //Relatives Tests


    @Test
    void testPlacePage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/places");
        assertEquals("Список всех резиденций", driver.findElement(By.tagName("h1")).getText());
        driver.quit();
    }

    @Test
    void testPlacePageToPersons() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/places");
        driver.findElement(By.partialLinkText("Люди")).click();
        assertEquals("Список всех людей", driver.findElement(By.tagName("h1")).getText());
        driver.quit();
    }
    @Test
    void testPlacePageToMain() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/places");
        driver.findElement(By.partialLinkText("На главную")).click();
        assertEquals("Семейное древо", driver.findElement(By.tagName("h3")).getText());
        driver.quit();
    }
    @Test
    void testPlacePageToPlaces() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/places");
        driver.findElement(By.partialLinkText("Места")).click();
        assertEquals("Список всех резиденций", driver.findElement(By.tagName("h1")).getText());
        driver.quit();
    }

    @Test
    void testAddPlace(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/places");
        int size1 = driver.findElements(By.tagName("tr")).size();

        driver.get("http://localhost:8080/person?personId=1056");
        driver.findElements(By.cssSelector("button.btn")).get(3).click();

        driver.findElement(By.name("address")).sendKeys("Тестовый адрес");
        driver.findElement(By.name("check_in")).sendKeys("1988-05-04");
        driver.findElement(By.name("check_out")).sendKeys("неизвестно");
        driver.findElement(By.cssSelector("button.btn")).click();

        driver.get("http://localhost:8080/places");
        int size = driver.findElements(By.tagName("tr")).size();
        assertEquals(size1+1,size);
        PlacePageToDeletePage("Тестовый адрес");
        driver.quit();
    }

    void AddPlace(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/places");

        driver.get("http://localhost:8080/person?personId=1056");
        driver.findElements(By.cssSelector("button.btn")).get(3).click();

        driver.findElement(By.name("address")).sendKeys("Тестовый адрес");
        driver.findElement(By.name("check_in")).sendKeys("1988-05-04");
        driver.findElement(By.name("check_out")).sendKeys("неизвестно");
        driver.findElement(By.cssSelector("button.btn")).click();

        driver.get("http://localhost:8080/places");
        driver.quit();
    }

    @Test
    void testPlacePageToEditPage(){
        AddPlace();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/places");
        int i = 1;
        List<WebElement> elems = null;
        WebElement test;
        while (i < driver.findElements(By.tagName("tr")).size()){
            test = driver.findElements(By.tagName("tr")).get(i);
            elems = test.findElements(By.tagName("td"));
            if (Objects.equals(elems.get(0).getText(),"Тестовый адрес")){
                break;
            }
            i++;
        }
        elems.get(4).findElement(By.cssSelector("button.btn")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys("Тестовый адрес изм");

        driver.findElement(By.name("check_out")).sendKeys("2020-05-04");
        driver.findElement(By.cssSelector("button.btn")).click();
        if(driver.findElement(By.partialLinkText("Тестовый адрес изм"))==null){
            driver.findElement(By.partialLinkText("Тестовый адрес изм,")).click();
        }
        else {
            driver.findElement(By.partialLinkText("Тестовый адрес изм")).click();
        }
        assertEquals("Дата выселения: 2020-05-04",driver.findElements(By.tagName("p")).get(2).getText());
        driver.findElement(By.cssSelector("button.btn")).click();
        driver.findElement(By.name("check_out")).clear();
        driver.findElement(By.name("check_out")).sendKeys("неизвестно");
        driver.findElement(By.cssSelector("button.btn")).click();
        PlacePageToDeletePage("Тестовый адрес изм");
        driver.quit();
    }

    @Test
    void testPlacePageToDeletePage(){
        AddPlace();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/places");
        int i = 1;
        List<WebElement> elems = null;
        WebElement test;
        while (i < driver.findElements(By.tagName("tr")).size()){
            test = driver.findElements(By.tagName("tr")).get(i);
            elems = test.findElements(By.tagName("td"));
            if (Objects.equals(elems.get(0).getText(),"Тестовый адрес")){
                break;
            }
            i++;
        }
        int size = driver.findElements(By.tagName("tr")).size();
        elems.get(5).findElement(By.cssSelector("button.btn")).click();
        driver.get("http://localhost:8080/places");
        assertEquals(size-1,driver.findElements(By.tagName("tr")).size());

        driver.quit();
    }



    void PlacePageToDeletePage(String name){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/places");
        int i = 1;
        List<WebElement> elems;
        WebElement test;
        while (true){
            test = driver.findElements(By.tagName("tr")).get(i);
            elems = test.findElements(By.tagName("td"));
            if (Objects.equals(elems.get(0).getText(),name)){
                break;
            }
            i++;
        }
        elems.get(5).findElement(By.cssSelector("button.btn")).click();
        driver.quit();
    }

    @Test
    void testPlacePageToResidence(){
        AddPlace();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://localhost:8080/places");
        int i = 1;
        List<WebElement> elems = null;
        WebElement test;
        while (i < driver.findElements(By.tagName("tr")).size()){
            test = driver.findElements(By.tagName("tr")).get(i);
            elems = test.findElements(By.tagName("td"));
            if (Objects.equals(elems.get(0).getText(),"Тестовый адрес")){
                break;
            }
            i++;
        }
        elems.get(0).findElement(By.partialLinkText("Тестовый адрес")).click();
        assertEquals("Информация о резиденции",driver.findElement(By.tagName("h1")).getText());
        driver.quit();
    }


}
