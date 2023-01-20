package objects;

import framework.base.BaseForm;
import framework.base.elements.Button;
import framework.base.elements.InputField;
import framework.base.elements.Text;
import framework.logger.Logger;
import org.openqa.selenium.By;

public class UploadAndDownloadPage extends BaseForm {
    private static By locatorDatePickerPage = By.xpath("//*[contains(@class, 'main-header') and contains(text(), 'Upload and Download')]");
    private Button downloadButton = new Button(By.xpath("//*[@id='downloadButton']"), "Кнопка Download");
    private InputField selectFile = new InputField(By.xpath("//*[@id='uploadFile']"), "Поле выбора файла");
    private Text uploadedFilePath = new Text(By.xpath("//*[@id='uploadedFilePath']"), "Путь к загруженому файлу");

    public UploadAndDownloadPage() {
        super(locatorDatePickerPage);
    }

    public void clickButtonDownload(){
        Logger.info(getClass().getSimpleName()+": Клик по кнопке Download");
        downloadButton.waitVisibilityOfElementLocated();
        downloadButton.click();
    }

    public void setPathToFile(String pathToFile){
        Logger.info(getClass().getSimpleName()+": Ввести локальный путь к загружаемому файлу");
        selectFile.setValue(pathToFile);
    }

    public String getUploadedFilePath(){
        Logger.info(getClass().getSimpleName()+": Получить путь к загруженому файлу из формы");
        uploadedFilePath.waitVisibilityOfElementLocated();
        return uploadedFilePath.getText();
    }
}
