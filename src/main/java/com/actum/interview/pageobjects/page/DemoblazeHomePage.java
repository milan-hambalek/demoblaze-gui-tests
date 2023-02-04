package com.actum.interview.pageobjects.page;

import com.actum.interview.pageobjects.panel.LoginFormPanel;
import com.actum.interview.pageobjects.panel.MenuPanel;
import com.actum.interview.pageobjects.panel.SignupFormPanel;

public class DemoblazeHomePage extends AbstractPage {

    private static DemoblazeHomePage instance = null;
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

    public SignupFormPanel signupForm() {
        return new SignupFormPanel(driver);
    }

    public LoginFormPanel loginForm() {
        return new LoginFormPanel(driver);
    }

}
