package uo;

import java.util.Iterator;
import uo.SPARQL;
import uo.QueryConstants;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;

public class Assg1 {
	
	public static void getPopulationOfCityOfMyFriends(String queryString,Model model) {
		
		String DBPediaQuery="";
		StringBuilder cityTriple=new StringBuilder();
		
		Query query=QueryFactory.create(QueryConstants.prefixString+queryString);		
		QueryExecution queryExecution= QueryExecutionFactory.create(query, model);
		
		try {
			ResultSet results= queryExecution.execSelect();
			System.out.println("Executing SPARQL Query. Please wait...\n\n");
			System.out.println("Query:\n"+ query);
			
			while (results.hasNext()) {				
				QuerySolution querySolution= results.nextSolution();				
				Iterator<String> varNames1= querySolution.varNames();
								while (varNames1.hasNext()) {
					String varName1= varNames1.next();
					String value= querySolution.get(varName1).toString();
					System.out.println(varName1+"\t"+value+"\n");					
					if(cityTriple.length() > 0)
					{
						cityTriple.append(" UNION ");
					}
					cityTriple.append("{<"+querySolution.get(varName1).toString()+"> <http://dbpedia.org/ontology/populationTotal> ?pop. }");					
					
				}				
			}
			DBPediaQuery="select distinct ?pop where { " + cityTriple + "}";
			SPARQL.queryDBPedia(DBPediaQuery, QueryConstants.prefixString2);
			
		}
		finally {
			queryExecution.close();
		}
				
		
	}
	
	

}
