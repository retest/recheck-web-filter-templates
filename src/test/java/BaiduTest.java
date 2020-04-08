import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.web.RecheckWebOptions;

public class BaiduTest {

	private WebDriver driver;
	private Recheck re;

	@Before
	public void setUp() {
		final RecheckWebOptions options = (RecheckWebOptions) RecheckWebOptions.builder() //
				.setIgnore( "baidu.filter" ) //
				.build();

		re = new RecheckImpl( options );

		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments( "--headless", "--window-size=1280,720" );

		driver = new ChromeDriver( chromeOptions );
	}

	@Test
	public void baidu_default_template() {
		re.startTest();
		driver.get( "https://www.baidu.com" );
		re.check( driver, "open" );
		re.capTest();
	}

	@After
	public void tearDown() {
		driver.quit();
		re.cap();
	}
}
