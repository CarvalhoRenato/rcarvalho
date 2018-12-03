package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TC002_Login_Negativo {

    private WebDriver navegador;
    @Before
public void setUp (){

    //Definições
    System.setProperty("webdriver.chrome.driver","C:\\users\\rcarvalho\\drivers\\chromedriver.exe");
    //Criar variável
    navegador = new ChromeDriver();
    navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
    @Test
    public void Login_Negativo () {

        //TC002_Login_Negativo
        //Validar que a aplicação nega o login do usuário quando utilizando credenciais inválidas.

        // Acessar o navegador
        navegador.get("https://automation-sandbox.herokuapp.com/");

        // TC002 - 01 - User inválido + Password válido
        navegador.findElement(By.name("username")).sendKeys("Demouser");
        navegador.findElement(By.name("password")).sendKeys("abc123");
        navegador.findElement(By.id("btnLogin")).click();
        WebElement ErrorAlert = navegador.findElement(By.xpath("//div[@ role=\"alert\"]"));
        String mensagem = ErrorAlert.getText();
        assertEquals("Wrong username or password.",mensagem);

        // TC002 - 02 - User inválido + Password inválido
        navegador.findElement(By.name("username")).sendKeys("demouser_");
        navegador.findElement(By.name("password")).sendKeys("xyz");
        navegador.findElement(By.id("btnLogin")).click();
        assertEquals("Wrong username or password.",mensagem);


        // TC002 - 03 - User válido + Password inválido
        navegador.findElement(By.name("username")).sendKeys("demouser");
        navegador.findElement(By.name("password")).sendKeys("nananana");
        navegador.findElement(By.id("btnLogin")).click();
        assertEquals("Wrong username or password.",mensagem);

        // TC002 - 04 - (Duplicado com TC002 - 01)

    }

@After
        public void TearDown(){

    // Descomentar caso deseje o fechamento da página atual
    //navegador.close();


}

}
