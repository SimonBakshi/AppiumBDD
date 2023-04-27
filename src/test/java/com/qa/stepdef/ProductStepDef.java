package com.qa.stepdef;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductDetailsPage;
import com.qa.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductStepDef {

    @Given("I am logged in")
    public void iAmLoggedIn() {
        new LoginPage().login("standard_user", "secret_sauce");
    }

    @Then("The product is listed with title {string} and price {string}")
    public void theProductIsListedWithTitleAndPrice(String title, String price) throws Exception {
//        boolean checkTitle = new ProductsPage().getProductTitle(title).equalsIgnoreCase(title);
//        Assert.assertTrue("TitleCheck =" + checkTitle, checkTitle);
    }

    @When("I click product title {string}")
    public void iClickProductTitle(String title) throws Exception {
        new ProductsPage().pressProductTitle(title);
    }

    @Then("I should be on product details page with title {string}, price {string} and description {string}")
    public void iShouldBeOnProductDetailsPageWithTitlePriceAndDescription(String title, String price, String description) {
//        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
//        boolean checkTitle = productDetailsPage.getTitle().equalsIgnoreCase(title);
//        boolean checkDesc = productDetailsPage.getDesc().equalsIgnoreCase(description);
//        Assert.assertTrue("titleChk =" + checkTitle
//                + ", descCheck =" + checkDesc, checkTitle & checkDesc);
    }

}
