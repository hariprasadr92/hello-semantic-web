package uo;

import java.util.Iterator;

import javax.swing.text.InternationalFormatter;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.sparql.engine.QueryEngineFactory;

import uo.QueryConstants;

public class SPARQL {
	
		
	public static ResultSet performQuery(String queryString, Model model) {
		
		
		Query query=QueryFactory.create(QueryConstants.prefixString+queryString);
		ResultSet results;
		QueryExecution queryExecution= QueryExecutionFactory.create(query, model);
		
		try {
			results= queryExecution.execSelect();
			System.out.println("Executing SPARQL Query. Please wait...\n\n");
			System.out.println("Query:\n"+ query);
			while (results.hasNext()) {
				QuerySolution querySolution= results.nextSolution();
				
				Iterator<String> varNames= querySolution.varNames();
				while (varNames.hasNext()) {
					String varName= varNames.next();
					String value= querySolution.get(varName).toString();
					System.out.println(varName+"\t"+value+"\n");						
				}				
			}		
			
		}
		finally {
			queryExecution.close();
		}
		return results;
	}
	
	public static void queryDBPedia(String queryString, String prefixString ) {
		
		
		System.out.println("Trying to hit DBPedia..with the query\n");
		// now creating query object
		Query query=QueryFactory.create(prefixString+queryString);
		// initializing queryExecution factory with remote service.
		// **this actually was the main problem I couldn't figure out.**
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
		System.out.println(query);

		//after it goes standard query execution and result processing which can
		// be found in almost any Jena/SPARQL tutorial.
		try {
		    ResultSet results = qexec.execSelect();
		    //System.out.println(results.);
		    while (results.hasNext()) {
				QuerySolution querySolution= results.nextSolution();
				
				Iterator<String> varNames= querySolution.varNames();
				while (varNames.hasNext()) {
					String varName= varNames.next();
					String value= querySolution.get(varName).toString();
					System.out.println(varName+"\t"+value+"\n");						
				}				
			}	
		}
		finally {
		   qexec.close();
		}
	}
	
	
	
	

}
