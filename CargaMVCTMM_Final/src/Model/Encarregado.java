
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author otávio
 */
@Entity
@Table(name = "tb_encarregado")
public class Encarregado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @JoinColumn(foreignKey = @ForeignKey(name = "cd_encarregado"),
            referencedColumnName = "cd_encarregado")
    @Column(name = "cd_encarregado")
    private Long codigo;
    @Column(name = "nomeEncarregado", length = 40, nullable = true)
    private String nome;
    @Column(name = "cpf", length = 50, nullable = true)
    private String cpf;
    @Column(name = "telefoneEncarregado", length = 50, nullable = true)
    private String telefone;
    @Column(name = "enderecoEncarregado", length = 50, nullable = true)
    private String Endereco;

    
    @ManyToMany(mappedBy = "encarregados", fetch = FetchType.LAZY)   
    @JoinColumn(name = "cd_encarregados")
    private List<Carga> encarregados;
    


  
    public Encarregado() {

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public List<Carga> getEncarregados() {
        return encarregados;
    }

    public void setEncarregados(List<Carga> encarregados) {
        this.encarregados = encarregados;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    @Override
    public String toString() {
        return  "Id: " + codigo + " Nome: " + nome + " RazaoSocial: " + cpf;
    }


    
    

}
