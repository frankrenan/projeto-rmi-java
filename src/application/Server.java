/*
	Autor: Frank Renan, Victor Vasconcelos, Ângelo Henrique
	Assunto: Criptografia aplicando conceitos de RMI
	Data: 10/03/2021
*/
package application;

import java.rmi.Naming;

import entities.Criptografia;
import services.CriptografiaImpl;

public class Server {

	public Server() {
		try {
			Criptografia obj = new CriptografiaImpl();
			Naming.rebind("//localhost/criptoServico", obj);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Server();
	}

}
