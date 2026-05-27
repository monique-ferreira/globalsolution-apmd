package globalsolution.apmd.api.dto;

public class MissaoStatusDTO {
    private long totalSensores;
    private long sensoresAtivos;
    private long totalEventos;
    private long eventosAbertos;
    private long totalAlertas;
    private long alertasCriticos;
    private long alertasAbertos;
    private int saudeGeral;

    public MissaoStatusDTO(long totalSensores, long sensoresAtivos,
                           long totalEventos, long eventosAbertos,
                           long totalAlertas, long alertasCriticos,
                           long alertasAbertos, int saudeGeral) {
        this.totalSensores = totalSensores;
        this.sensoresAtivos = sensoresAtivos;
        this.totalEventos = totalEventos;
        this.eventosAbertos = eventosAbertos;
        this.totalAlertas = totalAlertas;
        this.alertasCriticos = alertasCriticos;
        this.alertasAbertos = alertasAbertos;
        this.saudeGeral = saudeGeral;
    }

    public long getTotalSensores() { return totalSensores; }
    public long getSensoresAtivos() { return sensoresAtivos; }
    public long getTotalEventos() { return totalEventos; }
    public long getEventosAbertos() { return eventosAbertos; }
    public long getTotalAlertas() { return totalAlertas; }
    public long getAlertasCriticos() { return alertasCriticos; }
    public long getAlertasAbertos() { return alertasAbertos; }
    public int getSaudeGeral() { return saudeGeral; }
}
