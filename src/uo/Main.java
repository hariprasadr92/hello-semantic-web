package uo;

import java.io.InputStream;
import uo.Assg1;
import uo.QueryConstants;
import uo.SPARQL;


import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		
		SPARQL sparql= new SPARQL();
		System.out.println("Hey! Semantic Web is very interesting !!\n");
				
		/**
		 * Read a turtle file that uses FOAF Ontology 
		 */  //Code to convert RDF to Turtle.
		//FileManager.get().addLocatorClassLoader(Main.class.getClassLoader());
		//Model model1= FileManager.get().loadModel("C:/uo/SWeb/Assignment1/assg1.rdf");
		//model1.write(System.out, "TURTLE");
		
		String inputFile="C:/uo/SWeb/Assignment1/assg1.rdf";
		Model model=ModelFactory.createDefaultModel();
		InputStream in= FileManager.get().open(inputFile);
		if (in == null) {
			throw new IllegalArgumentException("Filenot found");
		}		
		model.read(in,null);
		
		
		//sparql.performQuery(QueryConstants.ASG1_FIND_MY_FRIENDS, model);
		//sparql.performQuery(QueryConstants.ASG1_FIND_MY_COURSES, model);
		//sparql.performQuery(QueryConstants.ASG1_FIND_MY_FRIENDS_GN, model);
		//sparql.performQuery(QueryConstants.ASG1_FIND_MY_FRIENDS_ORG, model);
		//sparql.performQuery(QueryConstants.ASG1_CITY_OF_MY_FRIENDS, model);
		//sparql.performQuery(QueryConstants.ASG1_FRIENDS_FROM_TUB, model);
		//sparql.performQuery(QueryConstants.ASG1_FRIENDS_WHO_DONT_LIVE_IN_MY_CITY, model);	

		
		
		Assg1.getPopulationOfCityOfMyFriends(QueryConstants.ASG1_CITY_OF_MY_FRIENDS,model);
		
		
		//SPARQL.queryDBPedia(QueryConstants.test,"");

		
		
		
		
		
		
	}

}
