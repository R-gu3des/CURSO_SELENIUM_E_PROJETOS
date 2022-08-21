package curso.qa;
import curso.qa.AreaDeTeste;
import org.junit.jupiter.api.Test;


public class AreaDeTeste {
    
    // TESTES DO FORMULARIO
    TesteFormulario elemento = new TesteFormulario();
    
    @Test
    void testTesteBox2() {
        elemento.TesteBox2();
    }

    @Test
    void testTesteBoxTexto() {
        elemento.TesteBoxTexto();
    }

    @Test
    void testTesteRadio() {
        elemento.TesteRadio();
    }

    @Test
    void testTesteCombo() {
        elemento.TesteCombo();
    }

    @Test
    void testTesteCombo2() {
        elemento.TesteCombo();
    }

}
