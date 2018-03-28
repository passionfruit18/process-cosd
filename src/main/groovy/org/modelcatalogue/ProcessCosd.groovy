package org.modelcatalogue
import com.emmanuelrosa.frostedsheets.*
import groovy.transform.Immutable
import org.apache.poi.hssf.usermodel.HSSFCellStyle
import org.apache.poi.hssf.usermodel.HSSFFont
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.hssf.util.HSSFColor
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.RichTextString
import org.apache.poi.ss.usermodel.Row

class Config {
    String version
    String workbookPath
    List<String> handPickedDeletedItemIds
    List<String> handPickedCompletelyNewItemIds

    // the following are good for
    String deletedForegroundHex = 'FFFF:0:0'
    String deletedFontColor = 'FFFF:0:0'
    String newEntryForegroundColorHex = '0:8080:0'
}

class COSDEntry {
    String dataItemNo
    String dataItemSection
    static COSDEntry fromRow(Row row) {
        new COSDEntry(dataItemNo: row?.getCell(HeadersMap.dataItemNo)?.stringCellValue,
                dataItemSection: row?.getCell(HeadersMap.dataItemSection)?.stringCellValue)
    }
    String newObjRep() {
        "new COSDEntry(dataItemNo: '${dataItemNo}', dataItemSection: '${dataItemSection}')"
    }
}


class HeadersMap {
    static int dataItemNo = 0
    static int dataItemSection = 1
}

class ModificationGroup {
    List<String> ids
    List<Modification> modifications
}

trait Modification {
    //abstract void produceGroovyCodeOrModificationInstructions(List<String> ids, List<String> groovyCodeStrings, List<String> modificationInstructions, String dataModelName)
}

@Immutable
/**
 * The data class with the given name will be moved under the 'Core' DataClass.
 */
class MoveToCorePathology implements Modification {
    String dataClassName
}

class NotLookedAtSpreadsheetYet implements Modification {

}

class ChangesToEnums implements Modification {

}

class ChangesToSchemaSpec implements Modification {

}

class Manual implements Modification {

}

class UnclearFromSpreadsheet implements Modification {

}


class ProcessCosd {
    static final String SUBSTANTIAL_CHANGES = 'SUBSTANTIAL CHANGES'
    static final String COSMETIC_CHANGES = 'COSMETIC  CHANGES'

    static final List<ModificationGroup> COSD_v7_0_6_substantial_and_cosmetic_change_modifications = [
            new ModificationGroup(ids: ['BR4140', 'BR4160', 'BR4170', 'BR4180', 'BR4190', 'BR4200', 'BR4210', 'BR4230', 'BR4220', 'BR4300', 'BR4290', 'BR4280', 'BR4310', 'BR4240', 'BR4250', 'BR4260', 'BR4270'],
                    modifications: [new MoveToCorePathology('BREAST - PATHOLOGY  ')]),

            new ModificationGroup(ids: ['BA3070'],
                    modifications: [new ChangesToEnums()]),

            new ModificationGroup(ids: ['BA3150', 'BA3160'],
                    modifications: [new MoveToCorePathology('CNS - PATHOLOGY ')]),
            new ModificationGroup(ids: ['CO5190', 'CO5210'],
                    modifications: [new MoveToCorePathology('COLORECTAL - PATHOLOGY')]),
            new ModificationGroup(ids: ['CO5260', 'CO5270', 'CO5280', 'CO5290', 'CO5300'],
                    modifications: [new MoveToCorePathology('COLORECTAL - PATHOLOGY')]),

            new ModificationGroup(ids: ['CT6210'],
                    modifications: [new Manual()]),

            new ModificationGroup(ids: ['CT6610', 'CT6620', 'CT6630', 'CT6640', 'CT6650', 'CT6660', 'CT6670'],
                    modifications: [new MoveToCorePathology('CTYA -  RENAL PATHOLOGY (Paediatric Kidney)')]),
            new ModificationGroup(ids: ['GY7050', 'GY7120', 'GY7130', 'GY7100', 'GY7140', 'GY7190', 'GY7150', 'GY7170', 'GY7180', 'GY7240', 'GY7260', 'GY7270', 'GY7280'],
                    modifications: [new MoveToCorePathology()]),

            new ModificationGroup(ids: ['GY7280'],
                    modifications: [new ChangesToEnums()]),

            new ModificationGroup(ids: ['GY7220'],
                    modifications: [new MoveToCorePathology(), new ChangesToSchemaSpec()]),
            new ModificationGroup(ids: ['GY7290', 'GY7300', 'GY7350', 'GY7310', 'GY7340', 'GY7360', 'GY7370', 'GY7020', 'GY7060', 'GY7080', 'GY7070', 'GY7090', 'GY7410', 'GY7420', 'GY7230'],
                    modifications: [new MoveToCorePathology()]),

            new ModificationGroup(ids: ['HA8270'],
                    modifications: [new ChangesToEnums()]),

            new ModificationGroup(ids: ['HN9300', 'HN9310', 'HN9320', 'HN9330', 'HN9380', 'HN9390', 'HN9400', 'HN9410', 'HN9420', 'HN9430'],
                    modifications: [new MoveToCorePathology()]),

            new ModificationGroup(ids: ['LU10090'],
                    modifications: [new ChangesToEnums()]),

            new ModificationGroup(ids: ['LU10100', 'LU10110', 'LU10120', 'LU10130', 'LU10140', 'LU10150', 'LU10160', 'LU10170', 'LU10180'],
                    modifications: [new MoveToCorePathology()]),

            new ModificationGroup(ids: ['SA11120', 'SA11170', 'SA11130', 'SA11140'],
                    modifications: [new UnclearFromSpreadsheet()]),

            new ModificationGroup(ids: ['SA11100', 'SA11220'],
                    modifications: [new MoveToCorePathology()]),

            new ModificationGroup(ids: ['SK12450'],
                    modifications: [new Manual()]),
            new ModificationGroup(ids: ['SK12030'],
                    modifications: [new Manual()]),
            new ModificationGroup(ids: ['SK12010'],
                    modifications: [new Manual()]),

            new ModificationGroup(ids: ['SK12120'],
                    modifications: [new MoveToCorePathology()]),
            new ModificationGroup(ids: ['SK12530', 'SK12537', 'SK12650', 'SK12660', 'SK12545', 'SK12565', 'SK12580', 'SK12590', 'SK12600', 'SK12620', 'SK12630', 'SK12430', 'SK12460', 'SK12470', 'SK12480', 'SK12490'],
                    modifications: [new MoveToCorePathology()]),
            new ModificationGroup(ids: ['UG14470', 'UG14480', 'UG14490'],
                    modifications: [new MoveToCorePathology()]),
            new ModificationGroup(ids: ['UR15120', 'UR15290', 'UR15130', 'UR15140', 'UR15150', 'UR15160', 'UR15170', 'UR15180', 'UR15190', 'UR15200', 'UR15210', 'UR15220', 'UR15230', 'UR15240', 'UR15250', 'UR15260', 'UR15270', 'UR15310'],
                    modifications: [new MoveToCorePathology()]),
            // END OF SUBSTANTIAL CHANGES

            // Cosmetic Changes: Some "realigned", "regrouped"

            new ModificationGroup(ids: ['CR0020'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR3170'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR0180'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR3160'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR0510'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR2070'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR3040', 'CR3050'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CT6350', 'CT6750', 'CT6380', 'CT6390', 'CT6450', 'CT6470', 'CT6440', 'CT6220', 'CT6230', 'CT6240'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CT6130', 'CT6140'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CT6710', 'CT6720', 'CT6740', 'CT6770', 'CT6800', 'CT6250', 'CT6270', 'CT6280', 'CT6290', 'CT6330', 'CT6500', 'CT6510', 'CT6590'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CT6560', 'CT6760'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CT6310', 'CT6360', 'CT6460', 'CT6530', 'CT6550', 'CT6580', 'CT6520'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['HA8660'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['HA8720', 'HA8680', 'HA8280', 'HA8290', 'HA8300', 'HA8310'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['LU10070', 'LU10080'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['SK12030'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['SK12450'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['SK12630'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['UG13100', 'UG13810'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['UG14210', 'UG14230', 'UG13240', 'UG13590', 'UG14290', 'UG13090', 'UG13250', 'UG13070', 'UG13080', 'UG13560', 'UG13580'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['UR15100', 'UR15110'],
                    modifications: [new NotLookedAtSpreadsheetYet()]),


    ]

    static String listBroken(List<String> list, int n) {
        "[${list.collate(n)*.join(", ").join(",\n")}]"
    }
    /**
     * Notes on the fonts:
     * (At least for COSD 7.0.6)
     * Green Foreground color index 17/hex string '0:8080:0' (e.g. CR6000) for new additions
     * Red Font color hexString 'FFFF:0:0' (e.g. CR0400), or Red Foreground color index 10/hex string 'FFFF:0:0', (e.g. CO5230) for removals
     * Orange Foreground color hexString 'FFFF:CCCC:9999' or Yellow 'FFFF:FFFF:0', or White 'FFFF:FFFF:FFFF', AND NOT RED FONT 'FFFF:0:0', for modifications in Substantial Changes.
     * Yellow or White for modifications in Cosmetic Changes.
     *
     * COSD 8.0.1: Substantial Changes: Modifications: Have a white foreground. Some cosmetic change modifications have a green foreground!.
     */
    static void processCOSD(Config config) {
        println "# COSD Version: ${config.version}"
        List<String> deletedItemIds = []
        List<String> allChangedIds = []
        List<String> completelyNewItemIds = []
        List<COSDEntry> completelyNewItems = []
        InputStream is = ProcessCosd.class.getClassLoader().getResourceAsStream(config.workbookPath)
        FrostedWorkbook workbook = FrostedWorkbook.readXLS(is)

        FrostedSheet substantialChangesSheet = workbook[SUBSTANTIAL_CHANGES]
        FrostedSheet cosmeticChangesSheet = workbook[COSMETIC_CHANGES]
        
        Closure c = { Row row ->
            println row
            Cell c = row.getCell(HeadersMap.dataItemNo)
            HSSFCellStyle cs = c?.getCellStyle()
            HSSFFont font = cs?.getFont(workbook.getWorkbook())
            HSSFColor fontColor = font?.getHSSFColor((HSSFWorkbook) workbook.getWorkbook())

            println "${c?.stringCellValue}:\n" +
                    "Foreground color: ${cs?.fillForegroundColorColor?.hexString},\n" +
                    "Font color: ${fontColor?.getHexString()}"
            RichTextString
            println "\n---\n"

            if (fontColor?.getHexString() == config.deletedFontColor || cs?.fillForegroundColorColor?.hexString == config.deletedForegroundHex) {
                deletedItemIds << c.stringCellValue
            }
            if (cs?.fillForegroundColorColor?.hexString == config.newEntryForegroundColorHex) {
                completelyNewItems << COSDEntry.fromRow(row)
            }
            if (c?.stringCellValue?.matches(/[A-Z]{1,4}[0-9]{1,10}\s*/)) { // e.g. CO12345
                allChangedIds << c.stringCellValue
            }

        }
        substantialChangesSheet.each c
        cosmeticChangesSheet.each c



        // remove empty strings
        completelyNewItems.removeIf({it.dataItemNo == ''})

        List<String> completelyNewItemStringReps = completelyNewItems.collect {it.newObjRep()}
        println "completelyNewItems: ${listBroken(completelyNewItemStringReps, 3)}\n"

        completelyNewItemIds = completelyNewItems.collect {it.dataItemNo}
        println "Completely new item ids: ${completelyNewItemIds.collect {"'$it'"}.sort()}\n" +
                "size: ${completelyNewItemIds.size()}\n" +
                "setSize: ${completelyNewItemIds.toSet().size()}\n"

        List<String> handpickedCompletelyNewIds = config.handPickedCompletelyNewItemIds
        println "handpicked Completely New Ids: ${handpickedCompletelyNewIds.collect{"'$it'"}.sort()}\n" +
                "size: ${handpickedCompletelyNewIds.size()}\n"

        println "completely new - handpicked completely new: ${completelyNewItemIds - handpickedCompletelyNewIds}\n"

        deletedItemIds.removeIf({it == ''})
        println "Deleted Item Ids: ${deletedItemIds.collect {"'$it'"}}\n" +
                "size: ${deletedItemIds.size()}\n" +
                "setSize: ${deletedItemIds.toSet().size()}\n"


        allChangedIds.removeIf({it == ''})
        allChangedIds //<< 'GY7190' // seems this was not picked up due to a space
        println "All changed item Ids: $allChangedIds\n" +
                "size: ${allChangedIds.size()}\n" +
                "setSize: ${allChangedIds.toSet().size()}\n"


        List<String> justModified = (allChangedIds - deletedItemIds) - completelyNewItemIds
        List<String> justModifiedSetCalc = ((allChangedIds.toSet() - deletedItemIds.toSet()) - completelyNewItemIds.toSet()).toList()
        println "Just modified: $justModified\n" +
                "size: ${justModified.size()}, should equal allChanged.size - deletedItems.size - completelyNew.size = ${allChangedIds.size() - deletedItemIds.size() - completelyNewItemIds.size()}\n" +
                "justModifiedSetCalc size: ${justModifiedSetCalc.size()}\n"



        // compare handpicked deleted item ids and program picked
        List<String> handPickedDeletedItemIds = config.handPickedDeletedItemIds

        println "handpicked deleted == program picked deleted: ${handPickedDeletedItemIds.toSet() == deletedItemIds.toSet()}"

        handPickedDeletedItemIds.each{handPicked ->
            if (!(handPicked in deletedItemIds)) {
                println "Handpicked $handPicked not in deletedItemIds"
            }

        }
        deletedItemIds.each {deletedItemId ->
            if (!(deletedItemId in handPickedDeletedItemIds)) {
                println "Program picked $deletedItemId not in handpicked deleted item ids"
            }
        }

    }

    /**
     * Won't work for 8.0.1 as there some cosmetic changes which are just modifications have a green foreground for the first cell of the row.
     */
    static void categorizeModificationsv7_0_6() {
        
        println "# Categorize Modifications v7.0.6"
        InputStream is = ProcessCosd.class.getClassLoader().getResourceAsStream('org/modelcatalogue/COSD_Dataset_v7_0_6_Final.xls')
        FrostedWorkbook workbook = FrostedWorkbook.readXLS(is)

        FrostedSheet substantialChangesSheet = workbook[SUBSTANTIAL_CHANGES]
        FrostedSheet cosmeticChangesSheet = workbook[COSMETIC_CHANGES]

        List<List<Row>> rowSections = []

        Iterator<Row> substantialRowIterator = substantialChangesSheet.rowIterator()
        Iterator<Row> cosmeticRowIterator = cosmeticChangesSheet.rowIterator()
        List<Row> currentRowSection = []
        while (substantialRowIterator.hasNext() || cosmeticRowIterator.hasNext()) {
            Row row = substantialRowIterator.hasNext() ? substantialRowIterator.next() : cosmeticRowIterator.next()
            Cell c = row.getCell(HeadersMap.dataItemNo)
            HSSFCellStyle cs = c?.getCellStyle()
            HSSFFont font = cs?.getFont(workbook.getWorkbook())
            HSSFColor fontColor = font?.getHSSFColor((HSSFWorkbook) workbook.getWorkbook())

            if (c?.stringCellValue == 'Data item No.') {
                rowSections << currentRowSection.collect()
                currentRowSection = []
            }
            else {
                String foregroundColor = cs?.fillForegroundColorColor?.hexString
               if (  (foregroundColor == 'FFFF:CCCC:9999' // orange
                      ||
                      foregroundColor =='FFFF:FFFF:0' // yellow
                      ||
                      (foregroundColor == 'FFFF:FFFF:FFFF' && // white
                                c?.stringCellValue?.matches(/\s*[A-Z]{1,3}[0-9]{1,10}\s*/)))
                   && !(fontColor?.getHexString() == 'FFFF:0:0')) {
                   currentRowSection << row
               }
            }
            // Note GY7190 is written in the spreadsheet with a space or newline...

            // The process misses 13 things from COSMETIC_CHANGES:

            // CR0020
            // CR3170
            // CR3160
            // CT6750, (belongs with CT6350 etc.)
            // CT6710, CT6720, CT6740, CT6770, CT6800 (belongs with CT6250 etc.)
            // CT6760, (belongs with CT6560)
            // HA8720, HA8680, (belongs with HA8280 etc.)
            // SK12630

            // The program found 186 modified things (deduped), adding 13 gives 199, which is the same deduped figure calculated from all changed - deleted - completely new
        }

        // handle the edges of the iteration: need to add the last accumulated currentRowSection
        rowSections << currentRowSection.collect()
        currentRowSection = []
        // and remove the first, empty, section.
        rowSections.drop(1)

        List<List<String>> idSections = rowSections.collect {
            List<Row> section ->
                section.collect {
                    Row row ->
                        Cell c = row.getCell(HeadersMap.dataItemNo)
                        c?.stringCellValue
                }
        }

        idSections.each {println it}
        idSections = idSections.findAll({it})
        idSections = idSections.collect {
            List<Row> section ->
                section.findAll({it})
        }

        idSections.each{
            String readableList = "['${it.join("', '")}']"
            println "new ModificationGroup(ids: ${readableList},\n" +
                    "modifications: [new NotLookedAtSpreadsheetYet()]),"
        }

        println "Sizes: ${idSections*.size()}"
        println "Total modified: ${idSections*.size().sum()}"
        println "Total modified (remove duplicates): ${idSections.flatten().toSet().size()}"



        //Handle this later
//
    }

    static void main(String... args) {
        Config cosd_7_0_6_config = new Config(version: "7.0.6", workbookPath: 'org/modelcatalogue/COSD_Dataset_v7_0_6_Final.xls',
        handPickedDeletedItemIds: ["CR0400", "CR3030",
                                   "CR0530", "CR3060",
                                   "CR0850", "CR3070",
                                   "BR4030", "BR4040",
                                   "BR4060", "BR4070", "BR4080",
                                   "BR4090", "BR4100", "BR4110",
                                   "BR4130",
                                   "BA3130", "BA3140",
                                   "BA3110", "BA3120",
                                   "CO5010", "CO5020", "CO5030", "CO5040",

                                   "CO5060", "CO5070", "CO5080", "CO5090",
                                   "CO5100", "CO5110", "CO5120", "CO5130", "CO5140", "CO5150",

                                   "CO5005",
                                   "CO5180",
                                   "CO5230",
                                   "CO5250",

                                   "CT6150",
                                   "CT6320", "CT6730",
                                   "CT6300",

                                   "GY7330", "GY7390", "GY7210", "GY7250",

                                   "HA8020",
                                   "HA8230", "HA8690",

                                   "HN9230", "HN9220", "HN9210", "HN9200", "HN9220", "HN9200",

                                   "LU10000", "LU10020", "LU10010", "LU10030",
                                   "SA11160",

                                   "SK12020",
                                   "SK12510",
                                   "UG13293",
                                   "UG13235", "UG13110", "UG13150",
                                   "UG14190",
                                   "UG13030", "UG14410", "UG13320"],
        handPickedCompletelyNewItemIds: ['CR6000', 'CR6230', 'CR6400', 'CR6430', 'CR6440', 'CR6450', 'CR6460', 'CR6470', 'CR6100', 'CR6110', 'CR6120', 'CR6130', 'CR6140', 'CR6150', 'CR6160', 'CR6170', 'CR6180', 'CR6190', 'CR6200', 'CR6480', 'CR6300', 'CR6010', 'CR6310', 'CR6220', 'CR6490', 'CR6410', 'CR6420', 'BA3200', 'BA3210', 'CO5400', 'CT6990', 'CT7020', 'CT7200', 'CT7240', 'CT7160', 'CT7170', 'CT7180', 'CT7030', 'CT7400', 'CT7260', 'CT7270', 'CT7380', 'CT7310', 'CT7150', 'CT7070', 'CT7000', 'CT7010', 'CT7110', 'CT7190', 'CT7390', 'CT7370', 'CT7120', 'CT7130', 'CT7140', 'CT7050', 'CT7060', 'CT7040', 'CT7320', 'CT7330', 'CT7340', 'CT7350', 'CT7360', 'CT7080', 'CT7090', 'GY7460', 'GY7450', 'LU10300', 'LU10310', 'LU10340', 'LU10350', 'LU10360', 'LU10420', 'LU10370', 'LU10390', 'SK12710', 'SK12720', 'SK12730', 'SK12740', 'SK12700', 'SK12510', 'UR15400']
        // this is two off the program-found ids because CR6490 is repeated twice.
        )

        processCOSD(cosd_7_0_6_config)
        println "======\n\n======"
        Config cosd_8_0_1_config = new Config(version: "8.0.1", workbookPath: 'org/modelcatalogue/COSD_Dataset_v8_0_1_Final.xls', handPickedDeletedItemIds: [], handPickedCompletelyNewItemIds: [])
//        processCOSD(cosd_8_0_1_config)

        categorizeModificationsv7_0_6()
    }
}
