package Control;

import Model.Tipo;
import TelasGui.TipoGrid;
import TelasGui.TipoTela;
import java.util.List;
import DAO.TipoDAO;
import ModeTable.TipoTableModel;
/**
 *
 * @author otávio
 */

public class TipoControl extends AbstractControleSimples<Tipo>{

    protected TipoGrid grid;
    private final TipoTela tela;
    private TipoTableModel model;

    public TipoControl() {
        dao = new TipoDAO();
        model = new TipoTableModel(dao.findAll());
        grid = new TipoGrid(null, true, this, model);
        grid.setControle(this);
        tela = new TipoTela(null, true);
    }
    
    
    
    @Override
    public void showInicialScreen() {
        grid.setVisible(true);
    }

    @Override
    public Tipo create() {
        Tipo categoria = tela.criar();

            if(tela.isRetornoOk() == false){
                //categoria = null;

                return null;
                
            }    
            else{

                categoria = tela.getScreenObject();
                dao.create(categoria);
            }

        
        model.add(categoria);
        return categoria;
    }

    @Override
    public void read(Tipo objeto) {
//        List<Categoria> lista = dao.findAll();
//        tela.listar(lista);
        tela.mostrar(objeto);

    }

    @Override
    public Tipo update(Tipo objeto) {
        Tipo cat = tela.editar(objeto);
        Tipo cat2 = dao.update(cat);
        model.update(cat, cat2);
        return cat2;
//        this.read(null);
//        long id = tela.askForInt("Digite o código do funcionário a editar");
//        Tipo categoria = dao.findById(id);
//        categoria =tela.editar(categoria);
//        
//        if (tela.isRetornoOk() == false) {
//            categoria =null;
//        }
//        else{
//            dao.update(categoria);
//        }
//        
//        
//        return categoria;
        
        


    }

    @Override
    public boolean delete(Tipo objeto) {
//        this.read(null);        

//        int id = tela.askForInt("Insira o código do funcionário a remover");    
//        Tipo categoria = dao.findById(id);
        
        //boolean resposta = dao.delete(categoria);
        
//        if(resposta == false){
//            tela.showMessage("Funcionário não encontrado");
//        }
//        else{
//            tela.showMessage("Funcionário excluído com êxito");
//        }
        //model.remove(categoria);
        dao.delete(objeto);
        model.remove(objeto);
        return true;
    }

    @Override
    public void print() {
        
        
    }

    @Override
    public boolean filter(String column, String valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
