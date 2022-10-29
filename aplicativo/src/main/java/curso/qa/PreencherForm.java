package curso.qa;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PreencherForm {
    
    TesteFormulario funcao = new TesteFormulario();

    public void preencherForm(){
        WebDriver driver = new FirefoxDriver();
        String caminho = "file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html";
        driver.manage().window().maximize();

        driver.get(caminho);

        //preeencher dados
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Ruan");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Guedes Vieira");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();

        funcao.pularSegundos(1);
        Select escolaridade = new Select(driver.findElement(By.id("elementosForm:escolaridade")));
        escolaridade.selectByVisibleText("Superior");

        funcao.pularSegundos(1);
        Select esportes = new Select(driver.findElement(By.id("elementosForm:esportes")));
        esportes.selectByVisibleText("Futebol");

        funcao.pularSegundos(1);
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Sem sugestões");
        driver.findElement(By.id("elementosForm:cadastrar")).click();

        funcao.pularSegundos(2);

        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        Assert.assertEquals("Nome: Ruan", driver.findElement(By.id("descNome")).getText());
        Assert.assertEquals("Sobrenome: Guedes Vieira", driver.findElement(By.id("descSobrenome")).getText());
        Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
        Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
        Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
        Assert.assertEquals("Esportes: Futebol", driver.findElement(By.id("descEsportes")).getText());

        funcao.pularSegundos(2);
        driver.quit();
        
    }

    
}
