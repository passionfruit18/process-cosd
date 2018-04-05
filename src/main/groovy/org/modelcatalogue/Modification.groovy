package org.modelcatalogue

import groovy.transform.Immutable

/**
 * Type of a Modification to a COSD entry
 */
trait Modification {
    //abstract void produceGroovyCodeOrModificationInstructions(List<String> ids, List<String> groovyCodeStrings, List<String> modificationInstructions, String dataModelName)
}

@Immutable
/**
 * The data classes with the given name will be moved under the 'Core' DataClass.
 */
class ModMoveToCorePathology implements Modification {
    List<String> dataClassNames
}

@Immutable
/**
 * e.g. processing ModNewSectionInDiseaseGroup(['CT6230', 'CT6240'], 'DIAGNOSIS') should
 * for each dataElement find the containing dataClass starting with newSectionNamePart1, e.g. "CTYA - ACUTE...",
 * and then create/find a data class involving newSectionNamePart2,
 * e.g. "CTYA - DIAGNOSIS - ACUTE...", and then move the dataElement
 * where CTYA is newSectionNamePart1,
 * DIAGNOSIS is newSectionNamePart2.
 */
class ModNewSectionInDiseaseGroup implements Modification {
    List<String> cosdIds
    String newSectionNamePart1
    String newSectionNamePart2
}

@Immutable
/**
 * Change from data class SKIN - PATHOLOGY - MM to (find/create new data class) SKIN - DIAGNOSIS - MM
 * for each cosdId/dataElement
 * where oldSecondLevelSection is '- PATHOLOGY' and newSecondLevelSection is '- DIAGNOSIS'
 */
class ModRealignSecondLevel implements Modification {
    List<String> cosdIds
    String oldSecondLevelSection
    String newSecondLevelSection
}


@Immutable
/**
 * Enums changed for entry #cosdId to #newEnums. Erase the old enums and insert the new enums.
 */
class ModChangesToEnums implements Modification {
    String cosdId
    Map<String, String> newEnums
}

@Immutable
/**
 * Schema specification for entry with COSD id #id changed to #change
 */
class ModChangesToSchemaSpec implements Modification {
    String cosdId
    String change

}

@Immutable
/**
 * Will have to do the modification manually.
 */
class ModManual implements Modification {
    List<String> cosdIds
    String comment = ''
}

@Immutable
/**
 * Data element with COSD id #originalCosdId will have to be duplicated
 * and the duplicate will have to be given the COSD id #alternateCosdId
 * and the containment relationship from data class with name #alternateDataClassName should have destination
 * data element #alternateCosdId
 * instead of data element #originalCosdId
 */
class ModCreateDuplicates implements Modification {
    String originalCosdId
    String alternateCosdId
    String alternateDataClassName
}



@Immutable
/**
 * Not sure what the modification is.
 */
class ModUnclearFromSpreadsheet implements Modification {
    List<String> cosdIds
}

/**
 * Haven't examined this group to find its modification yet
 */
class ModNotLookedAtSpreadsheetYet implements Modification {

}
//
//enum Modifications {
//    MOVE_TO_CORE_PATHOLOGY(ModMoveToCorePathology),
//    CHANGES_TO_ENUMS(ModChangesToEnums),
//    CHANGES_TO_SCHEMA_SPEC(ModChangesToSchemaSpec),
//    MANUAL(ModManual),
//    UNCLEAR_FROM_SPREADSHEET(ModUnclearFromSpreadsheet),
//    NOT_LOOKED_AT_SPREADSHEET_YET(ModNotLookedAtSpreadsheetYet)
//
//    final Class<Modification> modificationClass
//
//    Modifications(Class<Modification> modificationClass) {
//        this.modificationClass = modificationClass
//    }
//}


class ModificationGroup {
    List<String> ids
    List<Modification> modifications


}

class ModificationLists {
    Map<Class<Modification>, List<Modification>> modificationsGroupedByType

    List<ModMoveToCorePathology> modMoveToCorePathologyList() {modificationsGroupedByType.get(ModMoveToCorePathology).collect {(ModMoveToCorePathology) it}}
    List<ModNewSectionInDiseaseGroup> modNewSectionInDiseaseGroupList() {modificationsGroupedByType.get(ModNewSectionInDiseaseGroup).collect {(ModNewSectionInDiseaseGroup) it}}
    List<ModRealignSecondLevel> modRealignSecondLevelList() {modificationsGroupedByType.get(ModRealignSecondLevel).collect {(ModRealignSecondLevel) it}}


    List<ModChangesToEnums> modChangesToEnumsList() {modificationsGroupedByType.get(ModChangesToEnums).collect {(ModChangesToEnums) it}}
    List<ModChangesToSchemaSpec> modChangesToSchemaSpecList() {modificationsGroupedByType.get(ModChangesToSchemaSpec).collect {(ModChangesToSchemaSpec) it}}

    List<ModManual> modManualList() {modificationsGroupedByType.get(ModManual).collect {(ModManual) it}}
    List<ModCreateDuplicates> modCreateDuplicatesList() {modificationsGroupedByType.get(ModCreateDuplicates).collect {(ModCreateDuplicates) it}}

    List<ModUnclearFromSpreadsheet> modUnclearFromSpreadsheetList() {modificationsGroupedByType.get(ModUnclearFromSpreadsheet).collect {(ModUnclearFromSpreadsheet) it}}
    List<ModNotLookedAtSpreadsheetYet> modNotLookedAtSpreadsheetYetList() {modificationsGroupedByType.get(ModNotLookedAtSpreadsheetYet).collect {(ModNotLookedAtSpreadsheetYet) it}}


    ModificationLists(Map<Class<Modification>, List<Modification>> modificationsGroupedByType) {
        this.modificationsGroupedByType = modificationsGroupedByType
    }

    static ModificationLists from(List<ModificationGroup> modificationGroups) {
        new ModificationLists(modificationGroups.collect {it.modifications}.flatten().groupBy{it.getClass()})
    }
}