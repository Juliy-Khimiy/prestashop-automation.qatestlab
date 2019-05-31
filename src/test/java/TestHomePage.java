import Driver.Chrome;
import Page.Log4j;
import Page.home_page;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLException;

/**
 * Created by Admin on 22.05.2019.
 */
public class TestHomePage {
    private Chrome driver;
    private home_page homePage;
    private Log4j log;
    @BeforeTest
    public void setUp() throws SQLException {
        driver = new Chrome();
        driver.setDriver();
        homePage = PageFactory.initElements(driver.driver, home_page.class);
        log = PageFactory.initElements(driver.driver, Log4j.class);
        log.GetLogger().info("Инициализация драйвера и приминение настроек");
    }
    @Test
    public void testReg () throws InterruptedException {
        try {
            homePage.valueProduct(homePage.value_price_popular_products);
            log.GetLogger().info("Вызываем функцию сравнения валюты в хедре страницы с валютой популярных товаров.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.value_in_heder_page.click();
        log.GetLogger().info("Кликаем по списку валют в хедре.");
        Thread.sleep(1000);
        homePage.value_usa.click();
        log.GetLogger().info("Выбираем валюту USA");
        homePage.serch.sendKeys("dress");
        log.GetLogger().info("В строку поиска вводим значение \"dress\"");
        homePage.serch.submit();
        log.GetLogger().info("Подтверждаем поиск по введенному значению");
        Assert.assertEquals(homePage.count_products_in_page.getText(),"Товаров: "+homePage.count_serch_for_dress.size()+".");
        log.GetLogger().info("Сравниваем отображаемое количество товаров с выведеным значением количества в левой части экрана");
        homePage.valueProduct(homePage.value_sales_price_products_for_serch);
        log.GetLogger().info("Вызываем функцию сравнения значения валюты регулярной цены с выбраным значением валюты в хедре");
        homePage.valueProduct(homePage.value_regular_price_products_for_serch);
        log.GetLogger().info("Вызываем функцию сравнения значения валюты цены со скидкой с выбраным значением валюты в хедре");
        homePage.dropdown_list_sorting.click();
        log.GetLogger().info("Кликаем на список сортировки");
        homePage.dropdown_list_element_sorting.click();
        log.GetLogger().info("Выбираем сортировку");
        Thread.sleep(5000);
        homePage.sortingValuePrise();
        log.GetLogger().info("Вызываем функцию проверки сортировки");
        homePage.price_befor_and_after_discont();
        log.GetLogger().info("Вызываем функцию которая проверяет равна ли цена со скидкой регулярной цене - скидка");
    }
    @AfterTest
    public void tearDown() {
        log.GetLogger().info("Закрываем драйвер");
        driver.driver.quit();
    }
}
