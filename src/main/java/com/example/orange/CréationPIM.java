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

public class CréationPIM {
    public void effectuerCréationPIM() {
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
/// Étape 2: Accéder à l'écran PIM
            WebElement pimMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(2) > a")));
            pimMenu.click();

// Attente explicite pour s'assurer que l'élément est présent sur la page PIM
            WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > header > div.oxd-topbar-header > div.oxd-topbar-header-title > span > h6")));

            if (pageTitle.getText().equalsIgnoreCase("PIM")) {
                System.out.println("Vous êtes sur la page PIM.");
            } else {
                System.out.println("Échec : Vous n'êtes pas sur la page PIM.");
            }
            Thread.sleep(2000);

            // Étape 3: Créer un employé
            // Cliquer sur le bouton pour ajouter un nouvel employé
            WebElement addEmployeeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-header-container > button")));
            addEmployeeButton.click();
            Thread.sleep(1000);
            // Attente explicite pour s'assurer que le formulaire est visible
            WebElement employeeForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container")));

            // Remplir les champs du formulaire
            WebElement firstNameField = employeeForm.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div:nth-child(1) > div.oxd-grid-1.orangehrm-full-width-grid > div > div > div.--name-grouped-field > div:nth-child(1) > div:nth-child(2) > input"));
            firstNameField.sendKeys("John");
            Thread.sleep(1000);
            WebElement middleNameField = employeeForm.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div:nth-child(1) > div.oxd-grid-1.orangehrm-full-width-grid > div > div > div.--name-grouped-field > div:nth-child(2) > div:nth-child(2) > input"));
            middleNameField.sendKeys("Doe");
            Thread.sleep(1000);
            WebElement lastNameField = employeeForm.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div:nth-child(1) > div.oxd-grid-1.orangehrm-full-width-grid > div > div > div.--name-grouped-field > div:nth-child(3) > div:nth-child(2) > input"));
            lastNameField.sendKeys("Smith");
            Thread.sleep(1000);
            WebElement employeeIdField = employeeForm.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div:nth-child(1) > div.oxd-grid-2.orangehrm-full-width-grid > div > div > div:nth-child(2) > input"));
            employeeIdField.sendKeys("12345");
            Thread.sleep(1000);
            WebElement createLoginDetailsCheckbox = employeeForm.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div.oxd-form-row.user-form-header > div > label > span"));
            createLoginDetailsCheckbox.click();
            Thread.sleep(1000);
            WebElement usernameField = employeeForm.findElement(By.cssSelector
                    ("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div:nth-child(4) > div > div:nth-child(1) > div > div:nth-child(2) > input"));
            usernameField.sendKeys("john_de");
            Thread.sleep(1000);
            WebElement statusActiveRadioButton = employeeForm.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div:nth-child(4) > div > div:nth-child(2) > div > div.--status-grouped-field > div:nth-child(1) > div:nth-child(2) > div > label > span"));
            statusActiveRadioButton.click();
            Thread.sleep(1000);
            WebElement passwordField = employeeForm.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div.oxd-form-row.user-password-row > div > div.oxd-grid-item.oxd-grid-item--gutters.user-password-cell > div > div:nth-child(2) > input"));
            passwordField.sendKeys("Password123");
            Thread.sleep(1000);
            WebElement confirmPasswordField = employeeForm.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div.oxd-form-row.user-password-row > div > div:nth-child(2) > div > div:nth-child(2) > input"));
            confirmPasswordField.sendKeys("Password123");
            Thread.sleep(1000);
            // Wait for the create button to be clickable
            WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")));
            createButton.click();
            // Attendre quelques secondes pour observer les résultats
            Thread.sleep(1000);
// Wait for an element that is unique to the page after successful creation
            WebElement nextPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-navigation > div.orangehrm-tabs > div:nth-child(1) > a")));

// Validate the presence of the element to confirm successful creation
            if (nextPageElement.isDisplayed()) {
                System.out.println("Employee creation successful.");
            } else {
                System.out.println("Employee creation failed.");
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Fermer le navigateur
            driver.quit();
        }
    }

}
