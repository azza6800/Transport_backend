package stage.example.Transport.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stage.example.Transport.Entite.Agence;
import stage.example.Transport.Repository.AgenceRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Component
public class AgenceMapperHelper {

    @Autowired
    private AgenceRepository agenceRepository;

    public List<Long> mapAgencesToIds(List<Agence> agences) {
        return agences == null ? null :
                agences.stream().map(Agence::getId).collect(Collectors.toList());
    }

    public List<Agence> mapIdsToAgences(List<Long> ids) {
        return ids == null ? null :
                ids.stream()
                        .map(agenceRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList());
    }
}
