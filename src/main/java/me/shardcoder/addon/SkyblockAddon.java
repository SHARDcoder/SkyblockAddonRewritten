package me.shardcoder.addon;

import cc.hyperium.Hyperium;
import cc.hyperium.event.EventBus;
import cc.hyperium.event.InitializationEvent;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.TickEvent;
import cc.hyperium.internal.addons.IAddon;
import me.shardcoder.addon.commands.CommandSkyblockAddon;
import me.shardcoder.addon.config.Config;
import me.shardcoder.addon.utils.MagmaBossTimer;

public class SkyblockAddon implements IAddon {
    private int ticksSince = 0;

    MagmaBossTimer magmaBossTimer = new MagmaBossTimer();




    @Override
    public void onLoad() {
        EventBus.INSTANCE.register(this);

        System.out.println("[SB addon] Loaded");


        //test
        System.out.println("[SB addon] MagmaTimer - ".concat(magmaBossTimer.getRemTimeReadable()));
    }

    @Override
    public void onClose() {

        System.out.println("[SB addon] Closed");
    }

    @Override
    public void sendDebugInfo() {
    }

    @InvokeEvent
    public void init(InitializationEvent event) {
        Hyperium.CONFIG.register(new Config());

        Hyperium.INSTANCE.getHandlers().getCommandHandler().registerCommand(new CommandSkyblockAddon());

    }

    @InvokeEvent
    public void tickEvent(TickEvent event) {


        //every second
        ticksSince++;
        if (ticksSince == 20) {
            ticksSince = 0;
            System.out.println("[SB addon] MagmaTimer - ".concat(magmaBossTimer.getRemTimeReadable()));
        }
    }
}
