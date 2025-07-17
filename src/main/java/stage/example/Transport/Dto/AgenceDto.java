package stage.example.Transport.Dto;

import java.util.List;

public class AgenceDto {
    private Long id;
    private Long codeAgence;
    private List<Long> clientIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodeAgence() {
        return codeAgence;
    }

    public void setCodeAgence(Long codeAgence) {
        this.codeAgence = codeAgence;
    }

    public List<Long> getClientIds() {
        return clientIds;
    }

    public void setClientIds(List<Long> clientIds) {
        this.clientIds = clientIds;
    }
}
