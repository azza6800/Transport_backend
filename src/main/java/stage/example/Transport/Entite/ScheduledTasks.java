package stage.example.Transport.Entite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import stage.example.Transport.Services.ContratService;

@Component
public class ScheduledTasks {

    @Autowired
    private ContratService contratService;
    @Scheduled(cron = "0 0 0 * * *")
    public void verifierContratsExpirés() {
        contratService.fermerContratsExpireAujourdHui();
    }
}
