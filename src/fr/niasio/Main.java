package fr.niasio;

import java.io.PrintStream;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin
{
  public ChatColor bold = ChatColor.BOLD;
  
  public void onEnable()
  {
    System.out.println("=============================================================");
    System.out.println(" ");
    getLogger().info(getDescription().getName() + " Plugin allume !\n                        Developpe par Niasio");
    System.out.println(" ");
    System.out.println("=============================================================");
  }
  
  public void onDisable()
  {
    System.out.println("=============================================================");
    System.out.println(" ");
    getLogger().info(getDescription().getName() + " Plugin eteint!\n                         Developpe par Niasio");
    System.out.println(" ");
    System.out.println("=============================================================");
  }
  
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    Player player = (Player)sender;
    if ((command.getName().equalsIgnoreCase("serveurinfo")) && ((sender instanceof Player))) {
      if (args.length == 0)
      {
        String ram = ChatColor.WHITE + " Information RAM";
        String cpu = ChatColor.WHITE + " Information CPU";
        String os = ChatColor.WHITE + " Information OS (Operating System)";
        String java = ChatColor.WHITE + " Information de la version de JAVA";
        String uguale = ChatColor.GREEN + ">";
        
        sender.sendMessage("");
        sender.sendMessage("<>-------------------------------<>");
        sender.sendMessage(ChatColor.RED + "         [" + ChatColor.GREEN + this.bold + "INFO" + ChatColor.YELLOW + "-" + ChatColor.AQUA + this.bold + "SERVEUR" + ChatColor.RED + this.bold + "]");
        sender.sendMessage("<>-------------------------------<>");
        sender.sendMessage(ChatColor.GOLD + "Liste des Commandes");
        sender.sendMessage(ChatColor.YELLOW + "/si Ram " + uguale + ram);
        sender.sendMessage(ChatColor.YELLOW + "/si Cpu " + uguale + cpu);
        sender.sendMessage(ChatColor.YELLOW + "/si OS " + uguale + os);
        sender.sendMessage(ChatColor.YELLOW + "/si Java " + uguale + java);
        sender.sendMessage("<>-------------------------------<>");
      }
      else if (args.length == 1)
      {
        if (args[0].equalsIgnoreCase("ram"))
        {
          if ((player.isOp()) || (player.hasPermission("serveurinfo.ram")) || (player.hasPermission("serveurinfo.*")))
          {
            Runtime runtime = Runtime.getRuntime();
            long freeMemory = runtime.freeMemory();
            long allocatedMemory = runtime.totalMemory();
            long maxMemory = runtime.maxMemory();
            runtime.gc();
            sender.sendMessage("");
            sender.sendMessage("");
            sender.sendMessage(ChatColor.RED + "         [" + ChatColor.GREEN + this.bold + "INFO" + ChatColor.YELLOW + "-" + ChatColor.AQUA + this.bold + "RAM" + ChatColor.RED + this.bold + "]");
            sender.sendMessage("-------------------------------");
            sender.sendMessage(ChatColor.RED + "RAM" + ChatColor.GREEN + "Libre" + ChatColor.YELLOW + "       >" + ChatColor.GOLD + ">" + ChatColor.YELLOW + "> " + freeMemory / 1048576L + ChatColor.YELLOW + " [" + ChatColor.RED + "MB" + ChatColor.YELLOW + "] " + ChatColor.YELLOW + " <" + ChatColor.GOLD + "<" + ChatColor.YELLOW + "<");
            sender.sendMessage("-------------------------------");
            sender.sendMessage(ChatColor.RED + "RAM" + ChatColor.GOLD + "Utilis�e" + ChatColor.YELLOW + " >" + ChatColor.GOLD + ">" + ChatColor.YELLOW + "> " + allocatedMemory / 1048576L + ChatColor.YELLOW + " [" + ChatColor.RED + "MB" + ChatColor.YELLOW + "] " + ChatColor.YELLOW + " <" + ChatColor.GOLD + "<" + ChatColor.YELLOW + "<");
            sender.sendMessage("-------------------------------");
            sender.sendMessage(ChatColor.RED + "RAM" + ChatColor.GOLD + "Max" + ChatColor.YELLOW + "        >" + ChatColor.GOLD + ">" + ChatColor.YELLOW + "> " + maxMemory / 1048576L + ChatColor.YELLOW + " [" + ChatColor.RED + "MB" + ChatColor.YELLOW + "] " + ChatColor.YELLOW + " <" + ChatColor.GOLD + "<" + ChatColor.YELLOW + "<");
            sender.sendMessage("-------------------------------");
          }
          else if ((!player.isOp()) || (!player.hasPermission("serveurinfo.ram")))
          {
            sender.sendMessage(ChatColor.YELLOW + player.getName() + ChatColor.RED + " tu n'as pas la permison " + ChatColor.WHITE + "serveurinfo.ram");
          }
        }
        else if (args[0].equalsIgnoreCase("cpu"))
        {
          if ((player.isOp()) || (player.hasPermission("serveurinfo.cpu")) || (player.hasPermission("serveurinfo.*")))
          {
            Runtime runtime = Runtime.getRuntime();
            String coreofcpu = ChatColor.YELLOW + "Core du CPU";
            String cpubyte = ChatColor.YELLOW + "CPU byte";
            String uguale = ChatColor.RED + " >> ";
            
            sender.sendMessage("");
            sender.sendMessage("");
            sender.sendMessage("-------------------------------");
            sender.sendMessage(ChatColor.RED + "         [" + ChatColor.GREEN + this.bold + "INFO" + ChatColor.YELLOW + "-" + ChatColor.AQUA + this.bold + "CPU" + ChatColor.RED + this.bold + "]");
            sender.sendMessage("-------------------------------");
            sender.sendMessage("");
            sender.sendMessage(coreofcpu + uguale + ChatColor.GREEN + runtime.availableProcessors());
            sender.sendMessage(cpubyte + uguale + ChatColor.GREEN + System.getProperty("sun.cpu.sialist"));
            sender.sendMessage("");
            sender.sendMessage("-------------------------------");
          }
          else if ((!player.isOp()) || (!player.hasPermission("serveurinfo.cpu")))
          {
            sender.sendMessage(ChatColor.YELLOW + player.getName() + ChatColor.RED + " tu n'as pas la permison " + ChatColor.WHITE + "serveurinfo.cpu");
          }
        }
        else if (args[0].equalsIgnoreCase("os"))
        {
          if ((player.isOp()) || (player.hasPermission("serveurinfo.os")) || (player.hasPermission("serveurinfo.*")))
          {
            String os = ChatColor.YELLOW + "Operating System";
            String osarch = ChatColor.YELLOW + "OS Architecture";
            String username = ChatColor.YELLOW + "Pseudo";
            String uguale = ChatColor.RED + " >> ";
            
            sender.sendMessage("");
            sender.sendMessage("-------------------------------");
            sender.sendMessage(ChatColor.RED + "         [" + ChatColor.GREEN + this.bold + "INFO" + ChatColor.YELLOW + "-" + ChatColor.AQUA + this.bold + "OS" + ChatColor.RED + this.bold + "]");
            sender.sendMessage("-------------------------------");
            sender.sendMessage("");
            sender.sendMessage(os + uguale + ChatColor.GREEN + System.getProperty("os.name"));
            sender.sendMessage(username + uguale + ChatColor.GREEN + System.getProperty("user.name"));
            sender.sendMessage(osarch + uguale + ChatColor.GREEN + System.getProperty("os.arch"));
            sender.sendMessage("");
            sender.sendMessage("-------------------------------");
          }
          else if ((!player.isOp()) || (!player.hasPermission("serveurinfo.os")))
          {
            sender.sendMessage(ChatColor.YELLOW + player.getName() + ChatColor.RED + " tu n'as pas la permission " + ChatColor.WHITE + "serveurinfo.os");
          }
        }
        else if (args[0].equalsIgnoreCase("java"))
        {
          if ((player.isOp()) || (player.hasPermission("serveurinfo.java")) || (player.hasPermission("serveurinfo.*")))
          {
            String javaversion = ChatColor.YELLOW + "Version de JAVA ";
            String javahome = ChatColor.YELLOW + "Directoire de JAVA";
            String oracle = ChatColor.YELLOW + "Maison du producteur";
            String jvm = ChatColor.YELLOW + "JVM (Java Virtual Machine)";
            String uguale = ChatColor.RED + " >> ";
            
            sender.sendMessage("-------------------------------");
            sender.sendMessage(ChatColor.RED + "         [" + ChatColor.GREEN + this.bold + "INFO" + ChatColor.YELLOW + "-" + ChatColor.AQUA + this.bold + "JAVA" + ChatColor.RED + this.bold + "]");
            sender.sendMessage("-------------------------------");
            sender.sendMessage("");
            sender.sendMessage(oracle + uguale + ChatColor.GREEN + System.getProperty("java.specification.vendor"));
            sender.sendMessage(jvm + uguale + ChatColor.GREEN + System.getProperty("java.vm.name"));
            sender.sendMessage(javaversion + uguale + ChatColor.GREEN + System.getProperty("java.version"));
            sender.sendMessage(javahome + uguale + ChatColor.GREEN + System.getProperty("java.home"));
            sender.sendMessage("");
            sender.sendMessage("-------------------------------");
          }
          else if ((!player.isOp()) || (!player.hasPermission("serveurinfo.java")))
          {
            sender.sendMessage(ChatColor.YELLOW + player.getName() + ChatColor.RED + " tu n'as pas la permission " + ChatColor.WHITE + "serveurinfo.java");
          }
        }
        else if (args[0].equalsIgnoreCase("help"))
        {
          String ram = ChatColor.WHITE + " Information RAM";
          String cpu = ChatColor.WHITE + " Information CPU";
          String os = ChatColor.WHITE + " Information OS (Operating System)";
          String java = ChatColor.WHITE + " Information de la version de JAVA";
          String uguale = ChatColor.GREEN + ">";
          
          sender.sendMessage("");
          sender.sendMessage("<>-------------------------------<>");
          sender.sendMessage(ChatColor.RED + "         [" + ChatColor.GREEN + this.bold + "INFO" + ChatColor.YELLOW + "-" + ChatColor.AQUA + this.bold + "AIDE" + ChatColor.RED + this.bold + "]");
          sender.sendMessage("<>-------------------------------<>");
          sender.sendMessage(ChatColor.GOLD + "Liste des Commandes");
          sender.sendMessage(ChatColor.YELLOW + "/si Ram " + uguale + ram);
          sender.sendMessage(ChatColor.YELLOW + "/si Cpu " + uguale + cpu);
          sender.sendMessage(ChatColor.YELLOW + "/si OS " + uguale + os);
          sender.sendMessage(ChatColor.YELLOW + "/si Java " + uguale + java);
          sender.sendMessage("<>-------------------------------<>");
        }
        else
        {
          sender.sendMessage(ChatColor.YELLOW + player.getName() + ChatColor.RED + " mauvaise commande, essaye " + ChatColor.GREEN + this.bold + "/si help");
        }
      }
      else
      {
        sender.sendMessage(ChatColor.YELLOW + player.getName() + ChatColor.RED + " mauvaise commande, essaye " + ChatColor.GREEN + this.bold + "/si help");
      }
    }
    return false;
  }
}
