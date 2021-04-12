package persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Funcionario;

public class GravarJSON implements Gravacao{

	@Override
	public boolean gravar(List<Funcionario> funcionarios) {
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    FileWriter writer;
		try {
			writer = new FileWriter("funcionarios.json");
			writer.write(gson.toJson(funcionarios));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    return true;
		
	}

	@Override
	public List<Funcionario> ler() {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader("funcionarios.json"));
			  Type listType = new TypeToken<ArrayList<Funcionario>>(){}.getType();

			    List<Funcionario> lista = new ArrayList<Funcionario>();
			   
			    return lista = new Gson().fromJson(bufferedReader, listType);
			
		} catch (FileNotFoundException e) {
			return null;

		}

		  

	}

}
