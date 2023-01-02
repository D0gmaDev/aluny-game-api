package fr.aluny.gameapi.service;

import fr.aluny.gameapi.anchor.AnchorService;
import fr.aluny.gameapi.chat.ChatService;
import fr.aluny.gameapi.command.CommandService;
import fr.aluny.gameapi.message.MessageService;
import fr.aluny.gameapi.moderation.VanishService;
import fr.aluny.gameapi.player.GamePlayerService;
import fr.aluny.gameapi.player.PlayerAccountService;
import fr.aluny.gameapi.player.rank.RankService;
import fr.aluny.gameapi.scoreboard.ScoreboardService;
import fr.aluny.gameapi.scoreboard.team.ScoreboardTeamService;
import fr.aluny.gameapi.timer.RunnableHelper;
import fr.aluny.gameapi.timer.TimerService;
import fr.aluny.gameapi.translation.TranslationService;
import fr.aluny.gameapi.value.ValueService;
import fr.aluny.gameapi.world.LootModifierService;
import fr.aluny.gameapi.world.SchematicService;

public interface ServiceManager {

    AnchorService getAnchorService();

    ChatService getChatService();

    CommandService getCommandService();

    GamePlayerService getGamePlayerService();

    LootModifierService getLootModifierService();

    MessageService getMessageService();

    PlayerAccountService getPlayerAccountService();

    RankService getRankService();

    SchematicService getSchematicService();

    ScoreboardService getScoreboardService();

    ScoreboardTeamService getScoreboardTeamService();

    TimerService getTimerService();

    TranslationService getTranslationService();

    ValueService getValueService();

    VanishService getVanishService();

    RunnableHelper getRunnableHelper();

}
