package dev.mission.exec;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("selectNext")
public class ListerProchainesMissions implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(ListerProchainesMissions.class);

	private MissionRepository missionRepository;

	public ListerProchainesMissions(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {

		List<Mission> listMissionsTodayOrLater = missionRepository.findAllMissionsBeginTodayOrLater();

		if (listMissionsTodayOrLater.isEmpty()) {

			LOG.warn("Aucune missions n'est à prévoir !");

		} else {

			for (Mission mission : listMissionsTodayOrLater) {

				LOG.warn("\r" + mission.toString());

			}

		}

	}

}
