package com.academy.rozetka.page;

import com.academy.framework.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BasePage {

//    @FindBy(css = "html body app-root div.wrapper.central-wrapper " +
//            "div div.app-rz-header header.header div.layout " +
//            "div.header-topline div.header-topline__user.js-rz-auth " +
//            "div.header-topline__user-wrapper div.header-dropdown.header-" +
//            "dropdown_type_links ul.header-dropdown__links li.header-dropdown__list-item a")
//

    @FindBy(xpath = "/html/body/app-root/div/div[1]/div[1]/header/div/div[1]/div[3]/div[1]/div/ul/li[12]/a")
    WebElement signoutButton;

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public BasePage signout(boolean isCorrect){
        signoutButton.click();
        if (isCorrect)
            return new MainPage (driver);
        else
            return this;
    }
}
