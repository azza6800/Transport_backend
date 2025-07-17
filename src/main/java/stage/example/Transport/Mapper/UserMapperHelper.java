package stage.example.Transport.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stage.example.Transport.Entite.User;
import stage.example.Transport.Repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Component
public class UserMapperHelper {

    @Autowired
    private UserRepository userRepository;

    public List<Long> mapUsersToIds(List<User> users) {
        return users == null ? null :
                users.stream().map(User::getId).collect(Collectors.toList());
    }

    public List<User> mapIdsToUsers(List<Long> ids) {
        return ids == null ? null :
                ids.stream()
                        .map(userRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList());
    }
}
