package curso.qa;
import org.junit.Test;
import org.junit.Assert;
// import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;;

public class TesteChrome {
    
    @Test
    public void teste() {

        //INSTANCIANDO O WEBDRIVER
        WebDriver driver = new ChromeDriver();


        // ALTERAR AUTOMATICAMENTE O TAMANHO E A POSIÇÃO DA JANELA DO BROWSER
        driver.manage().window().setPosition(new Point(100, 100)); 
        driver.manage().window().maximize();
        // driver.manage().window().setSize(new Dimension(1200, 768)); // Modificando as dimensões


        driver.get("https://www.google.com/");                   // driver.get(url) recebe uma url e abre na página do navegador
        System.out.println(driver.getTitle());                       // driver.getTitle() me passa o titulo encontrado na páginas
        Assert.assertEquals("Yahoo", driver.getTitle());   // Passando o link do google e comparando com  assertEquals se o títlo da página é o "yahoo"

        driver.manage().window().setPosition(new Point(100, 100)); 
    }

}
