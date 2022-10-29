package curso.qa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteFrame {

    TesteFormulario funcoes = new TesteFormulario();

    @Test
    public void interagirComFrame() {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        String caminho = "file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html";
        driver.get(caminho);

        driver.switchTo().frame("frame1");
        driver.findElement(By.id("frameButton")).click();

        Alert alerta = driver.switchTo().alert();
        String mensagem = alerta.getText();
        
        Assert.assertEquals("Frame OK!", mensagem);
        alerta.accept();

        driver.switchTo().defaultContent();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(mensagem);

        funcoes.pularSegundos(10);

        driver.quit();
        
    }

}
