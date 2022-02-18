
package Control;

import DAO.ClienteDAO;
import Model.Cliente;
import TelasGui.ClienteGrid;
import TelasGui.ClienteTela;
import java.util.List;
import ModeTable.ClienteTableModel;

/**
 *
 * @author otávio
 */

public class ClienteControl extends AbstractControleSimples<Cliente>{

    protected ClienteGrid grid;
    private ClienteTela tela;
    private ClienteTableModel model;

    
    public ClienteControl(){
        dao = new ClienteDAO();
        
        model = new ClienteTableModel(dao.findAll());
        grid = new ClienteGrid(null, true, this, model);
        grid.setControle(this);
        
        tela = new ClienteTela(null, true); 
    }
    
    @Override
    public void showInicialScreen() {
        grid.setVisible(true);
    }

    @Override
    public Cliente create() {


        Cliente funcionario =tela.criar();
        
        if(tela.isRetornoOk() == false){
            return null;
        }
        else{
            funcionario = tela.getScreenObject();
            dao.create(funcionario);
        }
        model.add(funcionario);
        return funcionario;
    }

    @Override
    public void read(Cliente objeto) {
//        List<Funcionario> lista = dao.findAll();
//        tela.listar(lista);
        tela.mostrar(objeto);
    }

    @Override
    public Cliente update(Cliente objeto) {
        Cliente f = tela.editar(objeto);
        Cliente f2 = dao.update(f);
        model.update(f, f2);
    
        return f2;
    }

    @Override
    public boolean delete(Cliente objeto) {
        
        dao.delete(objeto);
        model.remove(objeto);
        return true;
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean filter(String column, String valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
