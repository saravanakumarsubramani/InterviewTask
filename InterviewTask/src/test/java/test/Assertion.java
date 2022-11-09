package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonutilities.Commonutility;
import pageobjects.ImdbObjects;
import pageobjects.Wikipediaobjects;

public class Assertion extends Commonutility {
	String realseDateImdb;
	String countryImdb;
	String releasedatewiki;
	String countryWiki;
	public void imdbPage() {

		String imdbUrl =	Properties.getProperty("Imdburl");
		driver.get(imdbUrl);

		PageFactory.initElements(driver, ImdbObjects.class);

		ImdbObjects.search.sendKeys(Properties.getProperty("ImdbMovie")+Keys.ENTER);
		ImdbObjects.movieClick.click();
		realseDateImdb =	ImdbObjects.realseDateImdb.getText();
		countryImdb = ImdbObjects.countryImdb.getText();

	}

	public void wikiPage()
	{
		String wikipediaurl = Properties.getProperty("wikipediaurl");
		driver.get(wikipediaurl);
		PageFactory.initElements(driver, Wikipediaobjects.class);
		Wikipediaobjects.wikiSearch.sendKeys(Properties.getProperty("wikipediMovie"));
		Wikipediaobjects.sugg.click();
		releasedatewiki = Wikipediaobjects.releasedatewiki.getText();
		countryWiki = Wikipediaobjects.countryWiki.getText();

	}
	
	@Test
	public void verifyText() {
		imdbPage();
		wikiPage();
		Assert.assertNotEquals(realseDateImdb, releasedatewiki);
		Assert.assertEquals(countryImdb, countryWiki);

	}
}

