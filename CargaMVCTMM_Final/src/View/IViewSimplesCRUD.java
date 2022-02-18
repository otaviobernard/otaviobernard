
package View;

import java.util.List;

public interface IViewSimplesCRUD<T>{

    public T criar();

    public void mostrar(T type);

    public T editar(T salvar);

    public boolean excluir(T deletar);

    public void listar(List<T> listas);
    
    public void read(T Type);

}
