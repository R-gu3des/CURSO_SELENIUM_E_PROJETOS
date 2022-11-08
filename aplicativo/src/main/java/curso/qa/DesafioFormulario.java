package curso.qa;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioFormulario {
    

    TesteFormulario tempo = new TesteFormulario();

    public void TesteRegrasForm(){

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        String caminho = "file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html";
        
        driver.get(caminho);
        tempo.pularSegundos(3);
        
        
        WebElement botaoCadastrar = driver.findElement(By.id("elementosForm:cadastrar"));
        WebElement caixaSugestoes = driver.findElement(By.id("elementosForm:sugestoes"));

        // Teste do Nome
        botaoCadastrar.click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals(alerta.getText(), "Nome eh obrigatorio");
        alerta.accept();
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Ruan");
        caixaSugestoes.sendKeys("O Teste do nome passou!");
        tempo.pularSegundos(5);


        // Teste do Sobrenome
        botaoCadastrar.click();
        alerta = driver.switchTo().alert();
        Assert.assertEquals(alerta.getText(), "Sobrenome eh obrigatorio");
        alerta.accept();
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Guedes Vieira");
        caixaSugestoes.clear();
        caixaSugestoes.sendKeys("O Teste do Sobrenome passou!");
        tempo.pularSegundos(5);

        // teste do sexo
        botaoCadastrar.click();
        alerta = driver.switchTo().alert();
        Assert.assertEquals(alerta.getText(), "Sexo eh obrigatorio");
        alerta.accept();
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        caixaSugestoes.clear();
        caixaSugestoes.sendKeys("O teste do sexo passou!");
        tempo.pularSegundos(5);

        // Preenchendo comida
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        botaoCadastrar.click();
        alerta = driver.switchTo().alert();
        Assert.assertEquals(alerta.getText(), "Tem certeza que voce eh vegetariano?");
        alerta.accept();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        caixaSugestoes.clear();
        caixaSugestoes.sendKeys("O Teste Da comida passou!");
        tempo.pularSegundos(5);

        // Teste dos esportes
        WebElement formulario = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(formulario);
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("O que eh esporte?");
        botaoCadastrar.click();
        alerta = driver.switchTo().alert();
        Assert.assertEquals(alerta.getText(), "Voce faz esporte ou nao?");
        alerta.accept();
        caixaSugestoes.clear();
        caixaSugestoes.sendKeys("O teste dos esportes passou!");
        tempo.pularSegundos(5);
        caixaSugestoes.clear();
        caixaSugestoes.sendKeys("Agora todos os testes foram finalizados!");
        tempo.pularSegundos(5);
        driver.quit();



    }

}
