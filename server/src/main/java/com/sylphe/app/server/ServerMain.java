package com.sylphe.app.server;

import java.net.SocketException;

/**
 * Created by myks7 on 2016-03-15.
 */
public class ServerMain {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        RoomManager roomManager = new RoomManager();
        ServerMonitor serverMonitor = new ServerMonitor(roomManager,userManager);
        serverMonitor.start();
        try {
            // create server
            Server server = new Server(roomManager,userManager);
            // add endpoints on all IP addresses
            server.addEndpoints();
            server.start();
        } catch (SocketException e) {
            System.err.println("Failed to initialize server: " + e.getMessage());
        }
    }
}
