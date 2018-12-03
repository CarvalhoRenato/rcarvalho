package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TC001_Login_Positivo {

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
    public void Login () {

        //Validar se o usuário consegue fazer login na aplicação quando fornecendo credenciais válidas.
        //TC001 - Login Positivo

        // Acessar o navegador
        navegador.get("https://automation-sandbox.herokuapp.com/");

        // Identificar o campo "User name" e inserir dado válido
        navegador.findElement(By.name("username")).sendKeys("demouser");

        // Identificar o campo "Password" e inserir dado válido
        navegador.findElement(By.name("password")).sendKeys("abc123");

        // Identificar o botão "Login" e clicar nele by ID
        navegador.findElement(By.id("btnLogin")).click();

        // Certificar a presença do texto "Invoice List"
        navegador.findElement(By.xpath("//h2"));

    }

@After
        public void TearDown(){

    //fechar o navegador
    // Descomentar caso deseje o fechamento da página atual


}

}
