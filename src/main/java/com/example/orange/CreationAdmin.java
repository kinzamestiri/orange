package com.example.orange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.System;
import java.time.Duration;

public class CreationAdmin {
    public void effectuerCreationAdmin() {
        // Configuration du chemin du pilote Chrome (assurez-vous de télécharger le pilote approprié)
        System.setProperty("webdriver.chrome.driver", "C:/Users/KINZA/Downloads/chromedriver-win32/chromedriver-win32/chromedriver.exe");

        // Configuration des options du navigateur (par exemple, pour désactiver les notifications)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        // Initialisation du pilote WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Étape 1: Connexion à l'application
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Sélecteur pour le champ de nom d'utilisateur
            WebElement usernameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > div:nth-child(2) > input")));
            usernameElement.sendKeys("Admin");

            // Attente de 5 secondes après la saisie du nom d'utilisateur
            Thread.sleep(2000);

            // Sélecteur pour le champ de mot de passe
            WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > div:nth-child(2) > input")));
            passwordElement.sendKeys("admin123");

            // Attente de 5 secondes après la saisie du mot de passe
            Thread.sleep(2000);

            // Sélecteur pour le bouton de connexion
            WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")));
            loginButton.click();

            // Attente de 5 secondes après la connexion
            Thread.sleep(2000);

            // Étape 2: Accéder à l'écran Admin
            WebDriverWait att = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement adminMenu = att.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(1) > a")));
            adminMenu.click();

            // Attente explicite pour s'assurer que l'élément est présent sur la page Admin
            WebElement adminPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > header > div.oxd-topbar-header > div.oxd-topbar-header-title > span > h6")));

            if (adminPageTitle.getText().equalsIgnoreCase("Admin")) {
                System.out.println("Vous êtes sur la page Admin.");
            } else {
                System.out.println("Échec : Vous n'êtes pas sur la page Admin.");
            }
            // Étape 3: Créer un utilisateur admin
// Cliquez sur le bouton "Add" pour ajouter un nouvel utilisateur
            WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div > div > div > div.oxd-table-header > button")));

            addButton.click();

// Remplissez le formulaire pour créer un nouvel utilisateur admin
            WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(1) > div > div:nth-child(2) > div > div > input")));
            firstNameInput.sendKeys("Admin");

            WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(2) > div > div > input")));
            lastNameInput.sendKeys("User");

            WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(3) > div > div:nth-child(2) > div > div > input")));
            usernameInput.sendKeys("ah.autom");  // Change this to the desired username

            WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(4) > div > div:nth-child(2) > input")));
            passwordInput.sendKeys("admin123");  // Change this to the desired password

// Cliquez sur le bouton "Save"
            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")));
            saveButton.click();

// Attente pour s'assurer que l'élément de succès est présent (ajustez le sélecteur en conséquence)

            WebElement nextPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > header > div.oxd-topbar-header > div.oxd-topbar-header-title > span > h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module")));

            if (nextPageElement.isDisplayed()) {
                System.out.println("Admin creation successful.");
            } else {
                System.out.println("Admin creation failed.");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Fermer le navigateur
            driver.quit();
        }
    }
    }