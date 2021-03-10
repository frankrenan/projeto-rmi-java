/*
	Autor: Frank Renan, Victor Vasconcelos, Ângelo Henrique
	Assunto: Criptografia aplicando conceitos de RMI
	Data: 10/03/2021
*/
package services;

import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import entities.Criptografia;

public class CriptografiaImpl extends java.rmi.server.UnicastRemoteObject implements Criptografia{

	/**
	 * Versão do código
	 */
	private static final long serialVersionUID = 1L;

	/* 
	 * API MessageDigest do JAVA
     * Biblioteca java.security.MessageDigest
     */
	
	private static MessageDigest md5 = null;
	
	static {
		try {
			md5 = MessageDigest.getInstance("MD5");
		}
		catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}


	public CriptografiaImpl() throws java.rmi.RemoteException{
		super();
	}


	@Override
	public char[] hexCode(byte[] text) throws RemoteException {
		char[] hexOutput = new char[text.length * 2];
        String hexString;

        for (int i = 0; i < text.length; i++) {
            hexString = "00" + Integer.toHexString(text[i]);
            hexString.toUpperCase().getChars(hexString.length() - 2,
                                	hexString.length(), hexOutput, i * 2);
        }
        return hexOutput;
	}


	@Override
	public String criptografar(String mensagem) throws RemoteException {
		 if (md5 != null) {
	            return new String(hexCode(md5.digest(mensagem.getBytes())));
	        }
	        return null;
	}
	
	

}
