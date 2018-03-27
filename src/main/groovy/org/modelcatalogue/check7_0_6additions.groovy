//import org.modelcatalogue.core.*
//// COSD 7.0.6 check newly added items
//// using data from ProcessCosd
//
//class COSDEntry {
//    String dataItemNo
//    String dataItemSection
//}
//List<COSDEntry> newlyAddedItems = [new COSDEntry(dataItemNo: 'CR6000', dataItemSection: 'CORE - IMAGING (ULTRASOUND)'), new COSDEntry(dataItemNo: 'CR6230', dataItemSection: 'CORE - DIAGNOSIS'), new COSDEntry(dataItemNo: 'CR6490', dataItemSection: 'CORE - DIAGNOSIS'),
//                                   new COSDEntry(dataItemNo: 'CR6400', dataItemSection: 'CORE - DIAGNOSIS'), new COSDEntry(dataItemNo: 'CR6430', dataItemSection: 'CORE - PERSON OBSERVATION'), new COSDEntry(dataItemNo: 'CR6440', dataItemSection: 'CORE - PERSON OBSERVATION'),
//                                   new COSDEntry(dataItemNo: 'CR6450', dataItemSection: 'CORE - PERSON OBSERVATION'), new COSDEntry(dataItemNo: 'CR6460', dataItemSection: 'CORE - PERSON OBSERVATION'), new COSDEntry(dataItemNo: 'CR6470', dataItemSection: 'CORE - CANCER CARE PLAN'),
//                                   new COSDEntry(dataItemNo: 'CR6100', dataItemSection: 'CORE - MOLECULAR AND BIOMARKERS - GERMLINE TESTING FOR CANCER PREDISPOSITION'), new COSDEntry(dataItemNo: 'CR6110', dataItemSection: 'CORE - MOLECULAR AND BIOMARKERS - GERMLINE TESTING FOR CANCER PREDISPOSITION'), new COSDEntry(dataItemNo: 'CR6120', dataItemSection: 'CORE - MOLECULAR AND BIOMARKERS - GERMLINE TESTING FOR CANCER PREDISPOSITION'),
//                                   new COSDEntry(dataItemNo: 'CR6130', dataItemSection: 'CORE - MOLECULAR AND BIOMARKERS - GERMLINE TESTING FOR CANCER PREDISPOSITION'), new COSDEntry(dataItemNo: 'CR6140', dataItemSection: 'CORE - MOLECULAR AND BIOMARKERS - GERMLINE TESTING FOR CANCER PREDISPOSITION'), new COSDEntry(dataItemNo: 'CR6150', dataItemSection: 'CORE - MOLECULAR AND BIOMARKERS - GERMLINE TESTING FOR CANCER PREDISPOSITION'),
//                                   new COSDEntry(dataItemNo: 'CR6160', dataItemSection: 'CORE - MOLECULAR AND BIOMARKERS - SOMATIC TESTING FOR TARGETED THERAPY AND PERSONALISED MEDICINE'), new COSDEntry(dataItemNo: 'CR6170', dataItemSection: 'CORE - MOLECULAR AND BIOMARKERS - SOMATIC TESTING FOR TARGETED THERAPY AND PERSONALISED MEDICINE'), new COSDEntry(dataItemNo: 'CR6180', dataItemSection: 'CORE - MOLECULAR AND BIOMARKERS - SOMATIC TESTING FOR TARGETED THERAPY AND PERSONALISED MEDICINE'),
//                                   new COSDEntry(dataItemNo: 'CR6190', dataItemSection: 'CORE - MOLECULAR AND BIOMARKERS - SOMATIC TESTING FOR TARGETED THERAPY AND PERSONALISED MEDICINE'), new COSDEntry(dataItemNo: 'CR6200', dataItemSection: 'CORE - MOLECULAR AND BIOMARKERS - SOMATIC TESTING FOR TARGETED THERAPY AND PERSONALISED MEDICINE'), new COSDEntry(dataItemNo: 'CR6480', dataItemSection: 'CORE - SURGERY AND OTHER PROCEDURES'),
//                                   new COSDEntry(dataItemNo: 'CR6300', dataItemSection: 'CORE - SURGERY AND OTHER PROCEDURES'), new COSDEntry(dataItemNo: 'CR6010', dataItemSection: 'CORE - SURGERY AND OTHER PROCEDURES'), new COSDEntry(dataItemNo: 'CR6310', dataItemSection: 'CORE - SURGERY AND OTHER PROCEDURES'),
//                                   new COSDEntry(dataItemNo: 'CR6220', dataItemSection: 'CORE - PATHOLOGY DETAILS'), new COSDEntry(dataItemNo: 'CR6490', dataItemSection: 'CORE - PATHOLOGY DETAILS'), new COSDEntry(dataItemNo: 'CR6410', dataItemSection: 'CORE - PATHOLOGY DETAILS'),
//                                   new COSDEntry(dataItemNo: 'CR6490', dataItemSection: 'CORE - PATHOLOGY DETAILS'), new COSDEntry(dataItemNo: 'CR6420', dataItemSection: 'CORE - PATHOLOGY DETAILS'), new COSDEntry(dataItemNo: 'BA3200', dataItemSection: 'CNS - SURGERY & OTHER PROCEDURES'),
//                                   new COSDEntry(dataItemNo: 'BA3210', dataItemSection: 'CNS - SURGERY & OTHER PROCEDURES'), new COSDEntry(dataItemNo: 'CO5400', dataItemSection: 'COLORECTAL - DIAGNOSIS'), new COSDEntry(dataItemNo: 'CT6990', dataItemSection: 'CTYA - DIAGNOSIS'),
//                                   new COSDEntry(dataItemNo: 'CT7020', dataItemSection: 'CTYA - DIAGNOSIS'), new COSDEntry(dataItemNo: 'CT7200', dataItemSection: 'CTYA - DIAGNOSIS - MIXED PHENOTYPE ACUTE LEUKAEMIA'), new COSDEntry(dataItemNo: 'CT7240', dataItemSection: 'CTYA - DIAGNOSIS - PAEDIATRIC MYELODYSPLASIA'),
//                                   new COSDEntry(dataItemNo: 'CT7160', dataItemSection: 'CTYA - DIAGNOSIS - ACUTE MYELOID LEUKAEMIA'), new COSDEntry(dataItemNo: 'CT7170', dataItemSection: 'CTYA - DIAGNOSIS - ACUTE MYELOID LEUKAEMIA'), new COSDEntry(dataItemNo: 'CT7180', dataItemSection: 'CTYA - DIAGNOSIS - ACUTE MYELOID LEUKAEMIA'),
//                                   new COSDEntry(dataItemNo: 'CT7030', dataItemSection: 'CTYA - DIAGNOSIS - LOW GRADE GLIOMA'), new COSDEntry(dataItemNo: 'CT7400', dataItemSection: 'CTYA - DIAGNOSIS - LOW GRADE GLIOMA'), new COSDEntry(dataItemNo: 'CT7260', dataItemSection: 'CTYA - DIAGNOSIS - PAEDIATRIC MYELODYSPLASIA'),
//                                   new COSDEntry(dataItemNo: 'CT7270', dataItemSection: 'CTYA - DIAGNOSIS - PAEDIATRIC MYELODYSPLASIA'), new COSDEntry(dataItemNo: 'CT7380', dataItemSection: 'CTYA - DIAGNOSIS - PAEDIATRIC MYELODYSPLASIA'), new COSDEntry(dataItemNo: 'CT7310', dataItemSection: 'CTYA - DIAGNOSIS - PAEDIATRIC MYELODYSPLASIA'),
//                                   new COSDEntry(dataItemNo: 'CT7150', dataItemSection: 'CTYA - ACUTE LYMPHOBLASTIC LEUKAEMIA '), new COSDEntry(dataItemNo: 'CT7070', dataItemSection: 'CTYA - DIAGNOSIS - NEUROBLASTOMA '), new COSDEntry(dataItemNo: 'CT7000', dataItemSection: 'CTYA - SURGERY AND OTHER PROCEDURES'),
//                                   new COSDEntry(dataItemNo: 'CT7010', dataItemSection: 'CTYA - SURGERY AND OTHER PROCEDURES'), new COSDEntry(dataItemNo: 'CT7110', dataItemSection: 'CTYA - SURGERY AND OTHER PROCEDURES'), new COSDEntry(dataItemNo: 'CT7190', dataItemSection: 'CTYA - SURGERY AND OTHER PROCEDURES - ALL/AML/MPAL'),
//                                   new COSDEntry(dataItemNo: 'CT7390', dataItemSection: 'CTYA - SURGERY AND OTHER PROCEDURES - CNS'), new COSDEntry(dataItemNo: 'CT7370', dataItemSection: 'CTYA - SURGERY AND OTHER PROCEDURES - STEM CELL TRANSPLANTATION'), new COSDEntry(dataItemNo: 'CT7120', dataItemSection: 'CTYA - ACUTE LYMPHOBLASTIC LEUKAEMIA - RESPONSE'),
//                                   new COSDEntry(dataItemNo: 'CT7130', dataItemSection: 'CTYA - ACUTE LYMPHOBLASTIC LEUKAEMIA - RESPONSE'), new COSDEntry(dataItemNo: 'CT7140', dataItemSection: 'CTYA - ACUTE LYMPHOBLASTIC LEUKAEMIA - RESPONSE'), new COSDEntry(dataItemNo: 'CT7050', dataItemSection: 'CTYA - STAGING - NEUROBLASTOMA '),
//                                   new COSDEntry(dataItemNo: 'CT7060', dataItemSection: 'CTYA - STAGING - NEUROBLASTOMA'), new COSDEntry(dataItemNo: 'CT7040', dataItemSection: 'CTYA - LABORATORY RESULTS - GENERAL'), new COSDEntry(dataItemNo: 'CT7320', dataItemSection: 'CTYA - LABORATORY RESULTS - PAEDIATRIC MYELODYSPLASIA '),
//                                   new COSDEntry(dataItemNo: 'CT7330', dataItemSection: 'CTYA - LABORATORY RESULTS - PAEDIATRIC MYELODYSPLASIA '), new COSDEntry(dataItemNo: 'CT7340', dataItemSection: 'CTYA - LABORATORY RESULTS - PAEDIATRIC MYELODYSPLASIA '), new COSDEntry(dataItemNo: 'CT7350', dataItemSection: 'CTYA - LABORATORY RESULTS - PAEDIATRIC MYELODYSPLASIA '),
//                                   new COSDEntry(dataItemNo: 'CT7360', dataItemSection: 'CTYA - LABORATORY RESULTS - PAEDIATRIC MYELODYSPLASIA '), new COSDEntry(dataItemNo: 'CT7080', dataItemSection: 'CTYA - LABORATORY RESULTS - NEUROBLASTOMA '), new COSDEntry(dataItemNo: 'CT7090', dataItemSection: 'CTYA - LABORATORY RESULTS - NEUROBLASTOMA '),
//                                   new COSDEntry(dataItemNo: 'GY7460', dataItemSection: 'GYNAECOLOGY - SURGERY & OTHER PROCEDURES'), new COSDEntry(dataItemNo: 'GY7450', dataItemSection: 'GYNAECOLOGY - PATHOLOGY'), new COSDEntry(dataItemNo: 'LU10300', dataItemSection: 'LUNG - DIAGNOSIS - NLCA'),
//                                   new COSDEntry(dataItemNo: 'LU10310', dataItemSection: 'LUNG - DIAGNOSIS - NLCA'), new COSDEntry(dataItemNo: 'LU10340', dataItemSection: 'LUNG - IMAGING - NLCA'), new COSDEntry(dataItemNo: 'LU10350', dataItemSection: 'LUNG - IMAGING - NLCA'),
//                                   new COSDEntry(dataItemNo: 'LU10360', dataItemSection: 'LUNG - SURGERY AND OTHER PROCEDURES - NLCA'), new COSDEntry(dataItemNo: 'LU10420', dataItemSection: 'LUNG - SURGERY AND OTHER PROCEDURES - LCCOP'), new COSDEntry(dataItemNo: 'LU10370', dataItemSection: 'LUNG - SURGERY AND OTHER PROCEDURES - NLCA'),
//                                   new COSDEntry(dataItemNo: 'LU10390', dataItemSection: 'LUNG - SURGERY AND OTHER PROCEDURES - LCCOP'), new COSDEntry(dataItemNo: 'SK12710', dataItemSection: 'SKIN - DIAGNOSIS - MM '), new COSDEntry(dataItemNo: 'SK12720', dataItemSection: 'SKIN - DIAGNOSIS - MM '),
//                                   new COSDEntry(dataItemNo: 'SK12730', dataItemSection: 'SKIN - DIAGNOSIS - MM '), new COSDEntry(dataItemNo: 'SK12740', dataItemSection: 'SKIN - DIAGNOSIS - MM '), new COSDEntry(dataItemNo: 'SK12700', dataItemSection: 'SKIN - SURGERY AND OTHER PROCEDURES - BCC, SCC & MM '),
//                                   new COSDEntry(dataItemNo: 'SK12510', dataItemSection: 'SKIN - STAGING '), new COSDEntry(dataItemNo: 'UR15400', dataItemSection: 'UROLOGY - STAGING - TESTICULAR')]
//
//List<String> newlyAddedIds = newlyAddedItems.collect{it.dataItemNo}
////List<String> newlyAddedIds = ['CR6000', 'CR6230', 'CR6490', 'CR6400', 'CR6430', 'CR6440', 'CR6450', 'CR6460', 'CR6470', 'CR6100', 'CR6110', 'CR6120', 'CR6130', 'CR6140', 'CR6150', 'CR6160', 'CR6170', 'CR6180', 'CR6190', 'CR6200', 'CR6480', 'CR6300', 'CR6010', 'CR6310', 'CR6220', 'CR6490', 'CR6410', 'CR6490', 'CR6420', 'BA3200', 'BA3210', 'CO5400', 'CT6990', 'CT7020', 'CT7200', 'CT7240', 'CT7160', 'CT7170', 'CT7180', 'CT7030', 'CT7400', 'CT7260', 'CT7270', 'CT7380', 'CT7310', 'CT7150', 'CT7070', 'CT7000', 'CT7010', 'CT7110', 'CT7190', 'CT7390', 'CT7370', 'CT7120', 'CT7130', 'CT7140', 'CT7050', 'CT7060', 'CT7040', 'CT7320', 'CT7330', 'CT7340', 'CT7350', 'CT7360', 'CT7080', 'CT7090', 'GY7460', 'GY7450', 'LU10300', 'LU10310', 'LU10340', 'LU10350', 'LU10360', 'LU10420', 'LU10370', 'LU10390', 'SK12710', 'SK12720', 'SK12730', 'SK12740', 'SK12700', 'SK12510', 'UR15400']
//
//DataModel dm = DataModel.findByNameAndSemanticVersion('Cancer Outcomes and Services Dataset', '7.0.6')
//
//List<DataElement> cosd7des = DataElement.executeQuery("from DataElement de where de.dataModel=:dataModel",
//        [dataModel: dm])
//enum ErrorType {
//    NO_COSD_ID,
//    DATA_ELEMENT_NOT_ADDED,
//    DATA_CLASS_NOT_ADDED,
//    DATA_CLASS_NOT_RIGHT_PARENT,
//    DATA_CLASS_MISSING_DATA_ELEMENTS
//}
//Map<ErrorType,List<String>> errorsInCOSD = [:]
//
//void printError(String error, ErrorType errorType, Map<ErrorType, List<String>> errorsMap) {
//    println error
//    List<String> errors = errorsMap.get(errorType) ?: []
//    errors << error
//    errorsMap.put(errorType, errors)
//
//}
//String cosdId(CatalogueElement ce) {
//    ce.ext['Data Item No'] ?: ce.ext['Data item No.']
//}
//List<String> cosd7deIds = cosd7des.collect {
//
//    String id = cosdId(it)
//    if (!id) {printError("$it does not have COSD id", ErrorType.NO_COSD_ID, errorsInCOSD)}
//    id
//}
//println "\n\n"
//
//
//println "check all data elements were added by COSD id"
//newlyAddedIds.each {id ->
//    if (!(id in cosd7deIds)) {
//        printError("Data Element id $id was not added", ErrorType.DATA_ELEMENT_NOT_ADDED, errorsInCOSD)
//    }
//}
//println "\n\n"
//
//
//String camelize(String source) {
//    StringBuilder stringBuilder = new StringBuilder();
//    boolean nextToUpper = true;
//    for (char c : source.toCharArray()) {
//        if (!Character.isLetterOrDigit(c)) {
//            stringBuilder.append(c)
//            nextToUpper = true;
//            // do not append to builder
//        } else {
//            stringBuilder.append(nextToUpper ? Character.toUpperCase(c)
//                    : Character.toLowerCase(c));
//            nextToUpper = false;
//        }
//    }
//    return stringBuilder.toString();
//}
//
//println "${camelize("HEAD & NECK")}"
//
//String getParentClassName(String dataClassName) {
//
//    Map<String,String> uncamelizedParentClasses = ["UPPER GI": "Upper GI", "CTYA": "CTYA", "CNS": "CNS"]
//    String parentClassName = dataClassName.split(' -')[0]
//    parentClassName = uncamelizedParentClasses[parentClassName] ?: camelize(parentClassName)
//}
//
//Map<String, List<COSDEntry>> newlyAddedItemsBySection = newlyAddedItems.groupBy{it.dataItemSection}
//
//println "check all DataClasses were added, they have the right parents, "
//newlyAddedItemsBySection.each {className, cosdEntries ->
//    DataClass dc = DataClass.findByNameAndDataModel(className, dm)
//    println "found data class ${dc.name}"
//    println dc
//
//    println ''
//    if (!dc) {
//        printError("No data class found with name $className", ErrorType.DATA_CLASS_NOT_ADDED, errorsInCOSD)
//    }
//    else {
//
//        String parentClassName = getParentClassName(className)
//        println "parentClassName: ${parentClassName}"
//        DataClass parentDC = DataClass.findByNameAndDataModel(parentClassName, dm)
//        List<CatalogueElement> parentChildren = parentDC.getOutgoingRelationshipsByType(RelationshipType.hierarchyType)*.destination
//        println "parent's children: ${parentChildren.take(3)}..."
//
//        println ''
//        boolean classHasParent = dc in parentChildren
//
//        if (!classHasParent) {
//            printError("dataClass ${dc} is not child of the right parent", ErrorType.DATA_CLASS_NOT_RIGHT_PARENT, errorsInCOSD)
//        }
//        else {
//            println "data class is child of the parent it is meant to have: ${classHasParent}"
//        }
//
//        List<CatalogueElement> dcDEs = dc.getOutgoingRelationshipsByType(RelationshipType.containmentType)*.destination
//        List<String> dcDECOSDIds = dcDEs.collect{cosdId(it)}
//        cosdEntries.each {
//            if (!(it.dataItemNo in dcDECOSDIds)) {
//                printError("COSD Entry ${it.dataItemNo} not found in its data class ${dc}", ErrorType.DATA_CLASS_MISSING_DATA_ELEMENTS, errorsInCOSD)
//            }
//        }
//    }
//
//    println "===\n\n"
//
//}
//
//println "Errors:"
//ErrorType.values().each {
//    println "ErrorType $it: \n-- ${errorsInCOSD.get(it)?.join('\n-- ')}"
//    println ''
//}
//
//println "${DataClass.findByNameAndDataModel('Core', dm)}"
//// check the appropriate DataClasses have the appropriate DataElements
