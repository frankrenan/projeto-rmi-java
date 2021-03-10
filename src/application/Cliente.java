/*
	Autor: Frank Renan, Victor Vasconcelos, Ângelo Henrique
	Assunto: Criptografia aplicando conceitos de RMI
	Data: 10/03/2021
*/
package application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import entities.Criptografia;

public class Cliente {

	public static void main(String[] args) {

		String mensagem, cript = "";

		int opcao = JOptionPane.showConfirmDialog(null, "Pressione Yes para Proceder" + "\nNo para fechar",
				"Escolha uma Opção", 0);

		try {
			Criptografia cripto = (Criptografia) Naming.lookup("//localhost/" + "criptoServico");

			if (opcao == 0) {
				mensagem = JOptionPane.showInputDialog("Entre com a mensagem que deseja Criptografar para MD5:");
				cript = cripto.criptografar(mensagem);
				System.out.println(cripto.criptografar(mensagem));
			} else {
				System.exit(0);
			}
		} catch (RemoteException re) {
			re.printStackTrace();
		} catch (NotBoundException no) {
			no.printStackTrace();
		} catch (MalformedURLException ma) {
			ma.printStackTrace();
		}

		JTextArea outputArea = new JTextArea();
		outputArea.setText(cript);

		JOptionPane.showMessageDialog(null, outputArea, "Mensagem Criptografada", JOptionPane.INFORMATION_MESSAGE);

	}

}
