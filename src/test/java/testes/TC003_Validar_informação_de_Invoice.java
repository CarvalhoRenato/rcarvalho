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

public class TC003_Validar_informação_de_Invoice {

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
    public void Invoice_Tests () {


        //TC003 - Validar informação de Invoice
        //Validar a informação de invoice exibida na tela.



        // Acessar o navegador
        navegador.get("https://automation-sandbox.herokuapp.com");


        // Identificar o campo "User name" e inserir dado válido
        navegador.findElement(By.name("username")).sendKeys("demouser");

        // Identificar o campo "Password" e inserir dado válido
        navegador.findElement(By.name("password")).sendKeys("abc123");

        // Identificar o botão "Login" e clicar nele by ID
        navegador.findElement(By.id("btnLogin")).click();

        // Certificar a presença do texto "Invoice List"

        navegador.findElement(By.xpath("//h2[text()=\"Invoice List\"]"));

        // Clicar em "Invoice Details"
        navegador.findElement(By.linkText("Invoice Details")).click();


        // Ir para nova aba
        navegador.get("https://automation-sandbox.herokuapp.com/invoice/0");

        // Certificar a presença do texto "Invoice List"
        navegador.findElement(By.xpath("//h2[text()=\"Invoice Details\"]"));


        // V A L I D A Ç Õ E S        I N V O I CE       D E T A I L S //

        // Verificar valor do campo "Hotel Name"
        WebElement Hotel = navegador.findElement(By.xpath("//h4[text()=\"Rendezvous Hotel\"]"));
        String HotelName = Hotel.getText();
        assertEquals("Rendezvous Hotel",HotelName);

        // Verificar valor do campo "Invoice Date"
        WebElement Invoice = navegador.findElement(By.xpath("//li[text()=\" 14/01/2018\"]"));
        String InvoiceDate = Invoice.getText();
        assertEquals("Invoice Date: 14/01/2018", InvoiceDate);

        // Verificar valor do campo "Due Date"
        WebElement Due = navegador.findElement(By.xpath("//li[text()=\" 15/01/2018\"]"));
        String DueDate = Due.getText();
        assertEquals("Due Date: 15/01/2018", DueDate);

        // Verificar valor do campo "Invoice Number"
        WebElement InvoiceN = navegador.findElement(By.xpath("//h6[text()=\"Invoice #110 details\"]"));
        String InvoiceNumber = InvoiceN.getText();
        assertEquals("Invoice #110 details", InvoiceNumber);

        // Verificar valor do campo "Booking Code"

        WebElement Booking = navegador.findElement(By.xpath("//td[text()=\"0875\"]"));
        String BCode = Booking.getText();
        assertEquals("0875",BCode);

        // Verificar valor do campo "Customer Details"
        navegador.findElement(By.xpath("//h5[text()=\"Customer Details\"]"));
        WebElement Customer = navegador.findElement(By.xpath("//div[text()=\"123456\"]"));
        String CustomerDetails = Customer.getText();
        assertEquals("JOHNY SMITH\n" +
                "R2, AVENUE DU MAROC\n" +
                "123456",CustomerDetails);

        // Verificar valor do campo "Room"
        WebElement Room = navegador.findElement(By.xpath("//td[text()=\"Superior Double\"]"));
        String Room01 = Room.getText();
        assertEquals("Superior Double",Room01);

        // Verificar valor do campo "CheckIn"
        WebElement CheckIn = navegador.findElement(By.xpath("//td[text()=\"14/01/2018\"]"));
        String check_in = CheckIn.getText();
        assertEquals("14/01/2018",check_in);

        // Verificar valor do campo "CheckOut"
        WebElement CheckOut= navegador.findElement(By.xpath("//td[text()=\"15/01/2018\"]"));
        String check_out = CheckOut.getText();
        assertEquals("15/01/2018",check_out);


        // Verificar valor do campo "Total Stay Count
        WebElement TotalSC= navegador.findElement(By.xpath("//td[text()=\"1\"]"));
        String TotalStayCount = TotalSC.getText();
        assertEquals("1",TotalStayCount);

        // Verificar valor do campo "Total Stay Amount"
        WebElement TotalSA= navegador.findElement(By.xpath("//td[text()=\"$150\"]"));
        String TotalStayAmount = TotalSA.getText();
        assertEquals("$150",TotalStayAmount);

        // Verificar valor do campo "Deposit Now"
        WebElement Deposit_N= navegador.findElement(By.xpath("//td[text()=\"USD $20.90\"]"));
        String DepositNow = Deposit_N.getText();
        assertEquals("USD $20.90",DepositNow);

        // Verificar valor do campo "Tax & VAT"
        WebElement TXV= navegador.findElement(By.xpath("//td[text()=\"USD $19\"]"));
        String TAX_VAT = TXV.getText();
        assertEquals("USD $19",TAX_VAT);

        // Verificar valor do campo "Total Amount"
        WebElement TotalA= navegador.findElement(By.xpath("//td[text()=\"USD $209\"]"));
        String TotalAmount = TotalA.getText();
        assertEquals("USD $209",TotalAmount);

    }

@After
        public void TearDown(){

    // Descomentar caso deseje o fechamento da página atual
    //navegador.close();


}

}
