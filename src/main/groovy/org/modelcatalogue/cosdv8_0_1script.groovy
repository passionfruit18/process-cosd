//import org.modelcatalogue.core.*
//import groovy.transform.Immutable
//import org.hibernate.*
//import org.modelcatalogue.core.ElementService
//import org.modelcatalogue.core.publishing.CloningContext
//
//ElementService elementService = ctx.getBean('elementService')
////SessionFactory sessionFactory = ctx.getBean('sessionFactory')
////Session currentSession = sessionFactory.getCurrentSession()
//
//println "COSD 8.0.1 check newly added items, do deletions, modifications using data from ProcessCosd\n===================================\n"
//
//// Script copied from v7.0.6 script. Replaced references to 7.0.6 with 8.0.1.
//// Have a section for renaming e.g. Gynaecology -> Gynaecological in Data Class/Data Element names,
//// Plan to use different deletion and addition data.
//// Not sure what will happen with the modifications.
//
//class COSDEntry {
//    String dataItemNo
//    String dataItemSection
//}
//
//Object scriptConfig = new Object() {
//
//    boolean doRenamingOlogical = false
//
//    boolean doDeletions = false
//
//    boolean doAdditionChecks = false
//
//    boolean doMoveDataClassesToCore = false
//    boolean doNewSectionsInDiseaseGroups = false
//    boolean doRealignSecondLevelSections = false
//    boolean doChangesToEnums = false
//
//    boolean deleteEmptyDataClasses = false
//    boolean findDataElementsWithMultipleDataClasses = false
//
//    boolean createDuplicates = false
//    boolean doDeDupes = false
//}
//
//
//DataModel dm = DataModel.findByNameAndSemanticVersion('Cancer Outcomes and Services Dataset', '8.0.1')
//
//List<DataElement> cosd8des = DataElement.executeQuery("from DataElement de where de.dataModel=:dataModel",
//        [dataModel: dm])
//
//println "Renaming e.g. Gynaecology to Gynaecological\n===========================================\n"
//if (scriptConfig.doRenamingOlogical) {
//    List<String> prefixes = ['GYNAECO', 'HAEMATO', 'URO']
//    for (String prefix: prefixes) {
//        String xxxLOGY = prefix + 'LOGY'
//        String xxxLOGICAL = prefix + 'LOGICAL'
//        // find all data classes/data elements with xxxLOGY in their name and replace that with xxxLOGICAL
//        // make sure it's the right case for data classes.
//        // Data Classes:
//        List<DataClass> dataClassesToBeRenamed = DataClass.executeQuery(
//                "from DataClass dc where dc.dataModel=:dataModel and dc.name like :xxxLOGYWild",
//                [dataModel: dm, xxxLOGYWild: "%${xxxLOGY}%"]) // finds regardless of case
//        dataClassesToBeRenamed.each {
//            println "Renaming ${it.name} to"
//            println it.name.replaceAll(xxxLOGY, xxxLOGICAL).replaceAll(camelize(xxxLOGY), camelize(xxxLOGICAL))
//            println ''
//            it.name = it.name.replaceAll(xxxLOGY, xxxLOGICAL).replaceAll(camelize(xxxLOGY), camelize(xxxLOGICAL))
//            saveCatalogueElement(it)
//
//        }
//        // Data Elements:
//        List<DataElement> dataElementsToBeRenamed = DataElement.executeQuery(
//                "from DataElement de where de.dataModel = :dataModel and de.name like :xxxLOGYWild",
//                [dataModel: dm, xxxLOGYWild: "%${xxxLOGY}%"])
//        dataElementsToBeRenamed.each {
//            println "Renaming ${it.name} to"
//            println it.name.replaceAll(xxxLOGY, xxxLOGICAL).replaceAll(camelize(xxxLOGY), camelize(xxxLOGICAL))
//            println ''
//            it.name = it.name.replaceAll(xxxLOGY, xxxLOGICAL).replaceAll(camelize(xxxLOGY), camelize(xxxLOGICAL))
//            saveCatalogueElement(it)
//        }
//
//
//
//
//    }
//}
//else {
//    println "skipping"
//}
//
//println "# Check Additions\n=================\n"
//
//// DATA PROCESSED FROM SPREADSHEET v8.0.1. CR6980 occurs twice
//List<COSDEntry> newlyAddedItems = [new COSDEntry(dataItemNo: 'CR6500', dataItemSection: 'CORE - DIAGNOSTIC DETAILS'), new COSDEntry(dataItemNo: 'CR6510', dataItemSection: 'CORE - NON PRIMARY CANCER PATHWAY ROUTE'), new COSDEntry(dataItemNo: 'CR6520', dataItemSection: 'CORE - NON PRIMARY CANCER PATHWAY ROUTE'),
//                                   new COSDEntry(dataItemNo: 'CR6900', dataItemSection: 'CORE - NON PRIMARY CANCER PATHWAY ROUTE'), new COSDEntry(dataItemNo: 'CR6840', dataItemSection: 'CORE - DEMOGRAPHICS'), new COSDEntry(dataItemNo: 'CR6780', dataItemSection: 'CORE - IMAGING'),
//                                   new COSDEntry(dataItemNo: 'CR6830', dataItemSection: 'CORE - DIAGNOSIS'), new COSDEntry(dataItemNo: 'CR6960', dataItemSection: 'CORE - DIAGNOSIS'), new COSDEntry(dataItemNo: 'CR6910', dataItemSection: 'CORE - DIAGNOSIS'),
//                                   new COSDEntry(dataItemNo: 'CR7030', dataItemSection: 'CORE - DIAGNOSIS'), new COSDEntry(dataItemNo: 'CR7000', dataItemSection: 'CORE - DIAGNOSIS'), new COSDEntry(dataItemNo: 'CR7010', dataItemSection: 'CORE - DIAGNOSIS'),
//                                   new COSDEntry(dataItemNo: 'CR7020', dataItemSection: 'CORE - DIAGNOSIS'), new COSDEntry(dataItemNo: 'CR6750', dataItemSection: 'CORE - CLINICAL NURSE SPECIALIST + RISK FACTOR ASSESSMENT'), new COSDEntry(dataItemNo: 'CR6760', dataItemSection: 'CORE - CLINICAL NURSE SPECIALIST + RISK FACTOR ASSESSMENT'),
//                                   new COSDEntry(dataItemNo: 'CR6770', dataItemSection: 'CORE - CLINICAL NURSE SPECIALIST + RISK FACTOR ASSESSMENT'), new COSDEntry(dataItemNo: 'CR6700', dataItemSection: 'CORE - CLINICAL TRIALS'), new COSDEntry(dataItemNo: 'CR6710', dataItemSection: 'CORE - CLINICAL TRIALS'),
//                                   new COSDEntry(dataItemNo: 'CR6800', dataItemSection: 'CORE - STAGING'), new COSDEntry(dataItemNo: 'CR6810', dataItemSection: 'CORE - STAGING'), new COSDEntry(dataItemNo: 'CR6980', dataItemSection: 'CORE - STAGING'),
//                                   new COSDEntry(dataItemNo: 'CR6540', dataItemSection: 'CORE - TREATMENT'), new COSDEntry(dataItemNo: 'CR6980', dataItemSection: 'CORE - PATHOLOGY DETAILS'), new COSDEntry(dataItemNo: 'CR6820', dataItemSection: 'CORE - PATHOLOGY DETAILS'),
//                                   new COSDEntry(dataItemNo: 'CO5410', dataItemSection: 'COLORECTAL - PATHOLOGY'), new COSDEntry(dataItemNo: 'BR4130', dataItemSection: 'BREAST - DIAGNOSIS'), new COSDEntry(dataItemNo: 'HN9200', dataItemSection: 'HEAD & NECK - PRE TREATMENT ASSESSMENT'),
//                                   new COSDEntry(dataItemNo: 'LV16000', dataItemSection: 'LIVER - DIAGNOSIS'), new COSDEntry(dataItemNo: 'LV16010', dataItemSection: 'LIVER - DIAGNOSIS'), new COSDEntry(dataItemNo: 'LV16020', dataItemSection: 'LIVER - DIAGNOSIS'),
//                                   new COSDEntry(dataItemNo: 'LV16030', dataItemSection: 'LIVER - DIAGNOSIS'), new COSDEntry(dataItemNo: 'LV16130', dataItemSection: 'LIVER - STAGING'), new COSDEntry(dataItemNo: 'LV16310', dataItemSection: 'LIVER - TREATMENT - LIVER METS & LIVER HCC'),
//                                   new COSDEntry(dataItemNo: 'LV16320', dataItemSection: 'LIVER - TREATMENT - LIVER METS & LIVER HCC'), new COSDEntry(dataItemNo: 'LV16200', dataItemSection: 'LIVER - SURGERY AND OTHER PROCEDURES'), new COSDEntry(dataItemNo: 'LV16210', dataItemSection: 'LIVER - SURGERY AND OTHER PROCEDURES'),
//                                   new COSDEntry(dataItemNo: 'UR15410', dataItemSection: 'UROLOGICAL - DIAGNOSIS - PROSTATE'), new COSDEntry(dataItemNo: 'UR15420', dataItemSection: 'UROLOGICAL - TREATMENT - PROSTATE'), new COSDEntry(dataItemNo: 'UR15430', dataItemSection: 'UROLOGICAL - TREATMENT - PROSTATE'),
//                                   new COSDEntry(dataItemNo: 'LV16100', dataItemSection: 'LIVER - STAGING'), new COSDEntry(dataItemNo: 'LV16110', dataItemSection: 'LIVER - STAGING'), new COSDEntry(dataItemNo: 'LV16120', dataItemSection: 'LIVER - STAGING'),
//                                   new COSDEntry(dataItemNo: 'LV16300', dataItemSection: 'LIVER - TREATMENT - LIVER METS & LIVER HCC')]
//
//
//List<String> newlyAddedIds = newlyAddedItems.collect{it.dataItemNo}
////List<String> newlyAddedIds = ['CR6000', 'CR6230', 'CR6490', 'CR6400', 'CR6430', 'CR6440', 'CR6450', 'CR6460', 'CR6470', 'CR6100', 'CR6110', 'CR6120', 'CR6130', 'CR6140', 'CR6150', 'CR6160', 'CR6170', 'CR6180', 'CR6190', 'CR6200', 'CR6480', 'CR6300', 'CR6010', 'CR6310', 'CR6220', 'CR6490', 'CR6410', 'CR6490', 'CR6420', 'BA3200', 'BA3210', 'CO5400', 'CT6990', 'CT7020', 'CT7200', 'CT7240', 'CT7160', 'CT7170', 'CT7180', 'CT7030', 'CT7400', 'CT7260', 'CT7270', 'CT7380', 'CT7310', 'CT7150', 'CT7070', 'CT7000', 'CT7010', 'CT7110', 'CT7190', 'CT7390', 'CT7370', 'CT7120', 'CT7130', 'CT7140', 'CT7050', 'CT7060', 'CT7040', 'CT7320', 'CT7330', 'CT7340', 'CT7350', 'CT7360', 'CT7080', 'CT7090', 'GY7460', 'GY7450', 'LU10300', 'LU10310', 'LU10340', 'LU10350', 'LU10360', 'LU10420', 'LU10370', 'LU10390', 'SK12710', 'SK12720', 'SK12730', 'SK12740', 'SK12700', 'SK12510', 'UR15400']
//
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
//List<String> cosd8deIds = cosd8des.collect {
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
//        if (!(id in cosd8deIds)) {
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
//// DATA PROCESSED FROM SPREADSHEET v8.0.1.
//List<String> itemsToDeleteIds = ['CR0440',
//                                 'CR1580',
//                                 'CR1540',
//                                 'CR6000', 'BR4050',
//                                 'CR0420',
//                                 'GY7220',
//                                 'BR4170', 'BA3160', 'GY7150', 'HN9380', 'SA11120',
//                                 'BA3040', 'BA3060',
//                                 'CT6210', 'CT6220', 'CT6230', 'CT6270', 'CT6720', 'CT6280', 'CT6290', 'CT7320', // duplicates
//                                 'CT6380', 'CT6390', 'CT6470', 'CT6440', // also duplicates.
//                                 'CT6400', 'CT6410',
//                                 'CT6590',
//                                 'CT6110',
//                                 'HA8120', // also a duplicate
//                                 'HN9140', 'HN9150',
//                                 'LU10190',
//                                 'SK12030', 'SK12450',
//                                 'UG13630', 'UG14530', 'UG14540', 'UG14550', 'UG13250', 'UG13070', 'UG13080', 'UG13580',
//                                 'UG14520', 'UG14570', 'UG13590', 'UG13560'
//]
//
//itemsToDeleteIds.each {id ->
//    if (id in cosd8deIds) {
//        println "Item to delete $id found in data model"
//    }
//    else {
//        println "Item to delete $id NOT found in data model"
//
//    }
//}
//
//List<DataElement> dataElementsToDelete = cosd8des.findAll {de ->
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
//                                         'HEAD & NECK -PATHOLOGY - VARIOUS', 'LUNG - PATHOLOGY ', 'SARCOMA - PATHOLOGY',
//                                         'SARCOMA - PATHOLOGY - BONE', 'SARCOMA - PATHOLOGY - SOFT TISSUE', 'SKIN - GENERAL - BCC, SCC & MM ',
//                                         'SKIN - PATHOLOGY - BCC & SCC', 'SKIN - PATHOLOGY - MM', 'SKIN - PATHOLOGY - SCC',
//                                         'SKIN - PATHOLOGY - SCC & MM', 'UPPER GI -  PATHOLOGY - LIVER METS', 'UPPER GI - PATHOLOGY - OESOPHAGEAL AND STOMACH',
//                                         'UPPER GI -PATHOLOGY - OESOPHAGEAL, OG JUNCTION, PANCREAS, BILE DUCT, LCC, LIVER HCC AND LIVER METS', 'UROLOGY - PATHOLOGY - BLADDER', 'UROLOGY - PATHOLOGY - KIDNEY',
//                                         'UROLOGY - PATHOLOGY - PROSTATE', 'UROLOGY - PATHOLOGY - TESTICULAR', 'UROLOGY- PATHOLOGY - PENIS']
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
//
//@Immutable
///**
// * Data element with COSD id #originalCosdId will have to be duplicated
// * and the duplicate will have to be given the COSD id #alternateCosdId
// * and the containment relationship from data class with name #alternateDataClassName should have destination
// * data element #alternateCosdId
// * instead of data element #originalCosdId
// */
//class ModCreateDuplicates implements Modification {
//    String originalCosdId
//    String alternateCosdId
//    String alternateDataClassName
//}
//
///**
// * Tries to save, ignoring Unable to convert to JSON exceptions, until success
// *(or some other exception)
// */
////@Transactional
//void saveCatalogueElement(CatalogueElement ce) {
//    boolean success = false
//    while (!success) {
//        try {
//            ce.save(flush:true)
//            success = true
//        }
//        catch (IllegalArgumentException iae) {
//            if (iae.message.matches("Unable to convert.*to JSON")) {
//                // ignore these exceptions
//                println "Ignoring exception ${iae.message}"
//            }
//            else {
//                throw iae
//            }
//        }
//    }
//
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
//            de = cosd8des.find {getCosdId(it) == cosdId}
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
//            de = cosd8des.find {getCosdId(it) == cosdId}
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
//        DataElement de = cosd8des.find({getCosdId(it) == cosdId})
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
//println "# Delete dataclasses with nothing in them\n=========================================\n"
//if (scriptConfig.deleteEmptyDataClasses) {
//    List<DataClass> toCleanUp = DataClass.findAllByDataModel(dm)
//    boolean deleted = false
//    for (DataClass dc: toCleanUp) {
//        List<Relationship> children = dc.getOutgoingRelationshipsByType(RelationshipType.hierarchyType)
//        List<Relationship> contained = dc.getOutgoingRelationshipsByType(RelationshipType.containmentType)
//        if (children.size() == 0 && contained.size() == 0) {
//            println "Data Class ${dc.name} has no children or contained data element, deleting"
//            deleteCatalogueElement(dc)
//            deleted = true
//        }
//    }
//    if (!deleted) {
//        println "No empty data classes to remove"
//    }
//}
//else {
//    println "Skipping deleting empty data classes"
//}
//println ''
//
//println '# Find Data Elements with multiple data classes\n===============================================\n'
//
//if (scriptConfig.findDataElementsWithMultipleDataClasses) {
//    List<DataElement> allDataElements = DataElement.findAllByDataModel(dm)
//    for (DataElement de: allDataElements) {
//        List<Relationship> containing = de.getIncomingRelationshipsByType(RelationshipType.containmentType)
//        if (containing.size() > 1) {
//            println "Data Element '${de.name}', COSD id ${getCosdId(de)} has more than one containing data class, namely ${containing.size()}"
//        }
//        if (containing.size() < 1) {
//            println "Data Element '${de.name}', COSD id ${getCosdId(de)} has less than one containing data class"
//        }
//    }
//}
//else {
//    println "skipping"
//}
//println ''
//
//
//println "## Create Duplicates\n========================\n"
//// DATA PROCESSED FROM SPREADSHEET
//List<ModCreateDuplicates> modCreateDuplicatesList = [
//        new ModCreateDuplicates('HA8300', 'CT6290', 'CTYA - STAGING - HODGKIN LYMPHOMA'),
//        new ModCreateDuplicates('HA8280', 'CT6270', 'CTYA - STAGING - HODGKIN LYMPHOMA'),
//        new ModCreateDuplicates('HA8720', 'CT6720', 'CTYA - STAGING - HODGKIN LYMPHOMA'),
//        new ModCreateDuplicates('HA8290', 'CT6280', 'CTYA - STAGING - HODGKIN LYMPHOMA'),
//        new ModCreateDuplicates('HA8270', 'CT6210', 'CTYA - DIAGNOSIS - ACUTE LYMPHOBLASTIC LEUKAEMIA and ACUTE MYELOID LEUKAEMIA'),
//        new ModCreateDuplicates('SK12730', 'CR6200', 'CORE - MOLECULAR AND BIOMARKERS - SOMATIC TESTING FOR TARGETED THERAPY AND PERSONALISED MEDICINE'),
//        new ModCreateDuplicates('BA3030', 'CR0350', 'CORE - IMAGING'),
//        new ModCreateDuplicates('UG14540', 'BA3020', 'CNS - IMAGING'),
//        new ModCreateDuplicates('SK12530', 'UR15240', 'UROLOGY - PATHOLOGY - PROSTATE'),
//        new ModCreateDuplicates('CT6650', 'UR15160', 'UROLOGY - PATHOLOGY - KIDNEY'),
//        new ModCreateDuplicates('SA11000', 'CT6470', 'CTYA - DIAGNOSIS - OSTEOSARCOMA and EWINGS'),
//        new ModCreateDuplicates('SA11010', 'CT6440', 'CTYA - DIAGNOSIS - OSTEOSARCOMA and EWINGS'),
//        new ModCreateDuplicates('CO5000', 'BR4025', 'BREAST - REFERRALS'),
//        new ModCreateDuplicates('CO5000', 'GY7030', 'GYNAECOLOGY - REFERRAL'),
//        new ModCreateDuplicates('HA8150', 'CT6220', 'CTYA - DIAGNOSIS - ACUTE LYMPHOBLASTIC LEUKAEMIA and ACUTE MYELOID LEUKAEMIA'),
//]
//// if you're doing it manually:
//// clone data element.
//// move it to the right class.
//// modelCatalogueId is COSD id.
//// Modify 'Data Item No' extension.
//// Remove the data class relationship from the original data element
//
//
//if (scriptConfig.createDuplicates) {
//    for (ModCreateDuplicates mcd: modCreateDuplicatesList) {
//        println "Attempting mcd ${mcd}"
//        String originalCosdId = mcd.originalCosdId
//        String alternateCosdId = mcd.alternateCosdId
//        String alternateDataClassName = mcd.alternateDataClassName
//
//        DataElement de = cosd8des.find({getCosdId(it) == originalCosdId})
//
//        if (de) {
//            println "Original data element name ${de.name} found"
//
//            DataElement duplicateDe = DataElement.findAllByNameAndDataModel(de.name, dm).find{getCosdId(it) == alternateCosdId}
//
//            if (duplicateDe) {
//                println "Duplicate DE with id ${alternateCosdId} already exists"
//            }
//            else {
//
//                duplicateDe = new DataElement()
//                duplicateDe = (DataElement) elementService.cloneElement(de, CloningContext.create(dm, dm))
//
//
//            }
//            /*
//            // copy name, description, status, ext. And dataType.
//
//            duplicateDe.name = de.name
//
//            duplicateDe.description = de.description
//
//            duplicateDe.status = de.status
//            println de.status
//            println de.dataType.name // fails to get dataType on second round for some reason.
//
//            println duplicateDe
//            duplicateDe.dataType = de.dataType
//
//            saveCatalogueElement(duplicateDe)
//
//            duplicateDe.ext = de.ext
//*/
//            duplicateDe.dataModel = dm
//            // modelCatalogueId is COSD id.
//            duplicateDe.modelCatalogueId = alternateCosdId
//
//            // save just to make sure
//            saveCatalogueElement(duplicateDe)
//
//            // Modify 'Data Item No' extension.
//            duplicateDe.ext['Data Item No'] =  alternateCosdId
//
//            println "Duplicate DE has cosd id ${getCosdId(duplicateDe)}, should be ${alternateCosdId}"
//
//            // Switch alternateDataClass's containment relationship to point to duplicateDe
//            List<Relationship> containers = de.getIncomingRelationshipsByType(RelationshipType.containmentType)
//            Relationship alternateDataClassR = containers?.find {it.source.name == alternateDataClassName}
//            if (alternateDataClassR) {
//                println "Set data class ${alternateDataClassR.source.name} to point to duplicate DE"
//                alternateDataClassR.destination = duplicateDe
//                alternateDataClassR.save(flush:true)
//            }
//            else {
//                println "No data class named ${alternateDataClassName} containing original data element ${de.name} found (perhaps already re-pointed it)"
//                DataClass containing = duplicateDe.getIncomingRelationshipsByType(RelationshipType.containmentType)[0]?.source
//                if (containing) {
//                    duplicateDe.addToContainedIn(containing)
//                    println "Adding to contained in"
//                }
//
//
//            }
//
//
//            // save
//
//            saveCatalogueElement(duplicateDe)
//
//
//        }
//        else {
//            println "Data Element with cosd id ${originalCosdId} not found"
//        }
//
//
//
//
//    }
//}
//else {
//    println "skipping"
//}
//
//println "## Do DeDupes\n=============\n"
//
//if (scriptConfig.doDeDupes) {
//    String corePathology = 'CORE - PATHOLOGY DETAILS'
//    Map<String,String> toDeDupes = ['INVESTIGATION RESULT DATE': 'CR0780', 'SERVICE REPORT IDENTIFIER': 'CR0950']
//    toDeDupes.each{String toDeDupeName, String cosdId ->
//        DataElement toDeDupe = DataElement.findByNameAndDataModel(toDeDupeName, dm)
//        toDeDupe.ext['Data Item No'] = cosdId
//        List<Relationship> containingRs = toDeDupe.getIncomingRelationshipsByType(RelationshipType.containmentType)
//        containingRs.each {r ->
//            if (r.source.name != corePathology) {
//                println "${r.source.name} not core pathology"
//                r.delete(flush:true)
//            }
//        }
//    }
//
//}
//else {
//    println "skipping"
//}
//
//println "# Errors:\n=======\n"
//ErrorType.values().each {
//    println "ErrorType $it: \n-- ${errorsInCOSD.get(it)?.join('\n-- ')}"
//    println ''
//}