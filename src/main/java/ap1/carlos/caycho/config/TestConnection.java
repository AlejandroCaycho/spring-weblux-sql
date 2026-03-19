package ap1.carlos.caycho.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;

@Configuration
@RequiredArgsConstructor
public class TestConnection implements CommandLineRunner {

    private final DatabaseClient databaseClient;

    @Override
    public void run(String... args) {
        System.out.println("Testing PostgreSQL connection...");

        databaseClient.sql("SELECT 1")
                .fetch()
                .first()
                .doOnSuccess(result -> System.out.println("PostgreSQL connected successfully"))
                .doOnError(error -> System.err.println("Connection error: " + error.getMessage()))
                .subscribe();
    }
}