package DemoBlaze;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTests extends BaseTests {

    @Test
    public void sendingContactMessageShouldFinishWithConfirmation() {

        HomePage homePage = new HomePage(driver, wait);

        homePage.go();

        homePage.openContactModal();

        homePage.fillContactForm("aaa@wp.pl", "Andrzej", "aaaaaaa");

        homePage.sendMessage();

        Assertions.assertEquals(homePage.getAlertTextAndAccept(), "Thanks for the message!!");

    }
}
