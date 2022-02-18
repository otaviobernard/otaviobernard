
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author otávio
 */

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cd_cliente")
    private Long codigo;
    @Column(name="nomeCliente", length = 40)
    private String nome;
    @Column(name="emailCliente", length = 50)
    private String email;
    @Column(name="cpfCliente", length = 14)
    private String cpf;
    


    public Cliente(String nome, String email, String cpf) {
        this(nome, email);
        this.cpf = cpf;
    }

    public Cliente(String nome, String email, String login, String senha) {
        this(login, senha);
        this.email = email;
        this.nome = nome;
    }

    public Cliente(String login, String senha) {
    }
    
    
    
    public Cliente(){
        
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public String toString() {
        return "Id: " + codigo + " | Cpf: "+ cpf + " | nome: " + nome;
    }
    
    
    
}
