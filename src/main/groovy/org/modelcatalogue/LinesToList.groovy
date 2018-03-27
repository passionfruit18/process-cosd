package org.modelcatalogue

class LinesToList {

    static void main(String... args) {

        String x = (new File(LinesToList.class.getClassLoader().getResource('org/modelcatalogue/handpickedNew.txt').toURI())).collect{it}.join("', '")
        println "['$x']"

    }
}
