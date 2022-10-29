package curso.qa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteComAlertas {

    TesteFormulario funcoes = new TesteFormulario();

    // Classe destinada a testes com Alerts
    @Test
    public void TesteAlerta(){


        WebDriver driver = new FirefoxDriver();
        String caminho = "file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html";
        driver.manage().window().maximize();
        driver.get(caminho);

        driver.findElement(By.id("alert")).click();

        //Os Alertas ficam externos a página principal, por isso não conseguimos encontrar ao inspecionar-mos a página

        driver.switchTo().alert(); // Devido a mudaça de foco trazidas pelo alerta que utilizamos esse comando

        Alert alerta = driver.switchTo().alert();
        String texto = alerta.getText();
        

        Assert.assertEquals("Alert Simples", alerta.getText());
        alerta.accept();
        funcoes.pularSegundos(10);
        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
        
        funcoes.pularSegundos(10);
        driver.quit();

    }

    @Test
    public void interagirAlert(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        String caminho = "file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/componentes.html";

        driver.get(caminho);
        driver.findElement(By.id("confirm")).click();;
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alerta);

    }

    @Test   
    public void interagirConfirm(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        String caminho = "file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html";
        driver.get(caminho);

        driver.findElement(By.id("confirm")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alerta.getText());
        alerta.accept();
        Assert.assertEquals("Confirmado", alerta.getText());
        alerta.accept();

        driver.findElement(By.id("confirm")).click();
        alerta = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alerta.getText());
        alerta.dismiss();
        Assert.assertEquals("Negado", alerta.getText());
        alerta.accept();
        
        driver.quit();

    }
}
