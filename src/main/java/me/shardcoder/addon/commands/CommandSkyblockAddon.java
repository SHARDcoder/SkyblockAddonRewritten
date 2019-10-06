package me.shardcoder.addon.commands;

import cc.hyperium.commands.BaseCommand;
import java.util.Collections;
import java.util.List;

public class CommandSkyblockAddon implements BaseCommand {

    @Override
    public String getName() {
        return "skyblockaddon";
    }

    @Override
    public String getUsage() {
        return "/skyblockaddon";
    }

    @Override
    public void onExecute(String[] args) {

    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.singletonList("sba");
    }

    @Override
    public List<String> onTabComplete(String[] args) {
        return Collections.singletonList("skyblockaddon");
    }
}
