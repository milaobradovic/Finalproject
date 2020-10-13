package tests;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import org.testng.annotations.Test;

import pages.SearchResultPage;
import pages.LocationPopupPage;

public class SearchTest extends BasicTest {

	@Test(priority = 0)
	public void SearchTest() throws InterruptedException, IOException {

		LocationPopupPage lpp = new LocationPopupPage(this.driver, this.wait, this.js);
		SearchResultPage srp = new SearchResultPage(this.driver, this.wait, this.js);

		driver.navigate().to(baseUrl + "meals");

		lpp.Setlocation("City Center - Albany");
		Thread.sleep(2000);

		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meal Search Results");

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell location = row.getCell(0);
			XSSFCell mealUrl = row.getCell(1);
			XSSFCell numberofresults = row.getCell(2);

			this.driver.navigate().to(mealUrl.getStringCellValue());
			Thread.sleep(1000);
			lpp.Selectlocation();
			Thread.sleep(2000);
			lpp.Setlocation(location.getStringCellValue());
			Thread.sleep(2000);

			Assert.assertTrue(numberofresults.getNumericCellValue() == srp.numberofSearchResults(),
					"[ERROR] Number of Search Result is Different!");

			for (int j = 1; j < 2 + numberofresults.getNumericCellValue(); j++) {
				if (row.getCell(j) != null) {
					Assert.assertTrue(row.getCell(j).getStringCellValue().contains(srp.nameofMeals().get(j - 3)),
							"[ERROR] Number of Search Result is Different!");
				}

				int resultsnumber = (int) (numberofresults.getNumericCellValue());
				Assert.assertEquals(resultsnumber, srp.numberofSearchResults());

			}
		}
	}
}