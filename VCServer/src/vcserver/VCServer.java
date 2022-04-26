/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vcserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Ashrafi
 */
public class VCServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VCServiceImpl VC_ServiceImpl = null;

        try {
            VC_ServiceImpl = new VCServiceImpl();
        } catch (RemoteException re) {
            System.out.println("Oops! Unable to start up VCService server");
            System.out.println(re);
            System.exit(1);
        }

        int VCSPort = -1;
        String bindName = "";

        System.out.print("Enter Server Name: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            bindName = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read server name!");
            System.exit(1);
        }

        System.out.print("Enter Server Port: ");

        try {
            VCSPort = Integer.valueOf(br.readLine());
        } catch (IOException ioe) {
            System.out.println("IO error trying to read server port!");
            System.exit(1);
        }

        Registry rmiNamingService = null;
        try {
            rmiNamingService = LocateRegistry.createRegistry(VCSPort);
        } catch (RemoteException re) {
            System.out.println("Couldn't create RMI registry!");
            System.out.println(re);
            System.exit(1);
        }
        System.out.println("About to bind " + bindName);
        try {
            rmiNamingService.rebind(bindName, VC_ServiceImpl);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
        System.out.println("VCService server believed to be running");
        System.out.println("Service name : " + bindName);
        System.out.println("RMI registry port : " + VCSPort);
    }

}
