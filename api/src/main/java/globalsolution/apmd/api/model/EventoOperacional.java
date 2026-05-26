package globalsolution.apmd.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "eventos_operacionais")
public class EventoOperacional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String sistema;
    private String dataHora;
    private String tipo;
    private String status;

    public EventoOperacional() {}

    public EventoOperacional(Long id, String descricao, String sistema, String dataHora, String tipo, String status) {
        this.id = id;
        this.descricao = descricao;
        this.sistema = sistema;
        this.dataHora = dataHora;
        this.tipo = tipo;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getSistema() { return sistema; }
    public void setSistema(String sistema) { this.sistema = sistema; }
    public String getDataHora() { return dataHora; }
    public void setDataHora(String dataHora) { this.dataHora = dataHora; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
