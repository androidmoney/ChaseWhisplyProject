package fr.tvbarthel.games.chasewhisply.model.mode;


import fr.tvbarthel.games.chasewhisply.R;

public class GameModeFactory {

	public static final int GAME_TYPE_TUTORIAL = 0x00000000;
	public static final int GAME_TYPE_REMAINING_TIME = 0x00000001;
	public static final int GAME_TYPE_LIMITED_TARGETS = 0x00000002;
	public static final int GAME_TYPE_SURVIVAL = 0x00000003;
	public static final int GAME_TYPE_DEATH_TO_THE_KING = 0x00000004;
	public static final int GAME_TYPE_OVERALL_RANKING = 0x00000005;
	public static final int GAME_TYPE_TWENTY_IN_A_ROW = 0x00000006;
	public static final int GAME_TYPE_MEMORIZE = 0x00000007;

	public static final int GAME_REQUIRED_LEVEL_SURVIVAL_MODE = 5;
	public static final int GAME_REQUIRED_LEVEL_DEATH_TO_THE_KING = 10;
	public static final int GAME_REQUIRED_LEVEL_TWENTY_IN_A_ROW = 15;
	//TODO
	public static final int GAME_REQUIRED_LEVEL_MEMORIZE = 0;

	public static final int GAME_RANK_DESERTER = 0x00000000;
	public static final int GAME_RANK_SOLDIER = 0x00000001;
	public static final int GAME_RANK_CORPORAL = 0x00000002;
	public static final int GAME_RANK_SERGEANT = 0x00000003;
	public static final int GAME_RANK_ADMIRAL = 0x00000004;

	/**
	 * game mode for learn how to play.
	 * Always available and no leaderboard.
	 *
	 * @return
	 */
	public static GameMode createTutorialGame() {
		final GameMode g = new GameModeTutorial();
		g.setType(GAME_TYPE_TUTORIAL);
		g.setRules(R.string.game_mode_tutorial);
		g.setImage(R.drawable.ic_icon_tutorial);
		g.setBonusAvailable(false);
		return g;
	}

	public static GameMode createRemainingTimeGame(int level) {
		final GameMode g = new GameMode();
		g.setType(GAME_TYPE_REMAINING_TIME);
		g.setLevel(level);
		g.setBonusAvailable(true);
		switch (level) {
			case 1:
				g.setRules(R.string.game_mode_time_limited_level_1);
				g.setImage(R.drawable.ic_icon_time_based_game_30_s);
				g.setLeaderboardStringId(R.string.leaderboard_sprint);
				g.setLeaderboardDescriptionStringId(R.string.leaderboard_chooser_time_limited_level_1_description);
				break;

			case 2:
				g.setRules(R.string.game_mode_time_limited_level_2);
				g.setImage(R.drawable.ic_icon_time_based_game_60_s);
				g.setLeaderboardStringId(R.string.leaderboard_60_seconds);
				g.setLeaderboardDescriptionStringId(R.string.leaderboard_chooser_time_limited_level_2_description);
				break;

			case 3:
				g.setRules(R.string.game_mode_time_limited_level_3);
				g.setImage(R.drawable.ic_icon_time_based_game_90_s);
				g.setLeaderboardStringId(R.string.leaderboard_marathon);
				g.setLeaderboardDescriptionStringId(R.string.leaderboard_chooser_time_limited_level_3_description);
				break;

			default:
				g.setRules(R.string.game_mode_remaining_time);
				g.setImage(R.drawable.ghost);
		}
		return g;
	}

/*	public static GameMode createLimitedTargetsGame(int level) {
		final GameMode g = new GameMode() {
			@Override
			public boolean isAvailable(PlayerProfile p) {
				//always available
				return true;
			}
		};
		g.setType(GAME_TYPE_LIMITED_TARGETS);
		g.setLevel(level);
		g.setRules(R.string.game_mode_target_limited);
		g.setImage(R.drawable.ghost_targeted);
		return g;
	}*/

	public static GameMode createSurvivalGame(int level) {
		final GameMode g = new GameModeSurvival();
		g.setType(GAME_TYPE_SURVIVAL);
		g.setLevel(level);
		g.setRules(R.string.game_mode_survival);
		g.setImage(R.drawable.ic_icon_time_based_game_inf);
		g.setLeaderboardStringId(R.string.leaderboard_survival);
		g.setLeaderboardDescriptionStringId(R.string.leaderboard_chooser_survival_description);
		g.setRequiredCondition(GAME_REQUIRED_LEVEL_SURVIVAL_MODE);
		g.setRequiredMessage(R.string.game_mode_survival_required_message);
		g.setBonusAvailable(true);
		return g;
	}

	public static GameMode createKillTheKingGame(int level) {
		final GameMode g = new GameModeDeathToTheKing();
		g.setType(GAME_TYPE_DEATH_TO_THE_KING);
		g.setLevel(level);
		g.setRules(R.string.game_mode_death_to_the_king);
		g.setImage(R.drawable.ic_icon_death_to_the_king);
		g.setLeaderboardStringId(R.string.leaderboard_death_to_the_king);
		g.setLeaderboardDescriptionStringId(R.string.leaderboard_death_to_the_king_description);
		g.setRequiredCondition(GAME_REQUIRED_LEVEL_DEATH_TO_THE_KING);
		g.setRequiredMessage(R.string.game_mode_death_to_the_king_required_message);
		g.setBonusAvailable(false);
		return g;
	}

	public static GameMode createTwentyInARow(int level) {
		final GameMode g = new GameMode();
		g.setType(GAME_TYPE_TWENTY_IN_A_ROW);
		g.setLevel(level);
		g.setRules(R.string.game_mode_twenty_in_a_row);
		g.setImage(R.drawable.ic_mission);
		//TODO
		//g.setLeaderboardStringId();
		//g.setLeaderboardDescriptionStringId();
		g.setRequiredCondition(GAME_REQUIRED_LEVEL_TWENTY_IN_A_ROW);
		g.setRequiredMessage(R.string.game_mode_twenty_in_a_row_required_message);
		return g;
	}

	public static GameMode createMemorize(int level) {
		final GameModeMemorize g = new GameModeMemorize();
		g.setType(GAME_TYPE_MEMORIZE);
		g.setLevel(level);
		g.setRules(R.string.game_mode_memorize);
		g.setImage(R.drawable.ic_mission);
		//TODO
		//g.setLeaderboardStringId();
		//g.setLeaderboardDescriptionStringId();
		g.setRequiredCondition(GAME_REQUIRED_LEVEL_MEMORIZE);
		g.setRequiredMessage(R.string.game_mode_memorize_required_message);
		return g;
	}

	public static GameMode createOverallRanking() {
		final GameMode g = new GameMode();
		g.setType(GAME_TYPE_OVERALL_RANKING);
		g.setImage(R.drawable.ic_icon_overall_ranking);
		g.setLeaderboardStringId(R.string.leaderboard_overall_ranking);
		g.setLeaderboardDescriptionStringId(R.string.leaderboard_overall_ranking_description);
		return g;
	}
}
