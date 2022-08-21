package curso.qa;
import org.openqa.selenium.By;
// import org.openqa.selenium.Dimension;
// import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import org.junit.Test;



public class TesteFormulario {
    
    
    // ESPERANDO 10 SEGUNDOS
    public void pularSegundos(int milisegundos){
        try {
            Thread.currentThread().sleep(milisegundos); // Espera 10000 milisegundos antes de executar o próximo passo
        } catch (InterruptedException e) {e.printStackTrace();}
    }

    @Test
    public void TesteBoxTexto(){

        // CRIAÇÃO E AJUSTES DO WEBDRIVER
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // CAMINHO PARA O WEBDRIVER
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html"); // o System.getProperty("user.dir") pega o diretorio do projeto

        // FAZENDO TESTE
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Testando escrita"); // escolhe o elemento e envia chaves do teclado
        Assert.assertEquals("Testando escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));

        pularSegundos(10000);

        driver.quit();
        
    }


    @Test
    public void TesteBox2(){

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Testando box de texto");
        Assert.assertEquals("Testando box de texto", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

        pularSegundos(10000);

        driver.quit();
        
    }   

    @Test
    public void TesteRadio(){

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html");
        // driver.findElement(By.id("elementosForm:sexo:0")).click();
        
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

        pularSegundos(10000);

        driver.quit();

    }

    @Test
    public void TesteCombo() {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html");

        WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade")); // Jogando o elemento selcionado em uma variável
        Select combo = new Select(elemento); // Utilizando o select presente no selenium para conseguir percorrer pelas opções do combo
        // combo.selectByIndex(3);
        // combo.selectByValue("superior");
        combo.selectByVisibleText("2o grau completo");
        
        Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());

        pularSegundos(10000);

        driver.quit();
    }

}
