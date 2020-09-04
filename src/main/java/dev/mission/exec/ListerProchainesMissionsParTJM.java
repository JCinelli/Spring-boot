package dev.mission.exec;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("selectNextWithTJ")
public class ListerProchainesMissionsParTJM implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(ListerProchainesMissions.class);

	private MissionRepository missionRepository;

	public ListerProchainesMissionsParTJM(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {

		List<Mission> listMissionsTodayOrLaterWidthTj = missionRepository
				.findAllMissionsBeginTodayOrLaterWithTJ(BigDecimal.valueOf(100.1));

		if (listMissionsTodayOrLaterWidthTj.isEmpty()) {

			LOG.warn(
					"Aucune missions n'est à prévoir ou aucune mission à venir n'a de taux journallier supérieur à celui passé en paramètre !");

		} else {

			for (Mission mission : listMissionsTodayOrLaterWidthTj) {

				LOG.warn("\r" + mission.toString());

			}

		}

	}

}
