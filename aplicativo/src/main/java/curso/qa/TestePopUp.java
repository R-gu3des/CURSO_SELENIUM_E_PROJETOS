package curso.qa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestePopUp {
    
    TesteFormulario tempo = new TesteFormulario();

    @Test
    public void abrirPopUp(){

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        String caminho = "file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html";
        driver.get(caminho);

        driver.findElement(By.id("buttonPopUpEasy")).click();

        driver.switchTo().window("Popup");
        driver.findElement(By.tagName("textarea")).sendKeys("Texto no Popup");
        driver.switchTo().window("");

        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Texto externo!");
        tempo.pularSegundos(5);
        driver.quit();
        
    }

    public void ineteragirComJanelaSemTitulo(){

        WebDriver driver = new ChromeDriver();
        String caminho = System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html";

        
    }
}
