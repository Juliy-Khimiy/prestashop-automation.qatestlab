package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Admin on 22.05.2019.
 */
public class home_page {
    WebDriver driver;

    @FindBy(xpath ="//article[contains(@class, 'product-miniature js-product-miniature')]/div[contains(@class, 'thumbnail-container')]/div[contains(@class, 'product-description')]/div[contains(@class, 'product-price-and-shipping')]/span[contains(@class, 'price')]")
    public List <WebElement> value_price_popular_products;

    @FindBy(xpath ="//span[contains(@class, 'expand-more _gray-darker hidden-sm-down')]")
    public WebElement value_in_heder_page;

    @FindBy(xpath ="//ul[contains(@class, 'dropdown-menu hidden-sm-down')]/li[3]/a[contains(@class, 'dropdown-item')]")
    public WebElement value_usa;

    @FindBy(xpath ="//input[contains(@class, 'ui-autocomplete-input')]")
    public WebElement serch;

    @FindBy(xpath ="//*[@id=\"js-product-list\"]/div[1]/article/div")
    public List <WebElement> count_serch_for_dress;

    @FindBy(xpath ="//*[@id=\"js-product-list\"]/div[1]/article/div/div[1]/div/span[3]")
    public List <WebElement> value_sales_price_products_for_serch;

    @FindBy(xpath ="//*[@id=\"js-product-list\"]/div[1]/article/div/div[1]/div/span[1]")
    public List <WebElement> value_regular_price_products_for_serch;

    @FindBy(xpath ="//div[contains(@class, 'col-md-6 hidden-sm-down total-products')]/p")
    public WebElement count_products_in_page;

    @FindBy(xpath ="//a[contains(@class, 'select-title')]")
    public WebElement dropdown_list_sorting;

    @FindBy(xpath ="//*[@id=\"js-product-list-top\"]/div[2]/div/div/div/a[5]")
    public WebElement dropdown_list_element_sorting;

    @FindBy(xpath ="//*[@id=\"js-product-list\"]/div[1]/article/div/div[1]/div/span[contains (@class,'discount-percentage')]")
    public List <WebElement> discount_percent;


    //конструктор класса для передачи драйвера селениума
    public home_page(WebDriver b) {
        this.driver = b;
    }
    public void valueProduct(List <WebElement> some_element) throws InterruptedException {
        int i = 0;
        String value;
        for (i=0; i <=some_element.size()-1; i++)
        {   value= some_element.get(i).getText().toString();
            if (value.charAt(value.length()-1)==value_in_heder_page.getText().toString().charAt(value_in_heder_page.getText().trim().length() - 1))
            {  System.out.println("Значение элементов совпадает");     }
            else
            {    System.out.println("Значение элементов не совпадает");     }
        }

    }

    public void sortingValuePrise(){
        int i;
        double value;
        String  next_value,valueStr;
        value= 10000000.00;

        for (i=0; i <=value_regular_price_products_for_serch.size()-1; i++)
        {   valueStr = value_regular_price_products_for_serch.get(i).getText();
            next_value = Regex(valueStr);
            if (value>=Double.parseDouble(next_value))
            {   System.out.println("Значение элемента меньше предыдущего"+value+"---"+next_value+"");
                value=Double.parseDouble(next_value);
            }
            else
            {    System.out.println("Значение элемента больше предыдущего"+value+"---"+next_value+"");     }
        }
        }
    public String Regex(String qqqq) {
        String q;
        q=qqqq.replace(',', '.').substring(0,qqqq.replaceAll("\\s+","").length()-1);
        return q;
    }
    public static double round(double unrounded, int precision, int roundingMode)
    {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(precision, roundingMode);
        return rounded.doubleValue();
    }
    public  void price_befor_and_after_discont(){
    int i;
    double value_discont=0, value_regular_price = 0, value_discont_price=0;
        for (i=0; i <=discount_percent.size()-1; i++) {
            value_regular_price = Double.parseDouble(Regex(discount_percent.get(i).findElement(By.xpath(".//preceding-sibling::*")).getText().toString()));
            value_discont = Double.parseDouble(Regex(discount_percent.get(i).getText()));
            value_discont_price = Double.parseDouble(Regex(discount_percent.get(i).findElement(By.xpath(".//following-sibling::*")).getText().toString()));
            if (round(value_discont / 100 * value_regular_price + value_regular_price,2,BigDecimal.ROUND_HALF_UP) == value_discont_price) {
                System.out.println("Цена со скидкой правильная.");
            } else {
                System.out.println("Цена со скидкой не правильная.");
            }

        }
    }

}


