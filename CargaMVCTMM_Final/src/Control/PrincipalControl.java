
package Control;

import TelasGui.TelaPrincipal;

/**
 *
 * @author otávio
 */
public class PrincipalControl {
    private TelaPrincipal tela;
    private final ClienteControl funControle;
    private final TipoControl cateController;
    private final CargaControl produtoController;
    private final EncarregadoControl fornecedorController;

    public TelaPrincipal getTela() {
        return tela;
    }

    public void setTela(TelaPrincipal tela) {
        this.tela = tela;
    }

    public PrincipalControl() {
        funControle = new ClienteControl();
        cateController = new TipoControl();
        fornecedorController =new EncarregadoControl();
        produtoController = new CargaControl(cateController, fornecedorController);
        
    }

    public void iniciaFuncionarioControle() {
        funControle.showInicialScreen();
    }
    
    public void iniciar() {
        tela = TelaPrincipal.getInstance(this);
        tela.setVisible(true);
    } 

    public void iniciaCategoriaControle() {
        cateController.showInicialScreen();
    }
    
    public void iniciaProdutoControle(){
        produtoController.showInicialScreen();
    }
    
    public void iniciaFornecedorControle(){
        fornecedorController.showInicialScreen();
    }
}
