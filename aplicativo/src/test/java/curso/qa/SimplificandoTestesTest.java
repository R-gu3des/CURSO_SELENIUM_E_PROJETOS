package curso.qa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimplificandoTestesTest {

    SimplificandoTestes simples = new SimplificandoTestes();

    @AfterEach // É utilizado durante o encerramento dos código
    void testEncerrar() {
        simples.encerrar();
    }

    @BeforeEach // É utilizado durante o incicio dos código
    void testInicializar() {
        simples.inicializar();
    }


    @Test
    void testBuscaTextoNaPagina() {
        simples.BuscaTextoNaPagina();
    }

    @Test
    void testInterageComBotoes() {
        simples.InterageComBotoes();
    }

    @Test
    void testInterageComLinks() {
        simples.InterageComLinks();
    }

    @Test
    void testTesteBox2() {
        simples.TesteBox2();
    }

    @Test
    void testTesteBoxTexto() {
        simples.TesteBoxTexto();
    }

    @Test
    void testTesteCombo() {
        simples.TesteCombo();
    }

    @Test
    void testTesteRadio() {
        simples.TesteRadio();
    }

    @Test
    void testVerificaValoresCombo() {
        simples.VerificaValoresCombo();
    }

    @Test
    void testVerificaValoresComboMultiplo() {
        simples.VerificaValoresComboMultiplo();
    }

    @Test
    void testPreencherForm() {
        simples.preencherForm();
    }
}
