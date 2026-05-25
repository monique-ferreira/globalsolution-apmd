# Controle de Missão Espacial — Backend

API REST com Spring Boot para controle de missão espacial.

## Integrantes
- Monique Ferreira dos Anjos — RM 558262
- Rafael Augusto Oliveira Silva — RM 555154
- Tiago Brito Nário — RM 558248

## Tecnologias
- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- H2 Database (file mode)
- Maven

## Como executar

```bash
cd api
./mvnw spring-boot:run
```

A API estará disponível em: `http://localhost:8080`
H2 Console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:file:./data/missao`
- User: `sa` | Password: *(vazio)*

## Endpoints

### Sensores (`/sensores`)
| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/sensores` | Lista todos os sensores |
| GET | `/sensores/{id}` | Busca sensor por ID |
| POST | `/sensores` | Cadastra novo sensor |
| PUT | `/sensores/{id}` | Atualiza sensor |
| DELETE | `/sensores/{id}` | Remove sensor |

### Eventos Operacionais (`/eventos`)
| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/eventos` | Lista todos os eventos |
| GET | `/eventos/{id}` | Busca evento por ID |
| POST | `/eventos` | Cadastra novo evento |
| PUT | `/eventos/{id}` | Atualiza evento |
| DELETE | `/eventos/{id}` | Remove evento |

### Alertas Críticos (`/alertas`)
| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/alertas` | Lista todos os alertas |
| GET | `/alertas/{id}` | Busca alerta por ID |
| POST | `/alertas` | Cadastra novo alerta |
| PUT | `/alertas/{id}` | Atualiza alerta |
| DELETE | `/alertas/{id}` | Remove alerta |

## Exemplos de requisições POST

### Sensor
```json
POST /sensores
{
  "nome": "Sensor de Temperatura — Módulo A",
  "tipo": "TEMPERATURA",
  "status": "ATIVO",
  "leituraAtual": 23.5,
  "unidade": "°C",
  "ativo": true
}
```

### Evento Operacional
```json
POST /eventos
{
  "descricao": "Inicialização do sistema de propulsão",
  "sistema": "PROPULSÃO",
  "dataHora": "2026-05-27T10:00:00",
  "tipo": "INICIALIZACAO",
  "status": "CONCLUIDO"
}
```

### Alerta Crítico
```json
POST /alertas
{
  "titulo": "Temperatura elevada no módulo B",
  "descricao": "Temperatura acima do limite operacional",
  "nivel": "ALTO",
  "dataHora": "2026-05-27T10:15:00",
  "resolvido": false
}
```
