package com.generic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {

	WebDriver driver;

	@Given("Open browser and go to the application")
	public void open_browser_and_go_to_the_application() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"file:///E:/Smartech%20video%20course/Sarowar%20vai%20after%20may/Long%20video%20for%20framework%20and%20API%20June18/dev_online%20Banking%20monthly_yearly%20statement.html");
	}

	@When("Put valid username")
	public void put_valid_username() {

		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("Batch34");

	}

	@When("Put valid password")
	public void put_valid_password() {

		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("student123@");
	}

	@When("Clicl login")
	public void clicl_login() {

		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}

	@Then("check if logout button visible or not")
	public void check_if_logout_button_visible_or_not() {

		SoftAssert sf = new SoftAssert();

		sf.assertTrue(driver.findElement(By.xpath("//*[@id='logoutButton']")).isDisplayed());

		sf.assertAll();
	}

	@When("Put invalid username")
	public void put_invalid_username() {

		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("dfdg");

	}

	@When("Put invalid password")
	public void put_invalid_password() {

		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("gege");
	}

	@Then("check if it is giving Alert msg Invalid username or password")
	public void check_if_it_is_giving_alert_msg_invalid_username_or_password() {

		Alert alert = driver.switchTo().alert();

		String alertmsg = alert.getText();

		SoftAssert sf = new SoftAssert();
		sf.assertEquals(alertmsg, "Invalid username or password");

	}

	@When("Put null username")
	public void put_null_username() {
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("");
	}

	@When("Put null password")
	public void put_null_password() {
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("");
	}

}
