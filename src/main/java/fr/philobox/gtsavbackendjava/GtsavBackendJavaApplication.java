package fr.philobox.gtsavbackendjava;

import fr.philobox.gtsavbackendjava.entities.ModelEntity;
import fr.philobox.gtsavbackendjava.entities.SupplierEntity;
import fr.philobox.gtsavbackendjava.repositories.ModelRepository;
import fr.philobox.gtsavbackendjava.repositories.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
@AllArgsConstructor
public class GtsavBackendJavaApplication {
    private SupplierRepository supplierRepository;
    private ModelRepository modelRepository;

    public static void main(String[] args) {
        SpringApplication.run(GtsavBackendJavaApplication.class, args);
    }

    @Bean
    CommandLineRunner start (SupplierRepository supplierRepository, ModelRepository modelRepository) {
        return args -> {
            Stream.of("Mobalpa", "Cuir Center", "Roche Bobois").forEach(name->{
                supplierRepository.save(
                        new SupplierEntity(
                                UUID.randomUUID().toString(),
                                name,
                                new ArrayList<>()
                        )
                );
            });

            List<SupplierEntity> suppliers = supplierRepository.findAll();

            Stream.of("Canapé 2 places", "Fauteuil Gaming", "Canapé d'angle", "Canapé réversible", "Fauteuil massant", "Rocking chair", "Canapé Ariestelle", "Canapé Youcraft", "Canapé Whitenollo", "Xender", "Canapé Dufetty", "Serendy", "Canapé UrbanTrend", "Canapé Freshlyn", "Relique des bois", "Canapé Mightomax", "Grandcrête", "Ollins Et Crochets", "Opus", "Welloweist", "Urbain + Canapé", "Grand canapé Legacy", "Arcanoway", "Canapé Zervino", "Artisanat", "Bois de foin", "Canapé Zomoga", "Canapé Hillscale", "Bois puissant", "En annexe")
                    .forEach(name -> {
                modelRepository.save(
                        new ModelEntity(
                                UUID.randomUUID().toString(),
                                name,
                                suppliers.get((int)(Math.random() * (suppliers.size())))
                        )
                );
            });

        };

    }
}
