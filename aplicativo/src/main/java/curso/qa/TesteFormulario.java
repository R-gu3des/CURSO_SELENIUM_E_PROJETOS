package curso.qa;
import org.openqa.selenium.By;
// import org.openqa.selenium.Dimension;
// import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;



public class TesteFormulario {
    
    
    // ESPERANDO ALGUNS SEGUNDOS
    public void pularSegundos(int segundos){
        try {
            Thread.currentThread().sleep(segundos * 1000); // Espera 10000 milisegundos antes de executar o próximo passo
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

        pularSegundos(10);

        driver.quit();
        
    }


    @Test
    public void TesteBox2(){

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Testando box de texto");
        Assert.assertEquals("Testando box de texto", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

        pularSegundos(10);

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

        pularSegundos(10);

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

        pularSegundos(10);

        driver.quit();
    }

    @Test   
    public void VerificaValoresCombo() {

        WebDriver driver = new FirefoxDriver();
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
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        String caminho = "file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html";
        driver.get(caminho);

        WebElement formulario = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(formulario);
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Futebol");
        combo.selectByVisibleText("Corrida");
        
        List<WebElement> selecionados = combo.getAllSelectedOptions();
        Assert.assertEquals(3, selecionados.size());

        combo.deselectByVisibleText("Corrida");
        Assert.assertEquals(2, combo.getAllSelectedOptions().size());

        pularSegundos(10);
        driver.quit();

    }

    @Test
    public void InterageComBotoes(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        String caminho = "file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html";

        driver.get(caminho);

        // driver.findElement(By.id("buttonSimple")).click();
        WebElement botao = driver.findElement(By.id("buttonSimple"));
        botao.click();

        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));

        pularSegundos(10);

        driver.quit();

    }

    @Test
    @Ignore //maneira de ignorar o teste
    public void InterageComLinks(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        String caminho = "file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html";

        driver.get(caminho);

        driver.findElement(By.linkText("voltar")).click();
        Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
        pularSegundos(10);
        driver.quit();

    }

    public void BuscaTextoNaPagina(){
        WebDriver driver = new FirefoxDriver();
        String caminho = "file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html";
        driver.manage().window().maximize();

        driver.get(caminho);

        // System.out.println(driver.findElement(By.tagName("body")).getText());

        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));

        pularSegundos(10);

        // Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());

        driver.quit();
    }


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

        pularSegundos(2);
        driver.quit();
        
    }



    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/aplicativo/src/main/java/curso/qa/resources/componentes.html");

        WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade")); // Jogando o elemento selcionado em uma variável
        Select combo = new Select(elemento); // Utilizando o select presente no selenium para conseguir percorrer pelas opções do comb
        combo.selectByVisibleText("2o grau completo");
        System.out.println("Essse é o elemento ----->> " + elemento);
        System.out.println("Essse é o Comobo ----->> " + combo);
        
        Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
        
        TesteFormulario timer = new TesteFormulario();
        timer.pularSegundos(15);

        driver.quit();
    }

    public void abrirForm(){
        WebDriver driver = new FirefoxDriver();
        String caminho = "file:///" + System.getProperty("user.dir") + "/src/main/java/curso/qa/resources/componentes.html";
        driver.get(caminho);

    }
}
