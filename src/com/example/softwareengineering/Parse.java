package com.example.softwareengineering;

import org.apache.commons.cli.*;

class Parse {
    private Options options = new Options();
    private CommandLine cmdline;
    private String[] arg;

    Parse(String[] arg) {
        options.addOption(new Option("l", "login", true, "Your Login:"));
        options.addOption(new Option("p", "password", true, "Your Password:"));
        options.addOption(new Option("re", "resource", true, "Your Resource:"));
        options.addOption(new Option("ro", "role", true, "Your Role:"));
        options.addOption(new Option("ds", "date_start", true, "Start Date:"));
        options.addOption(new Option("de", "date_end", true, "End Date:"));
        options.addOption(new Option("vol", "volume", true, "Volume: "));
        options.addOption(new Option("h", "help", false, "Help Information:"));
        this.arg = arg;
    }

    Userdata parseCMD() throws ParseException {
        CommandLineParser cmdLinePosixParser = new PosixParser();
        HelpFormatter forhelp = new HelpFormatter();
        Userdata aou = new Userdata();
        try {
            cmdline = cmdLinePosixParser.parse(options, arg);
            if (cmdline.hasOption("l")) {
                aou.setLogin(cmdline.getOptionValue("l"));
                System.out.println("Login: " + aou.getLogin());
            }

            if (cmdline.hasOption("p")) {
                aou.setPassword(cmdline.getOptionValue("p"));
                System.out.println("Password: " + aou.getPassword());
            }

            if (cmdline.hasOption("re")) {
                aou.setResource(cmdline.getOptionValue("re"));
                System.out.println("Resource: " + aou.getResource());
            }
            if (cmdline.hasOption("ro")) {
                aou.setRole(cmdline.getOptionValue("ro"));
                System.out.println("Role: " + aou.getRole());
            }
            if (cmdline.hasOption("ds")) {
                aou.setDateStart(cmdline.getOptionValue("ds"));
                System.out.println("Start Date: " + aou.getDateStart());
            }
            if (cmdline.hasOption("de")) {
                aou.setDateEnd(cmdline.getOptionValue("de"));
                System.out.println("End Date: " + aou.getDateEnd());
            }
            if (cmdline.hasOption("vol")) {
                aou.setVolume(cmdline.getOptionValue("vol"));
                System.out.println("Volume: " + aou.getVolume());
            }
            if (cmdline.hasOption("h")||aou.isEmpty()) {
                printHelp(forhelp);
            }

        } catch (ParseException e) {
            printHelp(forhelp);
        }
        return aou;
    }

    private void printHelp(HelpFormatter forhelp) {
        forhelp.printHelp("HEEELP", "This is help-information", options, "The End");

    }


}

