package com.skullzbones.devbeans.Commands;

import com.skullzbones.devbeans.Commands.Beans.BeansExec;
import com.skullzbones.devbeans.Commands.testcommands_remove_this.TestExec;
import com.skullzbones.devbeans.Devbeans;

public class CommandsRegistrar {
    public static void RegisterAllCommands(Devbeans devbeans){
        BeansExec.RegisterMainCommands(devbeans);
        TestExec.RegisterMainCommands(devbeans);  //Test Purposes Uncomment
    }
}
