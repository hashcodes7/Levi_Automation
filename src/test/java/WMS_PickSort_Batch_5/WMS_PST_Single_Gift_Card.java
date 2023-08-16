package WMS_PickSort_Batch_5;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.WMS_ASNPage;
import com.WMS_ApplicationPages.WMS_BatchListPage;
import com.WMS_ApplicationPages.WMS_DashboardPage;
import com.WMS_ApplicationPages.WMS_DisasterRecoveryPage;
import com.WMS_ApplicationPages.WMS_ItemPage;
import com.WMS_ApplicationPages.WMS_LPNPage;
import com.WMS_ApplicationPages.WMS_LocationInventoryPage;
import com.WMS_ApplicationPages.WMS_LoginPage;
import com.WMS_ApplicationPages.WMS_OrdersPage;
import com.WMS_ApplicationPages.WMS_PackStationPage;
import com.WMS_ApplicationPages.WMS_SystemManagementPage;
import com.WMS_ApplicationPages.WMS_TasksPage;
import com.WMS_ApplicationPages.WMS_WVMobilePage;
import com.WMS_ApplicationPages.WMS_WaveRunsPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import resources.DataProviders;

@Test(enabled = true, groups = { "PickShort_Order" })
public class WMS_PST_Single_Gift_Card extends WMS_TestBase {

	WebDriver driver;
	WMS_LoginPage loginPage;
	WMS_DashboardPage dashboardPage;
	WMS_ASNPage asnPage;
	WMS_LPNPage lsnPage;
	WMS_ItemPage itemPage;
	WMS_OrdersPage orderspage;
	WMS_WVMobilePage wvMobilePage;
	WMS_DisasterRecoveryPage discoverRecovery;
	WMS_WebDriverUtilities utilities;
	WMS_WaveRunsPage waverunspage;
	WMS_TestBase testbasepage;
	WMS_BatchListPage batchlistpage;
	WMS_TasksPage taskspage;
	WMS_PackStationPage packStationPage;
	WMS_LocationInventoryPage locationinventorypage;
	WMS_SystemManagementPage systemmanagementpage;
	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	int CartSlot = 6;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			launchUrl();
			loginPage = new WMS_LoginPage(driver);
			dashboardPage = new WMS_DashboardPage(driver);
			asnPage = new WMS_ASNPage(driver);
			lsnPage = new WMS_LPNPage(driver);
			itemPage = new WMS_ItemPage(driver);
			wvMobilePage = new WMS_WVMobilePage(driver);
			discoverRecovery = new WMS_DisasterRecoveryPage(driver);
			utilities = new WMS_WebDriverUtilities(driver);
			waverunspage = new WMS_WaveRunsPage(driver);
			orderspage = new WMS_OrdersPage(driver);
			waverunspage = new WMS_WaveRunsPage(driver);
			batchlistpage = new WMS_BatchListPage(driver);
			taskspage = new WMS_TasksPage(driver);
			packStationPage = new WMS_PackStationPage(driver);
			locationinventorypage = new WMS_LocationInventoryPage(driver);
			systemmanagementpage = new WMS_SystemManagementPage(driver);
			setReport("B5_TC03_PickShort_Singles_Gift_Card");
		}
	}

	@Test(priority = 0, dataProvider = "PickShort_Singles_Gift_Card", dataProviderClass = DataProviders.class)

	public void orderAllocation(String OrderNumber, String OrderNumber2, String CompleteSpecs, String CompleteSpecs2,
			String CompleteSpecs3, String CompleteSpecs4, String CompleteSpecs5, String CompleteSpecs6,
			String CompleteSpecs7, String TotUserKey, String LocationKey, String CARTKEY, String CompleteSpecs8,
			String CompleteSpecs9, String PackStation) throws InterruptedException, AWTException {

		if (!OrderNumber.equals(" ")) {
			if (CloseBrowser) {
				test = extent.createTest(":::B5_TC03_PickShort_Singles_Gift_Card:::");
			}

			CloseBrowser = false;

			// ...............................browser launched time starts
			
				long startTime = System.nanoTime();

				String GetTime = utilities.Timer();
				System.out.println("Browser Launched Time :" + GetTime);
				test.log(Status.PASS, "Browser Launched Time :" + GetTime);

				// ......................................................................................//

				System.out.println("Browser Launched successfully");
				test.log(Status.PASS, "Browser Launched successfully");

				loginPage.verifyLogoExists();
				test.log(Status.PASS, "Manhattan Active Supply Chain logo is displayed");

				loginPage.enterUserName(USERNAME);
				test.log(Status.PASS, "Entered Username");
				addSrceenShot("Login", test, Capture);

				loginPage.clickSubmitUserName();
				test.log(Status.PASS, "Clicked on Submit Button");

				loginPage.enterPassword(PASSWORD);
				test.log(Status.PASS, "Entered Password");
				addSrceenShot("Login", test, Capture);

				loginPage.clickLogin();
				test.log(Status.PASS, "Clicked on Login Button");
				
				loginPage.resizeWebpage();
				test.log(Status.PASS, "Window resize");

				// orders page check orders status and details

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("orders");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				dashboardPage.ordersclick();
				test.log(Status.PASS, "Clicked on Order Button");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
				test.log(Status.PASS, "Entered Order Search");
				addSrceenShot("Login", test, Capture);

				verifyCompleteSpecifics(test, readWebTable(orderspage.OrderTableHeader, orderspage.orderTableBody),
						CompleteSpecs, OrderNumber);
				test.log(Status.PASS, "DO verification completed");

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");
				addSrceenShot("Login", test, Capture);

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				// wave run start at.........................................

				orderspage.selectAllRecord();
				test.log(Status.PASS, "clicked on one record button");
				addSrceenShot("Login", test, Capture);

				try {

					orderspage.clickToolRunwaveBtn();
					test.log(Status.PASS, "clicked on run wave button");

				} catch (Exception e) {

					orderspage.btnThreedots();
					test.log(Status.PASS, "clicked on one threeDots button");

					orderspage.clickRunwaveInsideDots();
					test.log(Status.PASS, "clicked runwave at inside Dots");
					addSrceenShot("Login", test, Capture);

				}

				orderspage.enterWaveStatergy(" OPS - Standard Wave ");
				test.log(Status.PASS, "Selected The standard Wave");
				addSrceenShot("Login", test, Capture);

				orderspage.confirmSummit();
				test.log(Status.PASS, "clicked on one summit button");

				// ................................total timer start...................//

				long startTime1 = System.nanoTime();

				String GetTime2 = utilities.Timer();
				System.out.println("wave run start time is :" + GetTime2);
				test.log(Status.PASS, "wave run start time is :" + GetTime2);

				// ..................................................................//

				orderspage.olpnreleaseStatusTwoOrders(dashboardPage, OrderNumber, OrderNumber2);
				test.log(Status.PASS, "waiting for new status update");

				test.log(Status.PASS, "waiting for new status update");
				System.out.println("New status changed successfully");
				addSrceenShot("Login", test, Capture);

				// .................................total time. end with
				// timer.......................//

				long endTime1 = System.nanoTime();

				String GetTime21 = utilities.Timer();
				System.out.println("Wave run started at Time is   :" + GetTime21);
				test.log(Status.PASS, "Wave run started at Time is   :" + GetTime21);

				String totalTime11 = WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime1, endTime1);
				/* String s11=Long.toString(totalTime11); */
				System.out.println("The execution minutes is :" + totalTime11);
				test.log(Status.PASS, "The Wave run Execution consumed time in Minutes  : " + totalTime11);

				// .................................total time........................//

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");
				addSrceenShot("Login", test, Capture);

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				verifyCompleteSpecifics(test, readWebTable(orderspage.OrdAllocaTabHeader, orderspage.OrdAllocaTabBody),
						CompleteSpecs2, OrderNumber);
				test.log(Status.PASS, "DO verification completed");

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				addSrceenShot("Login", test, Capture);

				String itemfromOrder1 = orderspage.getItemNoBYOrdersNo(OrderNumber);

				String itemfromOrder2 = orderspage.getItemNoBYOrdersNo(OrderNumber2);

				// olpns page ......................................

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("olpns");
				test.log(Status.PASS, "Entered MenuSearch as OLPNS Page");

				dashboardPage.olpnclick();
				test.log(Status.PASS, "Clicked on OLPNS page Button");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				orderspage.searchOlpntextbox(OrderNumber + ", " + OrderNumber2, dashboardPage);
				test.log(Status.PASS, "status changed successfully");
				addSrceenShot("Login", test, Capture);

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				String olpnfromOrder1 = orderspage.getOlpnsNumberFirst(OrderNumber);

				String olpnfromOrder2 = orderspage.getOlpnsNumberFirst(OrderNumber2);

				addSrceenShot("Login", test, Capture);

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				verifyCompleteSpecifics(test, readWebTable(orderspage.OrdAllocaTabHeader, orderspage.OrdAllocaTabBody),
						CompleteSpecs3, OrderNumber);
				test.log(Status.PASS, "DO verification completed");

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");
				addSrceenShot("Login", test, Capture);

				waverunspage.clickExpandBar();
				test.log(Status.PASS, "Clicked on ExpandBar");
				addSrceenShot("Login", test, Capture);

				String wvrnid = waverunspage.waverunid();
				test.log(Status.PASS, "saved wave run ID");

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				// wave run to wra convertion process.............................//

				lsnPage.clickLpnMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("wave run");
				test.log(Status.PASS, "Entered MenuSearch as wave run");

				waverunspage.clickWaverunbtn();
				test.log(Status.PASS, "Clicked on waverun page  Button");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				dashboardPage.wavesearch(wvrnid, dashboardPage);// WaveId
				test.log(Status.PASS, "wave run ID search completed");
				addSrceenShot("Login", test, Capture);

				waverunspage.waveRunPageStatus(dashboardPage);

				// work release allocation status check process........

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("work release allocation");
				test.log(Status.PASS, "Entered MenuSearch as OLPNS Page");

				waverunspage.clickWRAmenuBtn();

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				waverunspage.enterOrderPlanIDSearch(wvrnid, dashboardPage);

				// ...............................wave run time starts
				// at.........................//

				long startTime2 = System.nanoTime();

				String GetTime3 = utilities.Timer();
				System.out.println("work release allocation process  start time is :" + GetTime3);
				test.log(Status.PASS, "work release allocation process  start time is :");
				test.log(Status.PASS, GetTime3);

				// ......................................................................................//

				waverunspage.workReleasePage(dashboardPage);
				test.log(Status.PASS, "waiting for new status update");

				test.log(Status.PASS, "waiting for new status update");
				System.out.println("New status changed successfully");
				addSrceenShot("Login", test, Capture);

				// .................................total time. end with
				// timer.......................//

				long endTime2 = System.nanoTime();

				String GetTime4 = utilities.Timer();
				System.out.println("Work Release Allocated at Time is   :" + GetTime4);
				test.log(Status.PASS, "Work Release Allocated at Time is   :" + GetTime4);

				String totalTime21 = WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime2, endTime2);
				/* String s11=Long.toString(totalTime11); */
				System.out.println("The execution minutes is :" + totalTime11);
				test.log(Status.PASS, "The Wave run Execution consumed time in Minutes  : " + totalTime21);

				// .................................total time........................//

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				verifyCompleteSpecifics(test, readWebTable(waverunspage.waveTableHeader, waverunspage.waveTableBody),
						CompleteSpecs4, wvrnid);
				test.log(Status.PASS, "DO verification completed");

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");
				addSrceenShot("Login", test, Capture);

				batchlistpage.clickExpandBarbatch();
				test.log(Status.PASS, "Clicked on ExpandBar");

				String batchlistid = batchlistpage.getBatchNumber();
				test.log(Status.PASS, "Batch id saved");
				addSrceenShot("Login", test, Capture);

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("batch list");
				test.log(Status.PASS, "Entered MenuSearch as Batch List");

				batchlistpage.clickbatchbutton();
				test.log(Status.PASS, "Clicked on Batch List Button");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				batchlistpage.batchsearch(batchlistid, dashboardPage); // B20220118001999 //batchlistid
				test.log(Status.PASS, "Entered Batch List current ID");
				addSrceenShot("Login", test, Capture);

				batchlistpage.selectonebatcRC();
				test.log(Status.PASS, "Clicked on one record");

				batchlistpage.clickReleaseBtn();
				test.log(Status.PASS, "Clicked on release button");
				addSrceenShot("Login", test, Capture);

				batchlistpage.clickYesBtn();
				test.log(Status.PASS, "Clicked on Yes button");
				addSrceenShot("Login", test, Capture);

				// ...............................batch list time starts
				// at.........................//

				long startTime3 = System.nanoTime();

				String GetTime5 = utilities.Timer();
				System.out.println("work release allocation process  start time is :" + GetTime5);
				test.log(Status.PASS, "work release allocation process  start time is :");
				test.log(Status.PASS, GetTime5);

				// ......................................................................................//

				batchlistpage.batchReleaseStatus(dashboardPage);
				test.log(Status.PASS, "waiting for new status update");

				test.log(Status.PASS, "waiting for new status update");
				System.out.println("New status changed successfully");
				addSrceenShot("Login", test, Capture);

				// .................................total time. end with
				// timer.......................//

				long endTime3 = System.nanoTime();

				String GetTime6 = utilities.Timer();
				System.out.println("Order get ship conformed Time is   :" + GetTime6);
				test.log(Status.PASS, "Order get ship conformed Time is   :" + GetTime6);

				String totalTime31 = WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime3, endTime3);
				/* String s31=Long.toString(totalTime31); */
				System.out.println("The execution minutes is :" + totalTime31);
				test.log(Status.PASS, "The batch list released Execution consumed time in Minutes  : " + totalTime31);

				// .................................total time........................//

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				dashboardPage.clickRefresh();

				verifyCompleteSpecifics(test,
						readWebTable(batchlistpage.batchTableHeader, batchlistpage.batchTableBody), CompleteSpecs5,
						batchlistid);
				addSrceenShot("Login", test, Capture);

				// assign task............................................//

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("tasks");
				test.log(Status.PASS, "Entered MenuSearch as tasks");

				taskspage.clicktaskbutton();
				test.log(Status.PASS, "Clicked  MenuSearch page tasks");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				taskspage.enterTaskorderSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
				test.log(Status.PASS, "Entered wave run ID");
				addSrceenShot("Login", test, Capture);

				taskspage.readyForAssignStatus(dashboardPage);

				String taskiddetails = taskspage.gettaskNumber();
				test.log(Status.PASS, "Process Task ID saved");

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				verifyCompleteSpecifics(test, readWebTable(taskspage.tasksTableHeader, taskspage.tasksTableBody),
						CompleteSpecs6, taskiddetails);
				test.log(Status.PASS, "Batch List Table Content Saved");

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				taskspage.selectonetaskRC();
				test.log(Status.PASS, "selected single order tab");
				addSrceenShot("Login", test, Capture);

				taskspage.clickAssignBtn();
				test.log(Status.PASS, "Clicked on assign Button");

				taskspage.enterCurrentUser(USERNAME);
				test.log(Status.PASS, "Entered Username");

				taskspage.selectonetaskRC();
				test.log(Status.PASS, "selected single order tab");
				addSrceenShot("Login", test, Capture);

				taskspage.btntaskThreedots();
				test.log(Status.PASS, "clicked on one threeDots button");

				taskspage.clickDetailsBtn();
				test.log(Status.PASS, "clicked on details button");
				addSrceenShot("Login", test, Capture);

				taskspage.clickAssignableTaskGroup();
				test.log(Status.PASS, "clicked on assigned expand bar");

				String taskgroup = taskspage.getTaskGroupNumber();
				test.log(Status.PASS, "taskgroup ID saved");
				addSrceenShot("Login", test, Capture);

				taskspage.clickCloseIcon();
				test.log(Status.PASS, "closed button clicked successfully");
				addSrceenShot("Login", test, Capture);

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				verifyCompleteSpecifics(test, readWebTable(taskspage.tasksTableHeader, taskspage.tasksTableBody),
						CompleteSpecs7, taskiddetails);
				test.log(Status.PASS, "Task page all order Table Content Saved");
				addSrceenShot("Login", test, Capture);

				// item page retrive item bar details

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("items");
				test.log(Status.PASS, "Entered MenuSearch as item");

				itemPage.clickitembutton();
				test.log(Status.PASS, "clicked on item button");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				itemPage.itemsearch(itemfromOrder1 + ", " + itemfromOrder2); // ItemNumber
				test.log(Status.PASS, "Entered item IDs on Item Serach box");
				addSrceenShot("Login", test, Capture);

				dashboardPage.clickRefresh();

				itemPage.getItemBarcodeNoBYOrdersNo(itemfromOrder1);
				test.log(Status.PASS, "first item barcode is saved");

				itemPage.getItemBarcodeNoBYOrdersNo(itemfromOrder2);
				test.log(Status.PASS, "first item barcode is saved");

				String itembarcode1 = itemPage.getItemBarcodeNoBYOrdersNo(itemfromOrder1);
				test.log(Status.PASS, "first item barcode is saved");

				String itembarcode2 = itemPage.getItemBarcodeNoBYOrdersNo(itemfromOrder2);
				test.log(Status.PASS, "first item barcode is saved");

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("wm mobile");
				test.log(Status.PASS, "Entered MenuSearch as WM Menu");

				wvMobilePage.clickWmbtn();
				test.log(Status.PASS, "Clicked on WM Mobile button");
				addSrceenShot("Login", test, Capture);

				utilities.switchToWindows();
				test.log(Status.PASS, "Window switched successfully");

				wvMobilePage.clickSettingsButton();
				test.log(Status.PASS, "Clicked on WM Settings button");

				wvMobilePage.clickTaskGroupRow();
				test.log(Status.PASS, "Clicked on Regerding Task Group");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clicktaskgroupDropDownButton();
				test.log(Status.PASS, "Clicked on Task Group Dropdown");

				wvMobilePage.selectTaskGroup(taskgroup);
				test.log(Status.PASS, "Clicked on Task Group");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.clickDoneBtn();
				test.log(Status.PASS, "Clicked on Done Button");

				wvMobilePage.clicktasksBtn();
				test.log(Status.PASS, "Clicked on Task Button");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickEnterTaskBtn();
				test.log(Status.PASS, "Entered Task button text box column");

				wvMobilePage.enterTaskId(taskiddetails); // Task: WRPICK0000009090
				test.log(Status.PASS, "Entered Task ID in text box");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.clickTapToConfrimBtn();
				test.log(Status.PASS, "Clicked on Tab to Conform  Button");

				// Enter cart No :

				wvMobilePage.enterVerifyCartidElement(CARTKEY);
				test.log(Status.PASS, "Entered CART KEY in text box");

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.clickConfirmBtn();
				test.log(Status.PASS, "Clicked on Conform Button");

				try {
					wvMobilePage.clickConfirmBtn();
					test.log(Status.PASS, "Clicked on Conform Button");

				} catch (Exception e) {
				}
				// Enter Location

				String LocBar = wvMobilePage.getLocBarcode();
				wvMobilePage.enterLocationID();
				addSrceenShot("Login", test, Capture);
				wvMobilePage.clickGoBtn();

				// PICK EXCEPTION

				wvMobilePage.clickPickExcep();

				wvMobilePage.clickConfirmBtn();

				utilities.closeCurrentWindow();

				// cycle count /////////////////////////////////////////

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("location inventory");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				addSrceenShot("Login", test, Capture);

				locationinventorypage.clickInventoryBtn();

				addSrceenShot("Login", test, Capture);

				locationinventorypage.inventoryBarsearch(LocBar);
				test.log(Status.PASS, "Entered Order Search");

				locationinventorypage.locInventoryExpBtn();

				addSrceenShot("Login", test, Capture);

				int TotalUnitCount = locationinventorypage.getTotalUnitCount();

				System.out.println(TotalUnitCount);

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("wm mobile");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickWmbtn();
				test.log(Status.PASS, "Clicked on waverun Button");

				addSrceenShot("Login", test, Capture);

				utilities.switchToWindows();

				wvMobilePage.clickSettingsButton();
				test.log(Status.PASS, "Clicked on Settings button");

				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickTaskGroupRow();
				test.log(Status.PASS, "Clicked on Task Group");

				addSrceenShot("Login", test, Capture);

				wvMobilePage.clicktaskgroupDropDownButton();
				test.log(Status.PASS, "Clicked on Task Group Dropdown");

				addSrceenShot("Login", test, Capture);

				wvMobilePage.selectTaskGroup("CCM");

				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickGoBtn();

				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickDoneBtn();

				wvMobilePage.clickCycleCountBtn();

				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickLiveCycleCountBtn();

				addSrceenShot("Login", test, Capture);

				wvMobilePage.enterLocationBar(LocBar);

				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickGoBtn();

				wvMobilePage.clickConfirmBtn();

				// itembarcode

				wvMobilePage.entercycleItemBar(itembarcode1); // 003480001 M itembarcode

				wvMobilePage.clickGoBtn();

				wvMobilePage.enterCycleCountUnits(Integer.toString(TotalUnitCount + 1)); // TotalUnitCount

				wvMobilePage.clickGoBtn();

				wvMobilePage.clickConfirmBtn();

				utilities.closeCurrentWindow();

				// orders page check orders status and details

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("orders");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				dashboardPage.ordersclick();
				test.log(Status.PASS, "Clicked on Order Button");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
				test.log(Status.PASS, "Entered Order Search");
				addSrceenShot("Login", test, Capture);

				// loc inv

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("location inventory");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				locationinventorypage.clickInventoryBtn();
				test.log(Status.PASS, "Clicked on Inventory button");

				locationinventorypage.inventoryBarsearch(LocBar);
				test.log(Status.PASS, "Entered Order Search");

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Clicked on Referesh button");

				locationinventorypage.locInventoryExpBtn();
				test.log(Status.PASS, "Clicked on Record Exp button");

				int TotalUnitCount2 = locationinventorypage.getTotalUnitCount();

				System.out.println(TotalUnitCount2);

				// chase wave to allocate order

				// orders page check orders status and details

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("orders");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				dashboardPage.ordersclick();
				test.log(Status.PASS, "Clicked on Order Button");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
				test.log(Status.PASS, "Entered Order Search");
				addSrceenShot("Login", test, Capture);

				orderspage.selectAllRecord();
				test.log(Status.PASS, "clicked on one record button");
				addSrceenShot("Login", test, Capture);

				orderspage.clickRelatedLinks();
				test.log(Status.PASS, "clicked on order related links");

				orderspage.clickOrderShordage();
				test.log(Status.PASS, "clicked on order shordage");

				orderspage.selectAllRecord();
				test.log(Status.PASS, "clicked on one record button");
				addSrceenShot("Login", test, Capture);

				orderspage.selectChaseWaveBtn();
				test.log(Status.PASS, "clicked on chase wave btn");

				orderspage.enterChaseWave();
				test.log(Status.PASS, "selected OPS chase wave");

				orderspage.confirmSummit();
				test.log(Status.PASS, "clicked on one summit button");

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				orderspage.clickExpandBarolpns();

				String wvrnid3 = orderspage.oRSortwaverunid();
				test.log(Status.PASS, "saved wave run ID");

				// wave run to wra convertion process.............................//

				lsnPage.clickLpnMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("wave run");
				test.log(Status.PASS, "Entered MenuSearch as wave run");

				waverunspage.clickWaverunbtn();
				test.log(Status.PASS, "Clicked on waverun page  Button");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				dashboardPage.wavesearch(wvrnid3, dashboardPage);// WaveId
				test.log(Status.PASS, "wave run ID search completed");
				addSrceenShot("Login", test, Capture);

				waverunspage.waveRunPageStatus(dashboardPage);

				// work release allocation status check process........

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("work release allocation");
				test.log(Status.PASS, "Entered MenuSearch as OLPNS Page");

				waverunspage.clickWRAmenuBtn();

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				waverunspage.enterOrderPlanIDSearch(wvrnid3, dashboardPage);

				// ...............................wave run time starts
				// at.........................//

				long AstartTime2 = System.nanoTime();

				String AGetTime3 = utilities.Timer();
				System.out.println("work release allocation process  start time is :" + AGetTime3);
				test.log(Status.PASS, "work release allocation process  start time is :");
				test.log(Status.PASS, AGetTime3);

				// ......................................................................................//

				waverunspage.workReleasePage(dashboardPage);
				test.log(Status.PASS, "waiting for new status update");

				test.log(Status.PASS, "waiting for new status update");
				System.out.println("New status changed successfully");
				addSrceenShot("Login", test, Capture);

				// .................................total time. end with
				// timer.......................//

				long AendTime2 = System.nanoTime();

				String AGetTime4 = utilities.Timer();
				System.out.println("Work Release Allocated at Time is   :" + AGetTime4);
				test.log(Status.PASS, "Work Release Allocated at Time is   :" + AGetTime4);

				String AtotalTime21 = WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime2, endTime2);
				/* String s11=Long.toString(totalTime11); */
				System.out.println("The execution minutes is :" + totalTime11);
				test.log(Status.PASS, "The Wave run Execution consumed time in Minutes  : " + totalTime21);

				// .................................total time........................//

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				verifyCompleteSpecifics(test, readWebTable(waverunspage.waveTableHeader, waverunspage.waveTableBody),
						CompleteSpecs4, wvrnid3);
				test.log(Status.PASS, "DO verification completed");

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");
				addSrceenShot("Login", test, Capture);

				batchlistpage.clickExpandBarbatch();
				test.log(Status.PASS, "Clicked on ExpandBar");

				String batchlistid2 = batchlistpage.getBatchNumber();
				test.log(Status.PASS, "Batch id saved");
				addSrceenShot("Login", test, Capture);

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("batch list");
				test.log(Status.PASS, "Entered MenuSearch as Batch List");

				batchlistpage.clickbatchbutton();
				test.log(Status.PASS, "Clicked on Batch List Button");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				batchlistpage.batchsearch(batchlistid2, dashboardPage); // B20220118001999 //batchlistid
				test.log(Status.PASS, "Entered Batch List current ID");
				addSrceenShot("Login", test, Capture);

				batchlistpage.selectonebatcRC();
				test.log(Status.PASS, "Clicked on one record");

				batchlistpage.clickReleaseBtn();
				test.log(Status.PASS, "Clicked on release button");
				addSrceenShot("Login", test, Capture);

				batchlistpage.clickYesBtn();
				test.log(Status.PASS, "Clicked on Yes button");
				addSrceenShot("Login", test, Capture);

				// ...............................batch list time starts
				// at.........................//

				long AstartTime3 = System.nanoTime();

				String AGetTime5 = utilities.Timer();
				System.out.println("work release allocation process  start time is :" + AGetTime5);
				test.log(Status.PASS, "work release allocation process  start time is :");
				test.log(Status.PASS, AGetTime5);

				// ......................................................................................//

				batchlistpage.batchReleaseStatus(dashboardPage);
				test.log(Status.PASS, "waiting for new status update");

				test.log(Status.PASS, "waiting for new status update");
				System.out.println("New status changed successfully");
				addSrceenShot("Login", test, Capture);

				// .................................total time. end with
				// timer.......................//

				long AendTime3 = System.nanoTime();

				String AGetTime6 = utilities.Timer();
				System.out.println("Order get ship conformed Time is   :" + AGetTime6);
				test.log(Status.PASS, "Order get ship conformed Time is   :" + AGetTime6);

				String AtotalTime31 = WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime3, endTime3);
				/* String s31=Long.toString(totalTime31); */
				System.out.println("The execution minutes is :" + AtotalTime31);
				test.log(Status.PASS, "The batch list released Execution consumed time in Minutes  : " + totalTime31);

				// .................................total time........................//

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				dashboardPage.clickRefresh();

				verifyCompleteSpecifics(test,
						readWebTable(batchlistpage.batchTableHeader, batchlistpage.batchTableBody), CompleteSpecs5,
						batchlistid2);
				addSrceenShot("Login", test, Capture);

				// assign task............................................//

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("tasks");
				test.log(Status.PASS, "Entered MenuSearch as tasks");

				taskspage.clicktaskbutton();
				test.log(Status.PASS, "Clicked  MenuSearch page tasks");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				taskspage.enterTaskorderSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
				test.log(Status.PASS, "Entered wave run ID");
				addSrceenShot("Login", test, Capture);

				taskspage.readyForAssignStatus(dashboardPage);

				String taskiddetails2 = taskspage.gettaskNumber();
				test.log(Status.PASS, "Process Task ID saved");

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				verifyCompleteSpecifics(test, readWebTable(taskspage.tasksTableHeader, taskspage.tasksTableBody),
						CompleteSpecs6, taskiddetails2);
				test.log(Status.PASS, "Batch List Table Content Saved");

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				taskspage.selectonetaskRC();
				test.log(Status.PASS, "selected single order tab");
				addSrceenShot("Login", test, Capture);

				taskspage.clickAssignBtn();
				test.log(Status.PASS, "Clicked on assign Button");

				taskspage.enterCurrentUser(USERNAME);
				test.log(Status.PASS, "Entered Username");

				taskspage.selectonetaskRC();
				test.log(Status.PASS, "selected single order tab");
				addSrceenShot("Login", test, Capture);

				taskspage.btntaskThreedots();
				test.log(Status.PASS, "clicked on one threeDots button");

				taskspage.clickDetailsBtn();
				test.log(Status.PASS, "clicked on details button");
				addSrceenShot("Login", test, Capture);

				taskspage.clickAssignableTaskGroup();
				test.log(Status.PASS, "clicked on assigned expand bar");

				String taskgroup2 = taskspage.getTaskGroupNumber();
				test.log(Status.PASS, "taskgroup ID saved");
				addSrceenShot("Login", test, Capture);

				taskspage.clickCloseIcon();
				test.log(Status.PASS, "closed button clicked successfully");
				addSrceenShot("Login", test, Capture);

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				verifyCompleteSpecifics(test, readWebTable(taskspage.tasksTableHeader, taskspage.tasksTableBody),
						CompleteSpecs7, taskiddetails2);
				test.log(Status.PASS, "Task page all order Table Content Saved");
				addSrceenShot("Login", test, Capture);

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("wm mobile");
				test.log(Status.PASS, "Entered MenuSearch as WM Menu");

				wvMobilePage.clickWmbtn();
				test.log(Status.PASS, "Clicked on WM Mobile button");
				addSrceenShot("Login", test, Capture);

				utilities.switchToWindows();
				test.log(Status.PASS, "Window switched successfully");

				wvMobilePage.clickSettingsButton();
				test.log(Status.PASS, "Clicked on WM Settings button");

				wvMobilePage.clickTaskGroupRow();
				test.log(Status.PASS, "Clicked on Regerding Task Group");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clicktaskgroupDropDownButton();
				test.log(Status.PASS, "Clicked on Task Group Dropdown");

				wvMobilePage.selectTaskGroup(taskgroup2);
				test.log(Status.PASS, "Clicked on Task Group");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.clickDoneBtn();
				test.log(Status.PASS, "Clicked on Done Button");

				wvMobilePage.clicktasksBtn();
				test.log(Status.PASS, "Clicked on Task Button");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickEnterTaskBtn();
				test.log(Status.PASS, "Entered Task button text box column");

				wvMobilePage.enterTaskId(taskiddetails2); // Task: WRPICK0000009090
				test.log(Status.PASS, "Entered Task ID in text box");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.clickTapToConfrimBtn();
				test.log(Status.PASS, "Clicked on Tab to Conform  Button");

				// Enter cart No :

				wvMobilePage.enterVerifyCartidElement(CARTKEY);
				test.log(Status.PASS, "Entered CART KEY in text box");

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.clickConfirmBtn();
				test.log(Status.PASS, "Clicked on Conform Button");

				try {
					wvMobilePage.clickConfirmBtn();
					test.log(Status.PASS, "Clicked on Conform Button");

				} catch (Exception e) {
				}

				// Enter Location

				wvMobilePage.enterLocationID();
				test.log(Status.PASS, "Entered Current Location Barcode");

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				String itemNo1WM = wvMobilePage.getitemNumber1WMmobile();

				if (itemNo1WM.equals(itemfromOrder1)) {
					wvMobilePage.enteritemBar(itembarcode1); // itembarcode
					wvMobilePage.clickGoBtn();

				} else {

					wvMobilePage.enteritemBar(itembarcode2); // itembarcode
					wvMobilePage.clickGoBtn();

				}

				String avlUnitsA1 = wvMobilePage.verifyUnits();

				wvMobilePage.enterAvailableUnit(avlUnitsA1);
				addSrceenShot("Login", test, Capture);
				wvMobilePage.clickGoBtn();

				wvMobilePage.scanToteId(TotUserKey);
				addSrceenShot("Login", test, Capture);
				wvMobilePage.clickGoBtn();

				wvMobilePage.getInformationMessageAndClickOk();
				addSrceenShot("Login", test, Capture);

				wvMobilePage.verifyDestination(LocationKey);
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickGoBtn();
				addSrceenShot("Login", test, Capture);

				utilities.closeCurrentWindow();

				// ilpns page for check ilpn ststus

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("ILPNs");
				test.log(Status.PASS, "Entered MenuSearch as ILPNs");

				dashboardPage.clickMenuBtn(dashboardPage.lpnElement);
				test.log(Status.PASS, "Clicked on iLPN Menu link");

				lsnPage.enterLpnSearch(TotUserKey);

				addSrceenShot("Login", test, Capture);

				dashboardPage.clickRefresh();

				// check orders ststus

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("orders");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				dashboardPage.ordersclick();
				test.log(Status.PASS, "Clicked on Order Button");

				dashboardPage.clearAllBtn();

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");
				addSrceenShot("Login", test, Capture);

				taskspage.enterTaskorderSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
				test.log(Status.PASS, "Entered Order Search");

				dashboardPage.clickRefresh();

				// assign task............................................//

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("tasks");
				test.log(Status.PASS, "Entered MenuSearch as tasks");

				taskspage.clicktaskbutton();
				test.log(Status.PASS, "Clicked  MenuSearch page tasks");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				taskspage.enterWaveSearch(wvrnid3, dashboardPage);
				test.log(Status.PASS, "Entered wave run ID");
				addSrceenShot("Login", test, Capture);

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				addSrceenShot("Login", test, Capture);

				// levi pack station

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("levi");

				dashboardPage.clickLeviPackStation();
				test.log(Status.PASS, "Clicked on LeviPackStation Button");

				packStationPage.clickPackkStation();

				if (PackStation.equals("Pack Station 1")) {
					packStationPage.sendpackstation1(PackStation);
				} else if (PackStation.equals("Pack Station 2")) {
					packStationPage.sendpackstation2(PackStation);
				} else if (PackStation.equals("Pack Station 3")) {
					packStationPage.sendpackstation3(PackStation);
				}

				packStationPage.clickStartPackingBtn();

				addSrceenShot("Login", test, Capture);

				test.log(Status.PASS, "Clicked on StartPacking Button");

				packStationPage.enterToteText(TotUserKey);

				packStationPage.enterItemText(itembarcode1);// itembarcode

				packStationPage.clickDonerightClick();
				addSrceenShot("Login", test, Capture);

				packStationPage.enterSerialNumber(packStationPage.autoGenSerialNo());
				addSrceenShot("Login", test, Capture);

				packStationPage.clickGoBtnPack();

				packStationPage.serialConform();
				addSrceenShot("Login", test, Capture);

				packStationPage.enterItemText(itembarcode2);// itembarcode

				packStationPage.clickDonerightClick();
				addSrceenShot("Login", test, Capture);

				packStationPage.enterSerialNumber(packStationPage.autoGenSerialNo());
				addSrceenShot("Login", test, Capture);

				packStationPage.clickGoBtnPack();

				packStationPage.serialConform();
				addSrceenShot("Login", test, Capture);

				// ilpns page for check ilpn ststus

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("ILPNs");
				test.log(Status.PASS, "Entered MenuSearch as ILPNs");

				dashboardPage.clickMenuBtn(dashboardPage.lpnElement);
				test.log(Status.PASS, "Clicked on iLPN Menu link");

				lsnPage.enterLpnSearch(TotUserKey);
				addSrceenShot("Login", test, Capture);

				dashboardPage.clickRefresh();

				// assign task............................................//

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("tasks");
				test.log(Status.PASS, "Entered MenuSearch as tasks");

				taskspage.clicktaskbutton();
				test.log(Status.PASS, "Clicked  MenuSearch page tasks");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				taskspage.enterWaveSearch(wvrnid3, dashboardPage);
				test.log(Status.PASS, "Entered wave run ID");
				addSrceenShot("Login", test, Capture);

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				addSrceenShot("Login", test, Capture);

				// parcel journal details ORDER 1

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("Parcel journal");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				dashboardPage.ParcelJournalclick();

				dashboardPage.clearAllBtn();

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				dashboardPage.searchTransactiontextbox(olpnfromOrder1); // 00000521771100473398

				taskspage.selectActionBtn("Ship");

				taskspage.selectStatusBtn("Processed");

				// olpnsNumber

				String response1 = dashboardPage.getProviderResponse();
				System.out.println(response1);
				test.log(Status.PASS, response1);

				dashboardPage.clearAllBtn();

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				dashboardPage.searchTransactiontextbox(olpnfromOrder1); // 00000521771100473398

				taskspage.selectActionBtn("ShipRelease");

				taskspage.selectStatusBtn("Processed");

				// olpnsNumber

				try {

					String response2 = dashboardPage.getProviderResponse();
					System.out.println(response2);
					test.log(Status.PASS, response2);

				} catch (Exception e) {

				}
				dashboardPage.clearAllBtn();

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				dashboardPage.searchTransactiontextbox(olpnfromOrder1); // 00000521771100473398

				taskspage.selectActionBtn("RateShop");

				taskspage.selectStatusBtn("Processed");

				// olpnsNumber

				try {

					String response3 = dashboardPage.getProviderResponse();
					System.out.println(response3);
					test.log(Status.PASS, response3);

				} catch (Exception e) {

				}

				// MHE Journal Validation FIRST TOTE

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("MHE Journal");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				addSrceenShot("Login", test, Capture);

				orderspage.JournalMHE();
				test.log(Status.PASS, "clicked on order shordage");

				orderspage.searchMHEOrderstextbox(OrderNumber + ", " + OrderNumber2);

				orderspage.searchMsgTypeMHE("Pick_Complete");

				try {

					orderspage.selectPJfirstRow();
					test.log(Status.PASS, "select first ROW column");
					addSrceenShot("Login", test, Capture);

					orderspage.clickDetailsBtn();

					utilities.toggleGridView(dashboardPage.GridViewButton);
					test.log(Status.PASS, "Clicked on grid button and viewed record details");

					String msg1 = orderspage.getMHEvalidateDetails("PROCESSED");
					test.log(Status.PASS, msg1);

					String msg2 = orderspage.getMHEvalidateDetails("TRANSFORMED");
					test.log(Status.PASS, msg2);

					if (msg1.contains(TotUserKey)) {
						test.log(Status.PASS, "Message payload  text contains TOTE NUMBER :");
					} else {
						test.log(Status.FAIL, "Message payload  text does not contains TOTE NUMBER :");
					}

				} catch (Exception e) {

				}

				// parcel journal details ORDER 2

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("Parcel journal");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				dashboardPage.ParcelJournalclick();

				dashboardPage.clearAllBtn();

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				dashboardPage.searchTransactiontextbox(olpnfromOrder2); // 00000521771100473398

				taskspage.selectActionBtn("Ship");

				taskspage.selectStatusBtn("Processed");

				// olpnsNumber

				try {

					String response4 = dashboardPage.getProviderResponse();
					System.out.println(response4);
					test.log(Status.PASS, response4);

				} catch (Exception e) {

				}

				dashboardPage.clearAllBtn();

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				dashboardPage.searchTransactiontextbox(OrderNumber2); // 00000521771100473398

				taskspage.selectActionBtn("ShipRelease");

				taskspage.selectStatusBtn("Processed");

				// olpnsNumber

				try {

					String response5 = dashboardPage.getProviderResponse();
					System.out.println(response5);
					test.log(Status.PASS, response5);

				} catch (Exception e) {

				}

				dashboardPage.clearAllBtn();

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				dashboardPage.searchTransactiontextbox(OrderNumber2); // 00000521771100473398

				taskspage.selectActionBtn("RateShop");

				taskspage.selectStatusBtn("Processed");

				// olpnsNumber

				try {

					String response6 = dashboardPage.getProviderResponse();
					System.out.println(response6);
					test.log(Status.PASS, response6);

				} catch (Exception e) {

				}

				// Printing Journal Validation

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("olpns");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				dashboardPage.olpnclick();
				test.log(Status.PASS, "Clicked on Order Button");

				dashboardPage.clearAllBtn();

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "Page refresh completed");

				orderspage.searchOlpntextbox(OrderNumber + ", " + OrderNumber2, dashboardPage);

				addSrceenShot("Login", test, Capture);

				orderspage.selectAllRecord();
				test.log(Status.PASS, "clicked on one record button");
				addSrceenShot("Login", test, Capture);

				orderspage.clickRelatedLinks();

				orderspage.selectPrintingJournal();

				orderspage.searchDocType("COLLATE_REPORT_DEFAULT");

				orderspage.searchMetaByOLPNS(olpnfromOrder1 + ", " + olpnfromOrder2);

				// first Docs

				try {

					dashboardPage.clickRefresh();

					orderspage.selectPJfirstRow();
					test.log(Status.PASS, "select first ROW column");
					addSrceenShot("Login", test, Capture);

					orderspage.viewDocBtn();

					WaitforPage(5000);

					addSrceenShot("Login", test, Capture);

					utilities.switchToWindows();

					utilities.closeCurrentWindow();

				} catch (Exception e) {
				}

				WaitforPage(5000);

				// secound collade

				try {

					dashboardPage.clickRefresh();

					orderspage.selectSecoundRow();
					test.log(Status.PASS, "select first ROW column");
					addSrceenShot("Login", test, Capture);

					orderspage.viewDocBtn();

					WaitforPage(5000);

					addSrceenShot("Login", test, Capture);

					utilities.switchToWindows();

					utilities.closeCurrentWindow();

				} catch (Exception e) {
				}

				WaitforPage(5000);

				// first label

				orderspage.searchDocType("SHIPPING_LABEL_DEFAULT");

				orderspage.searchMetaByOLPNS(olpnfromOrder1 + ", " + olpnfromOrder2);

				// first Docs

				try {

					dashboardPage.clickRefresh();

					orderspage.selectPJfirstRow();
					test.log(Status.PASS, "select first ROW column");
					addSrceenShot("Login", test, Capture);

					orderspage.viewDocBtn();

					WaitforPage(5000);

					addSrceenShot("Login", test, Capture);

					utilities.switchToWindows();

					String LableDetails = orderspage.getShipLable();

					orderspage.newUrl();

					addSrceenShot("Login", test, Capture);

					orderspage.enterShipLable(LableDetails);

					orderspage.clickRedrew();

					addSrceenShot("Login", test, Capture);

					orderspage.clickPDFdownloadElement();

					utilities.closeCurrentWindow();

				} catch (Exception e) {
				}

				WaitforPage(6000);

				try {

					// secound docs

					dashboardPage.clickRefresh();

					orderspage.selectSecoundRow();
					test.log(Status.PASS, "select first ROW column");
					addSrceenShot("Login", test, Capture);

					orderspage.viewDocBtn();

					WaitforPage(5000);

					addSrceenShot("Login", test, Capture);

					utilities.switchToWindows();

					String LableDetails = orderspage.getShipLable();

					orderspage.newUrl();

					addSrceenShot("Login", test, Capture);

					orderspage.enterShipLable(LableDetails);

					orderspage.clickRedrew();

					addSrceenShot("Login", test, Capture);

					orderspage.clickPDFdownloadElement();

					addSrceenShot("Login", test, Capture);

					utilities.closeCurrentWindow();

				} catch (Exception e) {

				}

				// ship conformation on last process of the outbound flow

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("orders");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				addSrceenShot("Login", test, Capture);

				dashboardPage.ordersclick();
				test.log(Status.PASS, "Clicked on Order Button");

				dashboardPage.clickRefresh();

				orderspage.APPenterOrdersSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
				test.log(Status.PASS, "Entered Order Search");

				addSrceenShot("Login", test, Capture);

				orderspage.selectAllRecord();
				test.log(Status.PASS, "clicked on one record button");
				addSrceenShot("Login", test, Capture);

				orderspage.btnThreedots();
				test.log(Status.PASS, "clicked on one threeDots button");

				orderspage.clickshipbutton(test);
				test.log(Status.PASS, "clicked on ship confirm button");

				addSrceenShot("Login", test, Capture);

				// ...............................batch list time starts
				// at.........................//

				// ......................................................................................//

				long startTime4 = System.nanoTime();

				String GetTime7 = utilities.Timer();
				System.out.println("Ship Conformation is Started time :" + GetTime7);
				test.log(Status.PASS, "Ship Conformation is Started time :");
				test.log(Status.PASS, GetTime7);

				// ......................................................................................//

				orderspage.shipConfirmStatus(dashboardPage);
				test.log(Status.PASS, "DO status now changed to Shipped");

				addSrceenShot("Login", test, Capture);

				// .................................total time. end with
				// timer.......................//

				long endTime7 = System.nanoTime();

				String GetTime61 = utilities.Timer();
				System.out.println("Order get ship conformed Time is   :" + GetTime61);
				test.log(Status.PASS, "Order get ship conformed Time is   :" + GetTime61);

				test.log(Status.PASS, GetTime61);

				String totalTime5 = WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime4, endTime7);
				/* String s=Long.toString(totalTime5); */
				System.out.println("The execution minutes is :" + totalTime5);
				test.log(Status.PASS, "The Execution consumed time in Minutes  : " + totalTime5);

				// .................................total time........................//

				// tranlog details

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("system management");
				test.log(Status.PASS, "Entered MenuSearch as ILPNs");

				systemmanagementpage.clickSystemMgmtBtn();

				addSrceenShot("Login", test, Capture);

				utilities.switchToWindows();

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("tranlog details");
				test.log(Status.PASS, "Entered MenuSearch as ILPNs");

				systemmanagementpage.clickTranlogDetailsBtn();

				systemmanagementpage.enterMesgPaySearch("SHC_ANY_ShipConfirm_Custom_LSCO");

				systemmanagementpage.enterTranlogToteIDSearch(OrderNumber + ", " + OrderNumber2);

				addSrceenShot("Login", test, Capture);

				systemmanagementpage.bulkRfreshPage(dashboardPage);

				utilities.toggleGridView(dashboardPage.GridViewButton);

				addSrceenShot("Login", test, Capture);

				systemmanagementpage.clickTranFirstRecordBtn();

				addSrceenShot("Login", test, Capture);

				systemmanagementpage.clickPayLoadBtn();

				addSrceenShot("Login", test, Capture);

				systemmanagementpage.clicklinebtn();

				addSrceenShot("Login", test, Capture);

				String payLoad = systemmanagementpage.getInnerTextMessage();

				System.out.println(payLoad);

				if (payLoad.contains("Full ShipConfirm")) {
					test.log(Status.PASS, "Payload text contains " + "Full ShipConfirm");
					addSrceenShot("Login", test, Capture);
				} else {
					test.log(Status.FAIL, "Payload text does not contain " + "Full ShipConfirm");
					addSrceenShot("Login", test, true);
				}

				if (payLoad.contains(OrderNumber)) {
					test.log(Status.PASS, "Payload text contains " + OrderNumber);
					addSrceenShot("Login", test, Capture);
				} else {
					test.log(Status.FAIL, "Payload text does not contain " + OrderNumber);
					addSrceenShot("Login", test, true);
				}

				if (payLoad.contains(OrderNumber2)) {
					test.log(Status.PASS, "Payload text contains " + OrderNumber2);
					addSrceenShot("Login", test, Capture);
				} else {
					test.log(Status.FAIL, "Payload text does not contain " + OrderNumber2);
					addSrceenShot("Login", test, true);
				}

				// .................................total time. end with
				// timer.......................//

				long endTime8 = System.nanoTime();

				String GetTime211 = utilities.Timer();
				System.out.println("The Execution is finished " + GetTime211);
				test.log(Status.PASS, "The Execution is finished " + GetTime211);

				// .................................total time........................//

			
		}
	}

	@AfterMethod
	public void setUpend() {

		extent.flush();
		driver.quit();
	}
}