package entities;

/* 
 * 
 * Interface da Criptografia
 *
 * */


public interface Criptografia extends java.rmi.Remote{
	
	public char[] hexCode(byte[] text) throws java.rmi.RemoteException;
	
	public String criptografar(String mensagem) throws java.rmi.RemoteException;

	

}
