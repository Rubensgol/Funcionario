package persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;

public class GravarXML implements Gravacao {

	@Override
	public boolean gravar(List<Funcionario> funcionarios) {
		try{
			FileOutputStream fos = new FileOutputStream("funcionarios.xml", true);
			BufferedOutputStream buff = new BufferedOutputStream(fos);
			XMLEncoder xml = new XMLEncoder(buff);
			xml.writeObject(funcionarios);
			xml.close();
			
			return true;
		}catch (IOException e) {
				return false;
			}
	}

	@Override
	public List<Funcionario> ler() {
		try {
			List<Funcionario> lista = new ArrayList<Funcionario>();
			FileInputStream fis = new FileInputStream("funcionarios.xml");
			BufferedInputStream buff = new BufferedInputStream(fis);
			XMLDecoder xml = new XMLDecoder(buff);
			lista = (List<Funcionario>) xml.readObject();
			xml.close();
		    	return lista;
		    } catch(IOException e) {
		    	System.err.printf("Erro na Abertura do Arquivo: %s. \n", e.getMessage());
		    	return null;
		    }
	}
	
}
