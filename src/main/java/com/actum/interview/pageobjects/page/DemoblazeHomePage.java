package com.actum.interview.pageobjects.page;

import com.actum.interview.pageobjects.panel.MenuPanel;
import com.actum.interview.pageobjects.panel.SignupPanel;
import com.actum.interview.pageobjects.panel.LoginPanel;

public class DemoblazeHomePage extends AbstractPage {

    private static DemoblazeHomePage instance = null;
    private static DemoblazeHomePage isInstanceClosed = null;
    public static DemoblazeHomePage getInstance() {
        if (instance == null || instance.isClosed()) {
            instance = new DemoblazeHomePage();
        }
        return instance;
    }

    private DemoblazeHomePage() {
        driver.get("https://www.demoblaze.com");
    }

    public MenuPanel menuPanel() {
        return new MenuPanel(driver);
    }

    public SignupPanel signupForm() {
        return new SignupPanel(driver);
    }

    public LoginPanel loginForm() {
        return new LoginPanel(driver);
    }

}
