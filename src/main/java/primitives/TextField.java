package primitives;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;

public class TextField extends BaseElement {
    public TextField(By locator, String description) {
        super(locator, description);
    }

    public String getText(){
        String text = get().getText();
        Allure.addAttachment(String.format("get text '%s'", text), description);
        return text;
    }
}
