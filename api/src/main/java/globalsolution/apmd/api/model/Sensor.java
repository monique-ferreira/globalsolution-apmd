package globalsolution.apmd.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sensores")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tipo;
    private String status;
    private Double leituraAtual;
    private String unidade;
    private Boolean ativo;

    public Sensor() {}

    public Sensor(Long id, String nome, String tipo, String status, Double leituraAtual, String unidade, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.status = status;
        this.leituraAtual = leituraAtual;
        this.unidade = unidade;
        this.ativo = ativo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Double getLeituraAtual() { return leituraAtual; }
    public void setLeituraAtual(Double leituraAtual) { this.leituraAtual = leituraAtual; }
    public String getUnidade() { return unidade; }
    public void setUnidade(String unidade) { this.unidade = unidade; }
    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
