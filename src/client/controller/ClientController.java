/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.controller;

import db.Client;
import db.Produs;
import rmi.IMainService;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.rmi.RemoteException;
import java.util.Collections;

/**
 *
 * @author Vlad
 */
public class ClientController {
    
    private IMainService mainService;
    private ClientController(){
    try {
    Registry registry=LocateRegistry.getRegistry("localhost",4444);
    mainService=(IMainService)registry.lookup("produsService");
    }catch(Exception e){
    e.printStackTrace();
    }
    
    
    }
    
    
    private static final class SingletonHolder {
    private static final ClientController INSTANCE=new ClientController();
    }
    
    public static ClientController getInstance(){
    return SingletonHolder.INSTANCE;
    }
    
    
    public List<Produs> getAll(){
        try{
    return mainService.getAll();
        }catch(RemoteException e){
        e.printStackTrace();
        }
        return Collections.emptyList();
    }
    
    public void adaugaClientPro(Client client){
    try{
    mainService.adaugaClientPro(client);
    }catch(RemoteException e){
    e.printStackTrace();
    }
    
    
    }
}
