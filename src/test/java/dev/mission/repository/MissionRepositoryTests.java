package dev.mission.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import dev.mission.entite.Mission;

@DataJpaTest
class MissionRepositoryTests {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	MissionRepository missionRepository;

	@BeforeEach
	void init() {
		// TODO insérer des données avec `entityManager`
		Mission testMission = new Mission();
		testMission.setLibelle("Mission test");
		testMission.setDateDebut(LocalDate.of(2020, 9, 4));
		testMission.setDateFin(LocalDate.of(2020, 10, 2));
		testMission.setTauxJournalier(BigDecimal.valueOf(115.5));
		entityManager.persist(testMission);

		Mission testMission2 = new Mission();
		testMission2.setLibelle("Mission test2");
		testMission2.setDateDebut(LocalDate.of(2020, 4, 9));
		testMission2.setDateFin(LocalDate.of(2020, 5, 22));
		testMission2.setTauxJournalier(BigDecimal.valueOf(100.5));
		entityManager.persist(testMission2);

		Mission testMission3 = new Mission();
		testMission3.setLibelle("Mission test3");
		testMission3.setDateDebut(LocalDate.of(2020, 12, 20));
		testMission3.setDateFin(LocalDate.of(2021, 5, 22));
		testMission3.setTauxJournalier(BigDecimal.valueOf(150.5));
		entityManager.persist(testMission3);
	}

	@Test
	void findByDateDebutGreaterThanEqual() {

		// TODO exécuter la requête
		List<Mission> listMissions = missionRepository.findAllMissionsBeginTodayOrLater();

		// TODO vérifier le résultat
		assertThat(listMissions.size()).isEqualTo(2);

	}

	@Test
	void findByDateDebutGreaterThanEqualAndTauxJournalierGreaterThanEqual() {

		// TODO exécuter la requête
		List<Mission> listMissions = missionRepository
				.findAllMissionsBeginTodayOrLaterWithTJ(BigDecimal.valueOf(120.5));

		// TODO vérifier le résultat
		assertThat(listMissions.size()).isEqualTo(1);
	}
}
