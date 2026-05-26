package globalsolution.apmd.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alertas_criticos")
public class AlertaCritico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String nivel;
    private String dataHora;
    private Boolean resolvido;

    public AlertaCritico() {}

    public AlertaCritico(Long id, String titulo, String descricao, String nivel, String dataHora, Boolean resolvido) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.nivel = nivel;
        this.dataHora = dataHora;
        this.resolvido = resolvido;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public String getDataHora() { return dataHora; }
    public void setDataHora(String dataHora) { this.dataHora = dataHora; }
    public Boolean getResolvido() { return resolvido; }
    public void setResolvido(Boolean resolvido) { this.resolvido = resolvido; }
}
