import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class tests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Mike"); // "id=userName" не работает \ а "#userName" проходит???
        $("#userEmail").setValue("mike@mike.com");
        $("#currentAddress").setValue("Rabochaya 1a");
        $("#permanentAddress").setValue("Rabochyi prospect");
        $("#submit").click();

        //   $("id=submit").click();
        $("#output #name").shouldHave(text("Mike"));
//        $("#output").$("#name").shouldHave(text("Mike"));
//        $("#output").shouldHave(text("Mike"));
//        $("#name").shouldHave(text("Mike"));
        $("#output #email").shouldHave(text("mike@mike.com"));
        $("#output #currentAddress").shouldHave(text("Rabochaya 1a"));
        $("#output #permanentAddress").shouldHave(text("Rabochyi prospect"));
    }
}
