package uo;

public class QueryConstants {
	
	
	public static String prefixString= "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+ 
			"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+ 
			"PREFIX vCard: <http://www.w3.org/2006/vcard/ns#>"+ 
			"PREFIX foaf: <http://xmlns.com/foaf/0.1/>"+ 
			"PREFIX dbr: <http://dbpedia.org/resource/>"+ 
			"PREFIX rel: <http://www.perceive.net/schemas/relationship/>"+ 
			"PREFIX ex: <http://csi5180-example.org/>";
	
	public static String prefixString2=
			"PREFIX p: <http://dbpedia.org/property/>"+
					"PREFIX dbpedia: <http://dbpedia.org/resource/>"+
					"PREFIX category: <http://dbpedia.org/resource/Category:>"+
					"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+
					"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
					"PREFIX geo: <http://www.georss.org/georss/>";	
	
	public static String ASG1_FIND_MY_FRIENDS="select DISTINCT ?fn "+
			"where "+ 
		     "{ "
		   + "ex:Hariprasad foaf:knows ?x . "
		     +"?x vCard:FN ?fn .}"; 
	
	public static String ASG1_FIND_MY_COURSES="select DISTINCT ?c "+
			"where "+ 
		     "{ "
		     + "ex:Hariprasad dbr:Education ?u . "
		     +"?c dbr:Course ?u ."
		     +"ex:Hariprasad dbr:enrollment ?c ."		   
		     + "}"; 	
	public static String ASG1_FIND_MY_FRIENDS_GN="select DISTINCT ?gn "+
			"where "+ 
		     "{ "
		      + "ex:Hariprasad foaf:knows ?x . "
		      +"?x vCard:N ?n ."
		      + "?n vCard:Given ?gn."		   
		     + "}"; 
	
	public static String ASG1_FIND_MY_FRIENDS_ORG="select DISTINCT ?org "+
			"where "+ 
		     "{ "
		      +"ex:Hariprasad foaf:knows ?fr . "
		      +"?fr dbr:Education ?org ."		     		   
		      + "}";
	
	public static String ASG1_CITY_OF_MY_FRIENDS="select DISTINCT ?city "+
			"where "+ 
		     "{ "
		      +"ex:Hariprasad foaf:knows ?fr . "
		      +"?fr vCard:locality  ?city ."		     		   
		      + "}";
	
	
	public static String ASG1_FRIENDS_FROM_TUB="select DISTINCT ?fr "+
			"where "+ 
		     "{ "
		      +"ex:Hariprasad foaf:knows ?fr ."
		      +"?fr dbr:Education dbr:Technical_University_of_Berlin ."		     		   
		      + "}";
	
	
	public static String ASG1_FRIENDS_WHO_DONT_LIVE_IN_MY_CITY="select DISTINCT ?fr "+
			"where "+ 
		     "{ "
		      +"ex:Hariprasad foaf:knows ?fr ."
		      + "?fr vCard:locality ?frndsloc."
		      +"ex:Hariprasad vCard:locality ?myloc."
		      + "FILTER(?frndsloc != ?myloc)"		     		   
		      + "}";
	
	
	
	//public static String test="select distinct ?Concept where {[] a ?Concept} LIMIT 3";
	public static String test="select distinct ?pop where { {" + 
			
			"{ <http://dbpedia.org/resource/Berlin> <http://dbpedia.org/ontology/populationTotal> ?pop.}\r\n" + 
			"UNION\r\n" + 
			"{ <http://dbpedia.org/resource/Tokyo> <http://dbpedia.org/ontology/populationTotal> ?pop.}                       \r\n" + 
			"\r\n" + 
			"\r\n" + 
			"} LIMIT 100";
	
	

}
