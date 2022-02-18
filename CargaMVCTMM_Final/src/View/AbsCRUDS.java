
package View;


public abstract class AbsCRUDS<T> extends AbsView implements IViewSimplesCRUD<T> {

   
    public void listar(T[] listas) {
        for (T lista : listas) {
            if (lista != null) {
                this.showMessage(lista.toString());
            }
        }
    }

    @Override
    public void read(T type) {
        this.showMessage(type.toString());
    }
}
