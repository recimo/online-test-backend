package com.sotis.onlinetest.controller;


import com.sotis.onlinetest.model.Test;
import org.apache.jena.ext.xerces.util.URI;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.impl.ResourceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/triplets")
public class GetTripletsController {
    private static final String QUERY_URL = "http://localhost:3030/jdk8/sparql";
    private static final String PREFIX = "PREFIX owl:<http://www.w3.org/2002/07/owl#>\n" +
            "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>\n" +
            "PREFIX woc:<http://rdf.webofcode.org/woc/>\n" +
            "PREFIX dbr:<http://dbpedia.org/resource/>\n" +
            "PREFIX dul: <http://www.ontologydesignpatterns.org/ont/dul/DUL.owl#>";
    private static final String PREFIX2 = "prefix owl: <http://www.w3.org/2002/07/owl#>\n" +
            "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>";

    public static List<String> classLabels = new ArrayList<>();

    public boolean getTriplets() {
        classLabels.clear();
        //this.diagnosisModels.getDiagnosisModels().clear();
        String selectString = PREFIX2 + "SELECT DISTINCT ?label " + "WHERE { "
                + "	?class a owl:Class." +
                " OPTIONAL { ?class rdfs:label ?label}\n" +
                "  OPTIONAL { ?class rdfs:comment ?description}" +
                "}";
        Query query = QueryFactory.create(selectString);
        try {
            QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);
            ResultSet results = qexec.execSelect();
            ResultSetRewindable resultSetRewindble = ResultSetFactory.copyResults(results);
            qexec.close();
            while (resultSetRewindble.hasNext()) {
                QuerySolution solution = resultSetRewindble.nextSolution();
                //System.out.println("##################################");
                //System.out.println(solution.getLiteral("label"));
                if(solution.getLiteral("label") != null) {
                    String[] parts = solution.getLiteral("label").getString().split("@");
                    classLabels.add(parts[0]);
                }
            }

            return true;
        } catch (Exception e) {
            System.out.println("GRESKA SELECT NAREDBA");
            e.printStackTrace();
        }

        return false;
    }

    @GetMapping("/all")
    public List<String> getAll(){
        getTriplets();
        return classLabels;
    }

}
