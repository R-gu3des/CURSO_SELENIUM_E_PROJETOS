package curso.qa;
import curso.qa.AreaDeTeste;
import org.junit.jupiter.api.Test;

public class AreaDeTeste {
    
    // TESTES DO FORMULARIO
    TesteFormulario testeform = new TesteFormulario();
    TesteComAlertas testeAlert = new TesteComAlertas();
    PreencherForm preencher = new PreencherForm();
    TesteFrame frame = new TesteFrame();
    TestePopUp popup = new TestePopUp();
    
    @Test
    void testAbrirForm() {
        testeform.abrirForm();    
    }

    @Test
    void testTesteBox2() {
        testeform.TesteBox2();
    }

    @Test
    void testTesteBoxTexto() {
        testeform.TesteBoxTexto();
    }

    @Test
    void testTesteRadio() {
        testeform.TesteRadio();
    }

    @Test
    void testTesteCombo() {
        testeform.TesteCombo();
    }

    @Test
    void testTesteCombo2() {
        testeform.TesteCombo();
    }

    @Test
    void testVerificaValoresCombo() {
        testeform.VerificaValoresCombo();
    }

    @Test
    void testVerificaValoresComboMultiplo() {
        testeform.VerificaValoresComboMultiplo();
    }

    @Test
    void testInterageComBotoes() {
        testeform.InterageComBotoes();
    }

@Test
    void testInterageComLinks() {
        testeform.InterageComLinks();
    }

    @Test
    void testBuscaTextoNaPagina() {
        testeform.BuscaTextoNaPagina();
    }


    // TEST COM ALERT

    @Test
    void testTesteAlerta() {
        testeAlert.TesteAlerta();
    }

    @Test
    void testInterageirConfirm() {
        testeAlert.interagirConfirm();
    }

        
    // PREENCHENDO TOOD O FORMULÁRIO

    @Test
    void testPreencherForm() {
        preencher.preencherForm();
    }



    // APRENDENDO SOBRE FRAMES
    @Test
    void testInteragirComFrame() {
        frame.interagirComFrame();
    }

    
    
    // APRENDENDO SOBRE POPUPS
    @Test
    void testAbrirPopUp() {
        popup.abrirPopUp();
    }

}