package curso.qa;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class SimplificandoTestes {

    public TesteFormulario tempo = new TesteFormulario();
    public WebDriver driver; 


    @Test
    public void inicializar(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html");
    }

    @Test
    public void encerrar(){
        driver.quit();
    }

    @Test
    public void TesteBoxTexto(){
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Testando escrita"); // escolhe o elemento e envia chaves do teclado
        Assert.assertEquals("Testando escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
        tempo.pularSegundos(10);
    }


    @Test
    public void TesteBox2(){
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Testando box de texto");
        Assert.assertEquals("Testando box de texto", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
        tempo.pularSegundos(10);
    }   

    @Test
    public void TesteRadio(){
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

        tempo.pularSegundos(10);


    }

    @Test
    public void TesteCombo() {
        WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade")); // Jogando o elemento selcionado em uma variável
        Select combo = new Select(elemento);
        combo.selectByVisibleText("2o grau completo");
        
        Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());

        tempo.pularSegundos(10);
    }

    @Test   
    public void VerificaValoresCombo() {
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html");

        WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(elemento);
        List<WebElement> opcoes = combo.getOptions();
        Assert.assertEquals(8, opcoes.size());

        boolean encontrou = false;

        for(WebElement opcao: opcoes) {
            if (opcao.getText().equals("Mestrado")){
                encontrou = true;
                break;
            }  
        }
        Assert.assertTrue(encontrou);
    
    }

    @Test
    public void VerificaValoresComboMultiplo(){
        WebElement formulario = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(formulario);
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Futebol");
        combo.selectByVisibleText("Corrida");
        
        List<WebElement> selecionados = combo.getAllSelectedOptions();
        Assert.assertEquals(3, selecionados.size());
        combo.deselectByVisibleText("Corrida");
        Assert.assertEquals(2, combo.getAllSelectedOptions().size());
        tempo.pularSegundos(10);

    }

    @Test
    public void InterageComBotoes(){
        WebElement botao = driver.findElement(By.id("buttonSimple"));
        botao.click();
        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
        tempo.pularSegundos(10);

    }

    @Test
    public void InterageComLinks(){
        driver.findElement(By.linkText("Voltar")).click();
        Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
        tempo.pularSegundos(10);

    }

    public void BuscaTextoNaPagina(){
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
        tempo.pularSegundos(10);
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
    }


    public void preencherForm(){
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Ruan");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Guedes Vieira");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        tempo.pularSegundos(2);
        
    }

}