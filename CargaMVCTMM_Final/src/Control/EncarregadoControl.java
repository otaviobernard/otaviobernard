/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.List;
import DAO.EncarregadoDAO;
import Model.Encarregado;
import ModeTable.EncarregadoTableModel;
import TelasGui.EncarregadoGrid;
import TelasGui.EncarregadoTela;
/**
 *
 * @author otávio
 */
public class EncarregadoControl extends AbstractControleSimples<Encarregado>{

    protected EncarregadoGrid grid;
    private final EncarregadoTela tela;
    private EncarregadoTableModel model;
    
    public EncarregadoControl() {
        dao = new EncarregadoDAO();
        model = new EncarregadoTableModel(dao.findAll());
        grid = new EncarregadoGrid(null, true, this, model);
        grid.setControle(this);
        tela = new EncarregadoTela(null, true);
    }
    
    @Override
    public void showInicialScreen() {
        grid.setVisible(true);
    }

    @Override
    public Encarregado create() {
        Encarregado fornecedor = tela.criar();

            if(tela.isRetornoOk() == false){
                return null;
            }    
            else{

                fornecedor = tela.getScreenObject();
                dao.create(fornecedor);
            }

        model.add(fornecedor);
        return fornecedor;
    }

    @Override
    public void read(Encarregado objeto) {
//        List<Fornecedor> lista = dao.findAll();
//        tela.listar(lista);
        tela.mostrar(objeto);
    }

    @Override
    public Encarregado update(Encarregado objeto) {
        Encarregado forn = tela.editar(objeto);
        Encarregado forn2 = dao.update(forn);
        model.update(forn, forn2);
        return forn2;
    }

    @Override
    public boolean delete(Encarregado objeto) {
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
