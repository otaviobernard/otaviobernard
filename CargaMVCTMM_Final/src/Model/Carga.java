/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author otávio
 */
@Entity
@Table(name = "tb_carga")
//@SecondaryTables({
//    @SecondaryTable(name = "tb_produto_compra"),
//    @SecondaryTable(name = "tb_produto_comanda")
//})
public class Carga implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cd_carga")
    private Long codigo;
    @Column(name="nomeEmpresa", length = 45)
    private String nome;
    @Column(name="marca", length = 15)
    private String marca;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_tipo")
    private Tipo tipo;

    @Column(name="preco", columnDefinition = "DECIMAL(10,2)", 
            precision=10, scale=2)
    private Double precoCarga;
    @Column(name="peso", length = 10)
    private Integer quantidade;
 

    
    @ManyToMany
    @JoinTable(name = "tb_carga_encarregado",
            joinColumns = @JoinColumn(name = "cd_carga", 
            referencedColumnName = "cd_carga"))
    
    private List<Encarregado> encarregados = new ArrayList<>();
    

    public Carga(String nome, String marca,
           Double precoVenda, Integer quantidade,
           Tipo categoria) {
        this.nome = nome;
        this.marca = marca;
        this.precoCarga = precoVenda;
        this.quantidade = quantidade;
        this.tipo = categoria;
       
    }
    
    
    
    public Carga() {
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    

  

    public Double getPrecoCarga() {
        return precoCarga;
    }

    public void setPrecoCarga(Double precoCarga) {
        this.precoCarga = precoCarga;
    }

    public Integer getQuantidadeAtual() {
        return quantidade;
    }

    public void setQuantidadeAtual(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<Encarregado> getFornecedor() {
        return encarregados;
    }

    public void setFornecedor(List<Encarregado> fornecedores) {
        this.encarregados = fornecedores;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    @Override
    public String toString() {
        return "Id: " + codigo + " | Nome: " + nome;
    }
    
    
//    public List<Comanda> getComandas() {
//        return comandas;
//    }
//
//    public void setComandas(List<Comanda> comandas) {
//        this.comandas = comandas;
//    }

//    public Double getTotalItem() {
//        return totalItem;
//    }
//
//    public void setTotalItem(Double totalItem) {
//        this.totalItem = totalItem;
//    }
    
//    public List<Compra> getCompras() {
//        return compras;
//    }
//
//    public void setCompras(List<Compra> compras) {
//        this.compras = compras;
//    }   

//    public Double getItemTotal() {
//        return itemTotal;
//    }
//
//    public void setItemTotal(Double itemTotal) {
//        this.itemTotal = itemTotal;
//    }

    


    
}
