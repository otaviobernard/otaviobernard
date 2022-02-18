
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author otávio
 */

@Entity
@Table(name = "tb_tipo")
public class Tipo implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cd_tipo")
    @JoinColumn(foreignKey = @ForeignKey(name = "cd_tipo"), referencedColumnName = "cd_tipo")
    private Long codigo;
    @Column(name="tipoNome", length = 40)
    private String nome;

    
    @OneToMany(mappedBy = "tipo")
    @JoinColumn(name = "cd_tipo")
    private List<Carga> tipo;

    public Tipo(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;        
    }

    public Tipo() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   

    public List<Carga> getTipo() {
        return tipo;
    }

    public void setTipo(List<Carga> tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Id: " + codigo + " | Nome: " + nome;
    }
    
    
}
