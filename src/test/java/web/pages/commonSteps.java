package web.pages;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import web.utils.Driver;

import java.util.HashMap;
import java.util.Map;
import web.utils.commonUtils;

public class commonSteps extends Driver {
    login log = new login();
    cakes cake = new cakes();

    @Step("Open Cake box website <URL>")
    public void openURL(String url) {
        driver.get(System.getenv(url));
        commonUtils.screenshot("login");
    }

    @Step("Click on Login link")
    public void click_Login() {
        login.clickonLogin();
    }

    @Step("Enter <EMAILID> and <PASSWORD> to login")
    public void Enter_Customer_Details(String emailid, String password) {
        log.EnterCustomerDetails(emailid, password);
        commonUtils.screenshot("Credentials");
    }

    @Step("Click on Login button")
    public void Loginbutton() {
        log.clickloginbutton();
    }

    @Step("Select Kids Cake category")
    public void SelectCategory() {
        cake.selectKidscake();
        commonUtils.pause(2);
        commonUtils.screenshot("cake");
    }

    @Step("Enter cake details and Add to Cart <table>")
    public void AddtoCart(Table table) {
        if (!table.equals(null)) {
            try {
                Map<String, String> mapobj = new HashMap<>();
                if (table.getTableRows().size() > 0) {
                    mapobj = commonUtils.ConvertchildtableTomap(table);
                    cake.addTocart(mapobj);
                    commonUtils.screenshot("cart");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Step("Delete items from cart")
    public void deleteitems() {
        cakes.deleteall();

    }

    @Step("Verify all items are deleted from cart")
    public void verifyDelete() {
     cakes.deleteVerify();
        commonUtils.screenshot("deletecart");
    }
}
