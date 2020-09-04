package dev.mission.exec;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("insert")
public class InsererMission implements Runnable {

	private MissionRepository missionRepository;

	public InsererMission(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {

		Mission mission = new Mission();
		mission.setLibelle("Mission 1");
		mission.setTauxJournalier(new BigDecimal("100.90"));
		mission.setDateDebut(LocalDate.of(2019, 1, 1));
		mission.setDateFin(LocalDate.of(2019, 3, 4));

		this.missionRepository.save(mission);

		Mission mission2 = new Mission();
		mission2.setLibelle("Mission 2");
		mission2.setTauxJournalier(new BigDecimal("125.32"));
		mission2.setDateDebut(LocalDate.of(1996, 8, 27));
		mission2.setDateFin(LocalDate.of(2020, 9, 4));

		this.missionRepository.save(mission2);

		Mission mission3 = new Mission();
		mission3.setLibelle("Mission 3");
		mission3.setTauxJournalier(new BigDecimal("112.99"));
		mission3.setDateDebut(LocalDate.of(2018, 2, 12));
		mission3.setDateFin(LocalDate.of(2018, 6, 22));

		this.missionRepository.save(mission3);

		Mission mission4 = new Mission();
		mission4.setLibelle("Mission 4");
		mission4.setTauxJournalier(new BigDecimal("157.02"));
		mission4.setDateDebut(LocalDate.of(2012, 11, 10));
		mission4.setDateFin(LocalDate.of(2013, 12, 1));

		this.missionRepository.save(mission4);

	}
}
