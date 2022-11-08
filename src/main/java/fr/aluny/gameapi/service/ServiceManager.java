package fr.aluny.gameapi.service;

import fr.aluny.gameapi.anchor.AnchorService;
import fr.aluny.gameapi.chat.ChatService;
import fr.aluny.gameapi.command.CommandService;
import fr.aluny.gameapi.message.MessageService;
import fr.aluny.gameapi.player.GamePlayerService;
import fr.aluny.gameapi.player.PlayerService;
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

    PlayerService getPlayerService();

    SchematicService getSchematicService();

    ScoreboardTeamService getScoreboardTeamService();

    TimerService getTimerService();

    TranslationService getTranslationService();

    ValueService getValueService();

    RunnableHelper getRunnableHelper();

}
