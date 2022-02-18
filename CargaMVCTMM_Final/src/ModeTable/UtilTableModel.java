package ModeTable;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author otávio
 */
public abstract class UtilTableModel<T> extends AbstractTableModel{
    
    /* Lista de Estados */
    protected ArrayList<T> lista;

    protected ArrayList<T> listaOriginal;
    
    /* Array de Strings com o nome das colunas. */
    protected String[] columnNames;
    protected Class[] classes;
    
    
    /* Cria um EstadoTableModel vazio */
    public UtilTableModel() {
        this(new ArrayList<T>());
    }
    
    public ArrayList<T> getLista() {
        return lista;
    }
    
    /* Cria um EstadoTableModel carregado com
     * a lista especificada. */
    public UtilTableModel(List<T> l) {
        lista = new ArrayList<>(l);
        listaOriginal = new ArrayList<>(l);
    }

    
    /* Retorna o sÃ³cio da linha especificada. */    
    public T getObjetoLinha(int indiceLinha) {
            if(indiceLinha < lista.size()){
                return lista.get(indiceLinha);
            }
        return null;
    }
    
    /* Retorna a quantidade de linhas. */    
    @Override
    public int getRowCount() {
        // Retorna o tamanho da lista.
        return lista.size();
    }

   /* Retorna a quantidade de colunas. */    
    @Override
    public int getColumnCount() {
        // EstÃ¡ retornando o tamanho do array "colunas".
        // Mas como o array Ã© fixo, vai sempre retornar o mesmo        
        return columnNames.length;
    }

    /* Retorna o nome da coluna no Ã­ndice especificado.
     * Este mÃ©todo Ã© usado pela JTable para saber o texto do cabeÃ§alho. */    
    @Override
    public String getColumnName(int column) {
        // Retorna o conteÃºdo do Array que possui o nome das colunas
        // no Ã­ndice especificado.        
        return columnNames[column];
    }

    /* Retorna a classe dos elementos da coluna especificada.
     * Este mÃ©todo Ã© usado pela JTable na hora de definir o editor da cÃ©lula. */    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // Retorna a classe referente a coluna especificada.
        // Aqui retornar o tipo adequado. As colunas sÃ£o as mesmas
        // que foram especificadas no array "colunas".
        return classes[columnIndex];
    }

    /* Retorna um valor booleano que define se a cÃ©lula em questÃ£o
     * pode ser editada ou nÃ£o.
     * Este mÃ©todo Ã© utilizado pela JTable na hora de definir o editor da cÃ©lula.
     * Neste caso, estarÃ¡ sempre retornando false, nÃ£o permitindo que nenhuma
     * cÃ©lula seja editada. */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }        
            
    ////////////////////////////////////////////////////////////
    // Os mÃ©todos declarados atÃ© aqui foram as implementaÃ§Ãµes //
    // de TableModel, que sÃ£o continuamente utilizados        //
    // pela JTable para definir seu comportamento,            //
    // por isso o nome Table Model (Modelo da Tabela).        //
    //                                                        //
    // A partir de agora, os mÃ©todos criados serÃ£o            //
    // particulares desta classe. Eles serÃ£o Ãºteis            //
    // em algumas situaÃ§Ãµes.                                  //
    ////////////////////////////////////////////////////////////
    
    /* Adiciona um registro. */
    public void add(T objeto) {
        // Adiciona o registro.
        lista.add(objeto);

        // Pega a quantidade de registros e subtrai um para achar
        // o Ãºltimo Ã­ndice. Ã‰ preciso subtrair um, pois os Ã­ndices
        // comeÃ§am pelo zero.
        int ultimoIndice = getRowCount() - 1;

        // Reporta a mudanÃ§a. O JTable recebe a notificaÃ§Ã£o
        // e se redesenha permitindo que visualizemos a atualizaÃ§Ã£o.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    /* Remove a linha especificada. */
    public void remove(T objeto) {
        // Remove o sÃ³cio da linha especificada.  
        int indiceLinhaDeletar = lista.indexOf(objeto);
        if(lista.remove(objeto)){
            // Reporta a mudanÃ§a. O JTable recebe a notificaÃ§Ã£o
            // e se redesenha permitindo que visualizemos a atualizaÃ§Ã£o.
            fireTableRowsDeleted(indiceLinhaDeletar, indiceLinhaDeletar);
        }

    }

    /* Adiciona uma lista de sÃ³cios ao final dos registros. */
    public void addLista(List<T> lista) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        lista.addAll(lista);

        // Reporta a mudanÃ§a. O JTable recebe a notificaÃ§Ã£o
        // e se redesenha permitindo que visualizemos a atualizaÃ§Ã£o.
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
    
    /* Adiciona uma lista de sÃ³cios ao final dos registros. */
    public void setLista(List<T> lista) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        this.lista.clear();
        this.lista.addAll(lista);

        //maximo das duas listas
        
        // Reporta a mudanÃ§a. O JTable recebe a notificaÃ§Ã£o
        // e se redesenha permitindo que visualizemos a atualizaÃ§Ã£o.
        fireTableRowsInserted(0, tamanhoAntigo);
    }    
    
    /* Remove todos os registros. */
    public void limpar() {
        // Remove todos os elementos da lista de sÃ³cios.
        lista.clear();

        // Reporta a mudanÃ§a. O JTable recebe a notificaÃ§Ã£o
        // e se redesenha permitindo que visualizemos a atualizaÃ§Ã£o.
        fireTableDataChanged();
    }
    
    /* Verifica se este table model estÃ¡ vazio. */
    public boolean isEmpty() {
        return lista.isEmpty();
    }
    
    // Metodo chamado pela GUI para alterar um elemento
    public void update(T objetoVelho, T objetoNovo) {
        int index = lista.indexOf(objetoVelho);
        lista.set(index, objetoNovo);
        fireTableRowsUpdated(index, index);
    }

    
    public abstract void filter(String filtro);
    
}