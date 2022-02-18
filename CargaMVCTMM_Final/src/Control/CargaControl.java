
package Control;

import java.util.ArrayList;
import Model.Carga;
import java.util.List;
import DAO.EncarregadoDAO;
import DAO.CargaDAO;
import Model.Tipo;
import Model.Encarregado;
import ModeTable.EncarregadoTableModel;
import ModeTable.CargaTableModel;
import TelasGui.CargaGrid;
import TelasGui.CargaTela;
/**
 *
 * @author otávio
 */

public class CargaControl extends AbstractControleSimples<Carga>{

    protected CargaGrid grid;
    private CargaTela tela;
    private TipoControl categoriaController;
    private EncarregadoControl fornecedorController;
    private CargaTableModel model;
    private EncarregadoTableModel fornecedorModel;

//    private List<Fornecedor> lista; 
    
    
    
    public CargaControl(TipoControl categoriaController, EncarregadoControl fornecedorController) {
        dao = new CargaDAO();
//        lista=new ArrayList<>();
        this.fornecedorController = fornecedorController;
        model = new CargaTableModel(dao.findAll());
        fornecedorModel = new EncarregadoTableModel();
        grid = new CargaGrid(null, true, this, model);
        grid.setControle(this);
        this.categoriaController = categoriaController;
        tela = new CargaTela(null, true, fornecedorModel);
       
        
    }
    
    
    
    
    @Override
    public void showInicialScreen() {
        grid.setVisible(true);
    }
    
//    public void fornCombo(){
//        telaForProd.setVisible(true);
//        preecherCbxForn();
//        List<Fornecedor> lista = fornecedorController.getAll();
//        telaForProd.setListaFornecedor(lista);
//    }

    @Override
    public Carga create() {
        fornecedorModel.limpar();
        Carga produto = null;
        preecherCbx();
        List<Tipo> lista = categoriaController.getAll();
        
        tela.setListaCategoria(lista);
        
        preecherCbxForn();
        List<Encarregado> listaForn = fornecedorController.getAll();
        tela.setListaFornecedor(listaForn);
        

        produto = tela.criar();
        
        
        if (produto == null) {
            return null;
        } 
        else {
           //produto = tela.criar();
            dao.create(produto);
            model.add(produto);
            
        }

        return produto;
        
    }

    @Override
    public void read(Carga objeto) {
//        List<Produto> lista = dao.findAll();
//        tela.listar(lista);

        tela.mostrar(objeto);
    }

    @Override
    public Carga update(Carga objeto) {
        
//        //fornecedorModel.setLista(objeto.getFornecedor());
//        preecherCbx();
//        preecherCbxForn();
//        
//        //List<Fornecedor> listaForn = fornecedorController.getAll();
//        //tela.setListaFornecedor(listaForn);        
        Carga prod = tela.editar(objeto);
        Carga prod2 = dao.update(prod);
        model.update(prod, prod2);
        return prod2;
        
        

    }

    @Override
    public boolean delete(Carga objeto) {
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

    public void preecherCbx(){
        List<Tipo> categorias = new ArrayList<>();
        categorias.addAll(this.categoriaController.getAll());
        tela.setListaCategoria(categorias);
    }
    
    public void preecherCbxForn(){
        List<Encarregado> fornecedor = new ArrayList<>();
        fornecedor.addAll(this.fornecedorController.getAll());
        tela.setListaFornecedor(fornecedor);
    }
    


}
