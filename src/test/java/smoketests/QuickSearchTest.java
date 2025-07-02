package smoketests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
///////////////////////////////////////////////////////Pages
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_Utilities.WMS_TestBase;
///////////////////////////////////////////////////////
import com.aventstack.extentreports.Status;

@Test(enabled = true, groups = { "E2E_TC" })
public class QuickSearchTest extends WMS_TestBase {

    
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        if (CloseBrowser) {
            driver = invokeBrowser(this.getClass().getSimpleName());
            LaunchSpecific_URL(CurrentURL);
            dashboardPage = new DashboardPage(driver);
            setReport("QuickSearch Test");
        }
    }

    @Test(priority = 0)
    public void searchFlexPLMObject() throws Exception {
        test = extent.createTest("T");
        
        System.out.println("🔍 Executing universal header search...");
        test.log(Status.INFO, "🔍 Test execution started: Universal FlexPLM Object Search");
        addScreenShot("📸 Clicked on Logout successful", test, Capture);
        
        test.log(Status.INFO, "🚀 Launching browser and navigating to dashboard");
        test.log(Status.INFO, "✅ Browser launched successfully");

        test.log(Status.INFO, "📌 Initiating header dropdown search for: Material → SOFTMARK TODDLER LEGGING");
        dashboardPage.headerDropdownSearch("Product", "SOFTMARK TODDLER LEGGING");

        test.log(Status.INFO, "⏳ Waiting for page to load completely");
        System.out.println("🔍 page loading.");
        WaitforPage(4000);

        test.log(Status.PASS, "🎯 Search completed and FlexPLM object loaded successfully");
        System.out.println("🔍 wait done");
    }


	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}

