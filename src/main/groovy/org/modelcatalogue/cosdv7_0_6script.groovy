//import org.modelcatalogue.core.*
//import groovy.transform.Immutable
//import org.hibernate.*
//
////SessionFactory sessionFactory = ctx.getBean('sessionFactory')
////Session currentSession = sessionFactory.getCurrentSession()
//
//println "COSD 7.0.6 check newly added items, do deletions, modifications using data from ProcessCosd"
//println "# Check Additions\n=================\n"
//
//class COSDEntry {
//    String dataItemNo
//    String dataItemSection
//}
//
//Object scriptConfig = new Object() {
//    boolean doAdditionChecks = false
//    boolean doDeletions = false
//    boolean doMoveDataClassesToCore = false
//    boolean doNewSectionsInDiseaseGroups = false
//    boolean doRealignSecondLevelSections = true
//    boolean doChangesToEnums = false
//}
//
//// DATA PROCESSED FROM SPREADSHEET
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
//String getCosdId(CatalogueElement ce) {
//    ce?.ext['Data Item No'] ?: ce?.ext['Data item No.']
//}
//List<String> cosd7deIds = cosd7des.collect {
//
//    String id = getCosdId(it)
//    if (!id) {printError("$it does not have COSD id", ErrorType.NO_COSD_ID, errorsInCOSD)}
//    id
//}
//println "\n\n"
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
//println "camelize('HEAD & NECK) should be: 'Head & Neck' and is: '${camelize("HEAD & NECK")}'\n"
//
//String getParentClassName(String dataClassName) {
//
//    Map<String,String> uncamelizedParentClasses = ["UPPER GI": "Upper GI", "CTYA": "CTYA", "CNS": "CNS"]
//    String parentClassName = dataClassName.split(' -')[0]
//    parentClassName = uncamelizedParentClasses[parentClassName] ?: camelize(parentClassName)
//}
//
//if (scriptConfig.doAdditionChecks) {
//    println "## Check all data elements were added by COSD id\n================================================\n"
//    newlyAddedIds.each {id ->
//        if (!(id in cosd7deIds)) {
//            printError("Data Element id $id was not added", ErrorType.DATA_ELEMENT_NOT_ADDED, errorsInCOSD)
//        }
//    }
//    println "\n\n"
//
//
//
//
//
//
//    Map<String, List<COSDEntry>> newlyAddedItemsBySection = newlyAddedItems.groupBy{it.dataItemSection}
//
//    println "## Check all DataClasses were added & they have the right parents\n=================================================================\n"
//    newlyAddedItemsBySection.each {className, cosdEntries ->
//        DataClass dc = DataClass.findByNameAndDataModel(className, dm)
//        println "found data class ${dc.name}"
//        println dc
//
//        println ''
//        if (!dc) {
//            printError("No data class found with name $className", ErrorType.DATA_CLASS_NOT_ADDED, errorsInCOSD)
//        }
//        else {
//
//            String parentClassName = getParentClassName(className)
//            println "parentClassName: ${parentClassName}"
//            DataClass parentDC = DataClass.findByNameAndDataModel(parentClassName, dm)
//            List<CatalogueElement> parentChildren = parentDC.getOutgoingRelationshipsByType(RelationshipType.hierarchyType)*.destination
//            println "parent's children: ${parentChildren.take(3)}..."
//
//            println ''
//            boolean classHasParent = dc in parentChildren
//
//            if (!classHasParent) {
//                printError("dataClass ${dc} is not child of the right parent", ErrorType.DATA_CLASS_NOT_RIGHT_PARENT, errorsInCOSD)
//            }
//            else {
//                println "data class is child of the parent it is meant to have: ${classHasParent}"
//            }
//
//            List<CatalogueElement> dcDEs = dc.getOutgoingRelationshipsByType(RelationshipType.containmentType)*.destination
//            List<String> dcDECOSDIds = dcDEs.collect{getCosdId(it)}
//            cosdEntries.each {
//                if (!(it.dataItemNo in dcDECOSDIds)) {
//                    printError("COSD Entry ${it.dataItemNo} not found in its data class ${dc}", ErrorType.DATA_CLASS_MISSING_DATA_ELEMENTS, errorsInCOSD)
//                }
//            }
//        }
//
//        println "===\n\n"
//
//
//
//    }
//}
//else {
//}
//
//boolean doDeletions = scriptConfig.doDeletions
//println "# Do Deletions: ${doDeletions ? 'Yes' : 'No'}\n====================\n"
//
//// DATA PROCESSED FROM SPREADSHEET
//List<String> itemsToDeleteIds = ['CR0400', 'CR3030', 'CR0530', 'CR3060', 'CR0850', 'CR3070', 'BR4030', 'BR4040', 'BR4060', 'BR4070', 'BR4080', 'BR4090', 'BR4100', 'BR4110', 'BR4130', 'BA3130', 'BA3140', 'BA3110', 'BA3120', 'CO5010', 'CO5020', 'CO5030', 'CO5040', 'CO5060', 'CO5070', 'CO5080', 'CO5090', 'CO5100', 'CO5110', 'CO5120', 'CO5130', 'CO5140', 'CO5150', 'CO5005', 'CO5180', 'CO5230', 'CO5250', 'CT6150', 'CT6320', 'CT6730', 'CT6300', 'GY7330', 'GY7390', 'GY7210', 'GY7250', 'HA8020', 'HA8230', 'HA8690', 'HN9230', 'HN9220', 'HN9210', 'HN9200', 'HN9220', 'HN9200', 'LU10000', 'LU10020', 'LU10010', 'LU10030', 'SA11160', 'SK12020', 'SK12510', 'UG13293', 'UG13235', 'UG13110', 'UG13150', 'UG14190', 'UG13030', 'UG14410', 'UG13320']
//itemsToDeleteIds.each {id ->
//    if (id in cosd7deIds) {
//        println "Item to delete $id found in data model"
//    }
//    else {
//        println "Item to delete $id NOT found in data model"
//
//    }
//}
//
//List<DataElement> dataElementsToDelete = cosd7des.findAll {de ->
//    getCosdId(de) in itemsToDeleteIds
//}
//
///* // for investigative purposes
//DataElement firstToBeDeleted = dataElementsToDelete[0]
//println "firstToBeDeleted's (${firstToBeDeleted.name}) outgoingRelationships: ${firstToBeDeleted.outgoingRelationships}"
//println "firstToBeDeleted's incomingRelationships: ${firstToBeDeleted.incomingRelationships}"
//*/
//
//void deleteCatalogueElement(CatalogueElement ce) {
//    ce.deleteRelationships()
//    ce.delete(flush:true)
//    println "deleted ${ce.id}, COSD ID ${getCosdId(ce)}"
//}
//
//if (doDeletions) {
//    dataElementsToDelete.each {deleteCatalogueElement(it)}
//}
//else {
//    println "Skipping deletions"
//}
//
//println ''
//
//println "# Do Modifications\n==================\n"
//
//// DATA PROCESSED FROM SPREADSHEET
//List<String> dataClassNamesMoveToCore = ['BREAST - PATHOLOGY  ', 'CNS - PATHOLOGY ', 'COLORECTAL - PATHOLOGY',
//                                         'CTYA -  RENAL PATHOLOGY (Paediatric Kidney)', 'GYNAECOLOGY - PATHOLOGY', 'GYNAECOLOGY - PATHOLOGY - CERVICAL',
//                                         'GYNAECOLOGY - PATHOLOGY - ENDOMETRIAL', 'GYNAECOLOGY - PATHOLOGY - FALLOPIAN TUBE, OVARIAN EPITHELIAL and PRIMARY PERITONEAL', 'GYNAECOLOGY - PATHOLOGY - NODES',
//                                         'GYNAECOLOGY - PATHOLOGY -ENDOMETRIAL', 'HEAD & NECK -PATHOLOGY - GENERAL and SALIVARY', 'HEAD & NECK -PATHOLOGY - SALIVARY',
//                                         'HEAD & NECK -PATHOLOGY - VARIOUS', 'LUNG - PATHOLOGY ', 'SARCOMA - PATHOLOGY - SOFT TISSUE',
//                                         'SKIN - GENERAL - BCC, SCC & MM ', 'SKIN - PATHOLOGY - BCC & SCC', 'SKIN - PATHOLOGY - MM',
//                                         'SKIN - PATHOLOGY - SCC', 'SKIN - PATHOLOGY - SCC & MM', 'UPPER GI -  PATHOLOGY - LIVER METS',
//                                         'UPPER GI - PATHOLOGY - OESOPHAGEAL AND STOMACH', 'UPPER GI -PATHOLOGY - OESOPHAGEAL, OG JUNCTION, PANCREAS, BILE DUCT, LCC, LIVER HCC AND LIVER METS', 'UROLOGY - PATHOLOGY - BLADDER',
//                                         'UROLOGY - PATHOLOGY - KIDNEY', 'UROLOGY - PATHOLOGY - PROSTATE', 'UROLOGY - PATHOLOGY - TESTICULAR',
//                                         'UROLOGY- PATHOLOGY - PENIS']
//
//println "## Move DataClasses to Core\n===========================\n"
//if (scriptConfig.doMoveDataClassesToCore) {
//
//    DataClass core = DataClass.findByNameAndDataModel('Core', dm)
//    if (!core) {
//        println "Modifications: No Core DataClass found"
//    }
//    else {
//
//        dataClassNamesMoveToCore.each {dataClassName ->
//            DataClass dataClassToMove = DataClass.findByNameAndDataModel(dataClassName, dm)
//            if (!dataClassToMove) {
//                println "Modifications: Didn't find Data Class with name ${dataClassName}"
//            }
//            else {
//                List<Relationship> parentRs = dataClassToMove.getIncomingRelationshipsByType(RelationshipType.hierarchyType)
//                if (parentRs.size() != 1) {
//                    println "Modifications: Data Class ${dataClassName} has not one but ${parentRs.size()} parents!"
//                }
//                else {
//                    Relationship parentR = parentRs[0]
//                    parentR.source = core
//                    parentR.save(flush:true)
//                    println "Moved DataClass ${dataClassName} to Core"
//                }
//            }
//        }
//    }
//}
//else {
//    println "Skipping modifications: moving DataClasses to Core"
//}
//
//println ''
//
//trait Modification {}
//
//@Immutable
///**
// * e.g. processing ModNewSectionInDiseaseGroup(['CT6230', 'CT6240'], 'DIAGNOSIS') should
// * for each dataElement find the containing dataClass starting with newSectionNamePart1, e.g. "CTYA - ACUTE...",
// * and then create/find a data class involving newSectionNamePart2,
// * e.g. "CTYA - DIAGNOSIS - ACUTE...", and then move the dataElement
// * where CTYA is newSectionNamePart1,
// * DIAGNOSIS is newSectionNamePart2.
// */
//class ModNewSectionInDiseaseGroup implements Modification {
//    List<String> cosdIds
//    String newSectionNamePart1
//    String newSectionNamePart2
//}
//
//@Immutable
///**
// * Change from data class SKIN - PATHOLOGY - MM to (find/create new data class) SKIN - DIAGNOSIS - MM
// * for each cosdId/dataElement
// * where oldSecondLevelSection is '- PATHOLOGY' and newSecondLevelSection is '- DIAGNOSIS'
// */
//class ModRealignSecondLevel implements Modification {
//    List<String> cosdIds
//    String oldSecondLevelSection
//    String newSecondLevelSection
//}
//
//@Immutable
///**
// * Enums changed for entry #cosdId to #newEnums. Erase the old enums and insert the new enums.
// */
//class ModChangesToEnums implements Modification {
//    String cosdId
//    Map<String, String> newEnums
//}
//void saveCatalogueElement(CatalogueElement ce) {
//    try {ce.save(flush:true)
//    }
//    catch (IllegalArgumentException iae) {
//        if (iae.message.matches("Unable to convert.*to JSON")) {
//            // ignore these exceptions
//        }
//        else {
//            throw iae
//        }
//    }
//}
//println "## New Sections for Disease Groups\n==================================\n"
//// DATA PROCESSED FROM SPREADSHEET
//List<ModNewSectionInDiseaseGroup> modNewSectionInDiseaseGroupList = [new ModNewSectionInDiseaseGroup(['HA8270'], 'CTYA', 'DIAGNOSIS'),
//                                                                     new ModNewSectionInDiseaseGroup(['CT6350', 'CT6750', 'CT6380', 'CT6390', 'CT6450', 'CT6230', 'CT6240', 'SA11000', 'SA11010', 'HA8150'], 'CTYA', 'DIAGNOSIS'),
//                                                                     new ModNewSectionInDiseaseGroup(['CT6130', 'CT6140'], 'CTYA', 'SURGERY AND OTHER PROCEDURES'),
//                                                                     new ModNewSectionInDiseaseGroup(['CT6710', 'CT6740', 'CT6770', 'CT6800', 'CT6250', 'CT6330', 'CT6500', 'CT6510', 'CT6590', 'HA8720', 'HA8280', 'HA8290', 'HA8300'], 'CTYA', 'STAGING'),
//                                                                     new ModNewSectionInDiseaseGroup(['CT6310', 'CT6360', 'CT6460', 'CT6530', 'CT6550', 'CT6580', 'CT6520'], 'CTYA', 'LABORATORY RESULTS'),
//                                                                     new ModNewSectionInDiseaseGroup(['HA8720', 'HA8680', 'HA8280', 'HA8290', 'HA8300', 'HA8310'], 'HAEMATOLOGY - STAGING', 'ANN ARBOR'),
//                                                                     new ModNewSectionInDiseaseGroup(['LU10070', 'LU10080'], 'LUNG', 'SURGERY AND OTHER PROCEDURES'),
//                                                                     new ModNewSectionInDiseaseGroup(['UG14210', 'UG14230', 'UG13240', 'UG13590', 'UG13070', 'UG13080'], 'UPPER GI', 'SURGICAL AND OTHER PROCEDURES'),
//                                                                     new ModNewSectionInDiseaseGroup(['UG14290', 'UG13090', 'UG13250'], 'UPPER GI', 'SURGERY AND OTHER PROCEDURES'),
//                                                                     new ModNewSectionInDiseaseGroup(['UG13560', 'UG13580'], 'UPPER GI', 'TREATMENT'),]
//// TODO: process these according to comment above class definition
//
//if (scriptConfig.doNewSectionsInDiseaseGroups) {
//    DataElement de = null
//    for (ModNewSectionInDiseaseGroup modNewSection: modNewSectionInDiseaseGroupList) {
//        for (String cosdId: modNewSection.cosdIds) {
//            de = cosd7des.find {getCosdId(it) == cosdId}
//            if (de) {
//                println "-- Data Element ${de.name} with cosdID ${cosdId}"
//                List<Relationship> containingRs = de.getIncomingRelationshipsByType(RelationshipType.containmentType)
//                containingRs.each {println "----- '${it.source.name}' contains data element"}
//
//
//                // find the data class matching newSectionNamePart1
//                String onePartPrefix = "${modNewSection.newSectionNamePart1}"
//                Relationship containingRelationship = containingRs.find({it?.source.name.matches(/${onePartPrefix}.*/)})
//                DataClass containingDC = (DataClass) containingRelationship?.source
//                if (containingDC) {
//                    println "-- found containingDC with name '${containingDC.name}' matching onePartPrefix '${onePartPrefix}'"
//
//                    String twoPartPrefix = "${modNewSection.newSectionNamePart1} - ${modNewSection.newSectionNamePart2}"
//                    println "-- twoPartPrefix: '${twoPartPrefix}'"
//
//                    if (containingDC.name.matches("${twoPartPrefix}.*")) {
//                        println "-- Data Element already in new section data class whose name matches twoPartPrefix '${twoPartPrefix}'"
//                    }
//                    else {
//                        String newSectionDataClassName = containingDC.name.replaceAll(/${onePartPrefix}/, twoPartPrefix)
//                        DataClass newSectionDataClass = DataClass.findByNameAndDataModel(newSectionDataClassName, dm)
//                        /*try {
//                             newSectionDataClass = currentSession.merge(DataClass.findByNameAndDataModel(newSectionDataClassName, dm))
//                        }
//                        catch (IllegalArgumentException iae) {
//                            if (iae.message.matches("attempt to create merge event.*")) {
//                                newSectionDataClass = null
//                            }
//                            else {
//                                throw iae
//                            }
//                        }*/
//
//                        if (newSectionDataClass) {
//                            println "-- Found newSectionDataClass with name '${newSectionDataClassName}'"
//
//                        }
//                        else {
//                            println "-- Didn't find newSectionDataClass with name '${newSectionDataClassName}', creating new"
//                            newSectionDataClass = new DataClass(name: newSectionDataClassName, dataModel: dm)
//
//                            saveCatalogueElement(newSectionDataClass)
//
//                            println "Adding ${newSectionDataClass.name} to the right parent"
//                            DataClass parentDC = containingDC.getIncomingRelationshipsByType(RelationshipType.hierarchyType)[0].source
//                            newSectionDataClass.addToChildOf(parentDC)
//                            saveCatalogueElement(newSectionDataClass)
//
//                        }
//                        println "-- Changing relationship to have newSectionDataClass as source"
//                        containingRelationship.source = newSectionDataClass
//
//                    }
//
//                    println ''
//                }
//                else {
//                    println "-- No containing DC matching ${modNewSection.newSectionNamePart1} found"
//                }
//
//
//
//
//
//            }
//            else {
//                println "Data Element ${cosdId} not found"
//            }
//            println '==============\n'
//        }
//    }
//}
//else {
//    println "Skipping modifications: newSectionsInDiseaseGroups"
//}
//println ''
//
//
//println "## Realign Second Level Sections\n==================================\n"
//
//// DATA PROCESSED FROM SPREADSHEET
//List<ModRealignSecondLevel> modRealignSecondLevelList = [new ModRealignSecondLevel(['SK12450'], '- PATHOLOGY', '- DIAGNOSIS'),
//                                                         new ModRealignSecondLevel(['SK12030'], '- GENERAL', '- DIAGNOSIS'),
//                                                         new ModRealignSecondLevel(['SK12010'], '- GENERAL', '- SURGERY AND OTHER PROCEDURES'),
//                                                         new ModRealignSecondLevel(['CR0510'], '- CANCER CARE PLAN', '- DIAGNOSIS'),
//                                                         new ModRealignSecondLevel(['SK12030'], '- GENERAL', '- DIAGNOSIS'),
//                                                         new ModRealignSecondLevel(['SK12450'], '- PATHOLOGY', '- DIAGNOSIS'),
//                                                         new ModRealignSecondLevel(['UG13100', 'UG13810'], '-SURGICAL PROCEDURES', '- SURGICAL AND OTHER PROCEDURES'),
//]
//// TODO: process these according to comment above class definition
//
//if (scriptConfig.doRealignSecondLevelSections) {
//    DataElement de = null
//    for (ModRealignSecondLevel modRealignSecondLevel: modRealignSecondLevelList) {
//        for (String cosdId: modRealignSecondLevel.cosdIds) {
//            de = cosd7des.find {getCosdId(it) == cosdId}
//            if (de) {
//                println "-- Data Element ${de.name} with cosdID ${cosdId}"
//                List<Relationship> containingRs = de.getIncomingRelationshipsByType(RelationshipType.containmentType)
//                containingRs.each {println "----- '${it.source.name}' contains data element"}
//
//
//                // find the data class matching newSectionNamePart1
//                String oldSecondLevel = "${modRealignSecondLevel.oldSecondLevelSection}"
//                Relationship containingRelationship = containingRs.find({it?.source.name.matches(/.*${oldSecondLevel}.*/)})
//                DataClass containingDC = (DataClass) containingRelationship?.source
//                if (containingDC) {
//                    println "-- found containingDC with name '${containingDC.name}' matching oldSecondLevel '${oldSecondLevel}'"
//
//                    String newSectionDataClassName = containingDC.name.replaceAll(/${oldSecondLevel}/, modRealignSecondLevel.newSecondLevelSection)
//                    DataClass newSectionDataClass = DataClass.findByNameAndDataModel(newSectionDataClassName, dm)
//
//
//                    if (newSectionDataClass) {
//                        println "-- Found newSectionDataClass with name '${newSectionDataClassName}'"
//
//                    }
//                    else {
//                        println "-- Didn't find newSectionDataClass with name '${newSectionDataClassName}', creating new"
//                        newSectionDataClass = new DataClass(name: newSectionDataClassName, dataModel: dm)
//
//                        saveCatalogueElement(newSectionDataClass)
//
//                        println "Adding ${newSectionDataClass.name} to the right parent"
//                        DataClass parentDC = containingDC.getIncomingRelationshipsByType(RelationshipType.hierarchyType)[0].source
//                        newSectionDataClass.addToChildOf(parentDC)
//                        saveCatalogueElement(newSectionDataClass)
//
//                    }
//                    println "-- Changing relationship to have newSectionDataClass as source"
//                    containingRelationship.source = newSectionDataClass
//
//
//
//                    println ''
//                }
//                else {
//                    println "-- No containing DC matching ${oldSecondLevel} found"
//                }
//
//
//
//
//
//            }
//            else {
//                println "Data Element ${cosdId} not found"
//            }
//            println '==============\n'
//        }
//    }
//}
//else {
//    println "Skipping modifications: realign second level sections"
//}
//println ''
//
//println "## Changes to Enums\n===================\n"
//
//
//// DATA PROCESSED FROM SPREADSHEET
//List<ModChangesToEnums> modChangesToEnumsList = [new ModChangesToEnums('BA3070', ['06':'Evidence of ALK rearrangement', '07':'Evidence of native ALK', '08':'Evidence of ATRX mutation', '09':'Evidence of wt ATRX', '10':'Evidence of BRAF V600E mutation', '11':'Evidence of wt BRAF', '12':'Evidence of KIAA1549-BRAF fusion', '13':'Evidence of BRAF/RAF1 mutations, or fusions involving genes other than KIAA1549', '14':'Evidence of C11orf95-RELA fusion', '15':'Evidence of native C11orf95 and RELA',
//                                                                                  '16':'Evidence of amplification or fusion of C19MC locus (chr.19q13.42)', '17':'Evidence of unaltered C19MC locus (chr.19q13.42)', '18':'Evidence of CDK4/6 amplification', '19':'Evidence of CDK4/6 normal copy number', '20':'Evidence of CDKN2A locus homozygous deletion', '21':'Evidence of CDKN2A locus normal copy number', '22':'Evidence of CCND1/2/3 amplification', '23':'Evidence of CCND1/2/3 normal copy number', '24':'Evidence of CTNNB1 mutation ', '25':'Evidence of wt CTNNB1',
//                                                                                  '26':'Evidence of amplification of EGFR ', '27':'Evidence of mutation / rearrangement of EGFR', '28':'Evidence of unaltered EGFR', '29':'Evidence of EWSR1-FLI1 fusion', '30':'Evidence of native EWSR1 and FLI1', '31':'Evidence of FGFR1 mutation / rearrangement / fusion', '32':'Evidence of unaltered FGFR1', '33':'Evidence of H3F3A/H3F3B (H3.3) K27M mutation', '34':'Evidence of H3F3A/H3F3B (H3.3) wt K27', '35':'Evidence of H3F3A/H3F3B (H3.3) G34R/V mutation',
//                                                                                  '36':'Evidence of H3F3A/H3F3B (H3.3) wt G34', '37':'Evidence of HIST1H3B K27M mutation', '38':'Evidence of HIST1H3B wt K27', '39':'Evidence of HIST1H3C K27M mutation', '40':'Evidence of HIST1H3C wt K27', '41':'Evidence of ID2 amplification', '42':'Evidence of ID2 normal copy number', '43':'IDH1 (codon 132) or IDH2 (codon 172) mutation identified', '44':'IDH1 (codon 132) and IDH2 (codon 172) wt confirmed', '45':'Evidence of KLF4 K409Q and TRAF7 mutations',
//                                                                                  '46':'Evidence of wt KLF4 and TRAF7', '47':'Evidence of MAP2K1 mutation', '48':'Evidence of wt MAP2K1 ', '49':'Evidence of MET amplification', '50':'Evidence of MET normal copy number ', '51':'Evidence of significant MGMT promoter methylation', '52':'Evidence of unmethylated MGMT promoter', '53':'Evidence of MYC/MYCN amplification', '54':'Evidence of MYC/MYCN normal copy number ', '55':'Evidence of NF1 biallelic loss / mutation',
//                                                                                  '56':'Evidence of unaltered NF1', '57':'Evidence of NF2 biallelic loss / mutation', '58':'Evidence of unaltered NF2', '59':'Evidence of NKTR fusions ', '60':'Evidence of native NKTR', '61':'Evidence of PTEN biallelic loss / mutation', '62':'Evidence of unaltered PTEN', '63':'Evidence of SDHB or SDHD mutation', '64':'Evidence of wt SDHB and SDHD', '65':'Evidence of SHH pathway activation',
//                                                                                  '66':'Evidence of normal SHH pathway', '67':'Evidence of inactivation of SMARCB1 (INI1)', '68':'Evidence of wt SMARCB1 (INI1)', '69':'Evidence of inactivation of SMARCA4 ', '70':'Evidence of wt SMARCA4 ', '71':'Evidence of TERT promotor mutation ', '72':'Evidence of wt TERT promotor', '73':'Evidence  of TP53 mutation ', '74':'Evidence of wt TP53', '75':'Evidence of TSC1 or TSC2 mutation',
//                                                                                  '76':'Evidence of wt TSC1 and TSC2', '77':'Evidence of VHL mutation', '78':'Evidence of wt VHL gene', '79':'Evidence of WNT pathway activation', '80':'Evidence of normal WNT pathway', '81':'Evidence of WWTR1-CAMTA1 fusion', '82':'Evidence of native WWTR1 and CAMTA1 ', '83':'Evidence of codeletion of chr.1p and chr.19q', '84':'Evidence of total chr.1p loss but normal copy number of chr.19q', '85':'Evidence of normal copy number of both chr.1p and chr.19q',
//                                                                                  '86':'Evidence of monosomy chr.6', '87':'Evidence of chr.6 normal copy number', '88':'Evidence of polysomy chr.7', '89':'Evidence of chr.7 normal copy number', '90':'Evidence of loss of chr.10 or chr.10q', '91':'Evidence of chr.10 normal copy number', '92':'Evidence of loss of chr.22 or chr.22q', '93':'Evidence of chr.22 or chr.22q normal copy number', '98':'Other', '99':'Not Known (Not Recorded)']),
//                                                 new ModChangesToEnums('GY7280', ['P':'Positive ', 'N':'Negative', 'X':'Not sent/Not assessable']),
//                                                 new ModChangesToEnums('HA8270', ['1':'CNS1 ( without blasts)', '2':'CNS2 (< 5 WBC in the CSF with blasts)', '3':'CNS3 (≥5 WBC in the CSF with blasts)', '4':'Testes', '9':'Other']),
//                                                 new ModChangesToEnums('LU10090', ['3':'Failed analysis', '4':'Not assessed', '5':'Wild type/non-sensitising mutation ', '6':'Sensitising/activating mutation ']),
//                                                 new ModChangesToEnums('SK12010', ['NU':'NURSE', 'TS':'TRAINEE SPECIALIST DOCTOR', 'CS':'CONSULTANT SURGEON (other than Plastic Surgeon)', 'CD':'CONSULTANT DERMATOLOGIST', 'CPS':'CONSULTANT PLASTIC SURGEON', 'HP':'HOSPITAL PRACTITIONER', 'SI':'GP WITH SPECIAL INTEREST', 'GP':'GENERAL PRACTITIONER', 'OO':'OTHER']),
//                                                 new ModChangesToEnums('CR3170', ['1':'Male', '2':'Female', '9':'Indeterminate (Unable to be classified as either male or female) ', 'X':'Not Known (PERSON STATED GENDER CODE not recorded)']),
//]
//// TODO: process these according to comment above class definition
//
//if (scriptConfig.doChangesToEnums) {
//
//    for (ModChangesToEnums modChangesToEnums: modChangesToEnumsList) {
//        String cosdId = modChangesToEnums.cosdId
//        DataElement de = cosd7des.find({getCosdId(it) == cosdId})
//        if (de) {
//            println "Data Element ${de.name} found with id ${cosdId}"
//            // WRONG:
//            //de.ext = modChangesToEnums.newEnums
//            //de.save(flush:true)
//            if (de?.dataType instanceof EnumeratedType) {
//                EnumeratedType eT = (EnumeratedType) de.dataType
//                eT.setEnumerations(modChangesToEnums.newEnums)
//                saveCatalogueElement(eT)
//                println "EnumeratedType modified"
//            }
//            else {
//                println "${cosdId} data element does not have an enumeratedType, please make one"
//            }
//        }
//        else {
//            println "Data Element with id ${cosdId} not found"
//        }
//    }
//}
//else {
//    println "Skipping Changes to Enums"
//}
//println ''
//
//println """
//## Things which must be done manually:
//======================================
//
//Change GY7220's schema spec to Optional
//Change CR3040's schema spec to Optional
//Change CR3050's schema spec to Optional
//
//Must do [CR0020] manually. Comment: format 'max an20'
//Must do [CR0180] manually. Comment: Data Dictionary Name change to 'MORPHOLOGY (ICD-O DIAGNOSIS)'
//Must do [CR3160] manually. Comment: format 'max an60'
//Must do [CR2070] manually. Comment: description changed to 'The AJCC (Skin) or UICC edition number used for Tumour, Node and Metastasis (TNM) staging for cancer diagnosis.'
//Must do [CT6560, CT6760] manually. Comment: section, name, description, national codes
//Must do [CT6360] manually. Comment: make data class 'CTYA -LABORATORY RESULTS - RHABDOMYOSARCOMA and OTHER SOFT TISSUE SARCOMAS'. Yes, you have to introduce a typo.
//Must do [HA8660] manually. Comment: data type 'Range 0.0 to 999.9  (to 1dp)'
//Must do [HA8240, HA8700, HA8560, HA8710] manually. Comment: Changes not listed in SUBSTANTIAL/COSMETIC CHANGES but under Haematology! They missed this out...
//Must do [SK12630] manually. Comment: Description changed to 'Breslow thickness in mm, can be recorded to nearest 0.01mm where clinically appropriate'
//Must do [UR15100, UR15110] manually. Comment: descriptions changed
//Must do [UG14210, UG14230, UG13240, UG13590] manually. Comment: Script messed these up
//Unclear what to do with [SA11120, SA11170, SA11130, SA11140]
//"""
//
//println "# Errors:\n=======\n"
//ErrorType.values().each {
//    println "ErrorType $it: \n-- ${errorsInCOSD.get(it)?.join('\n-- ')}"
//    println ''
//}
//
//grailsApplication.SESSION_FACTORY_BEAN