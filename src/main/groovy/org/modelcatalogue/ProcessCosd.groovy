package org.modelcatalogue
import com.emmanuelrosa.frostedsheets.*
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

class ProcessCosd {


    static String listBroken(List<String> list, int n) {
        "[${list.collate(n)*.join(", ").join(",\n")}]"
    }
    /**
     * Notes on the fonts:
     * Green Foreground color index 17/hex string '0:8080:0' (e.g. CR6000) for new additions
     * Red Font color getHexString() FFFF:0:0 (e.g. CR0400), or Red Foreground color index 10/hex string 'FFFF:0:0', (e.g. CO5230) for removals
     */
    static void processCOSD(Config config) {
        println "# COSD Version: ${config.version}"
        List<String> deletedItemIds = []
        List<String> allChangedIds = []
        List<String> completelyNewItemIds = []
        List<COSDEntry> completelyNewItems = []
        InputStream is = ProcessCosd.class.getClassLoader().getResourceAsStream(config.workbookPath)
        FrostedWorkbook workbook = FrostedWorkbook.readXLS(is)

        FrostedSheet substantialChangesSheet = workbook['SUBSTANTIAL CHANGES']
        FrostedSheet cosmeticChangesSheet = workbook['COSMETIC  CHANGES']
        
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
            if (c?.stringCellValue?.matches(/[A-Z]{1,4}[0-9]{1,10}/)) { // e.g. CO12345
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
                "size: ${completelyNewItemIds.size()}\n"

        List<String> handpickedCompletelyNewIds = config.handPickedCompletelyNewItemIds
        println "handpicked Completely New Ids: ${handpickedCompletelyNewIds.collect{"'$it'"}.sort()}\n" +
                "size: ${handpickedCompletelyNewIds.size()}\n"

        println "completely new - handpicked completely new: ${completelyNewItemIds - handpickedCompletelyNewIds}\n"

        deletedItemIds.removeIf({it == ''})
        println "Deleted Item Ids: $deletedItemIds\n" +
                "size: ${deletedItemIds.size()}\n"




        allChangedIds.removeIf({it == ''})
        println "All changed item Ids: $allChangedIds\n" +
                "size: ${allChangedIds.size()}\n"


        List<String> justModified = (allChangedIds - deletedItemIds) - completelyNewItemIds//((allChangedIds.toSet() - deletedItemIds.toSet()) - completelyNewItemIds.toSet()).toList()
        println "Just modified: $justModified\n" +
                "size: ${justModified.size()}, should equal allChanged.size - deletedItems.size - completelyNew.size = ${allChangedIds.size() - deletedItemIds.size() - completelyNewItemIds.size()}\n"



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
        handPickedCompletelyNewItemIds: ['CR6000', 'CR6230', 'CR6400', 'CR6430', 'CR6440', 'CR6450', 'CR6460', 'CR6470', 'CR6100', 'CR6110', 'CR6120', 'CR6130', 'CR6140', 'CR6150', 'CR6160', 'CR6170', 'CR6180', 'CR6190', 'CR6200', 'CR6480', 'CR6300', 'CR6010', 'CR6310', 'CR6220', 'CR6490', 'CR6410', 'CR6420', 'BA3200', 'BA3210', 'CO5400', 'CT6990', 'CT7020', 'CT7200', 'CT7240', 'CT7160', 'CT7170', 'CT7180', 'CT7030', 'CT7400', 'CT7260', 'CT7270', 'CT7380', 'CT7310', 'CT7150', 'CT7070', 'CT7000', 'CT7010', 'CT7110', 'CT7190', 'CT7390', 'CT7370', 'CT7120', 'CT7130', 'CT7140', 'CT7050', 'CT7060', 'CT7040', 'CT7320', 'CT7330', 'CT7340', 'CT7350', 'CT7360', 'CT7080', 'CT7090', 'GY7460', 'GY7450', 'LU10300', 'LU10310', 'LU10340', 'LU10350', 'LU10360', 'LU10420', 'LU10370', 'LU10390', 'SK12710', 'SK12720', 'SK12730', 'SK12740', 'SK12700', 'SK12510', 'UR15400'])

        processCOSD(cosd_7_0_6_config)
        println "======\n\n======"
        Config cosd_8_0_1_config = new Config(version: "8.0.1", workbookPath: 'org/modelcatalogue/COSD_Dataset_v8_0_1_Final.xls', handPickedDeletedItemIds: [], handPickedCompletelyNewItemIds: [])
//        processCOSD(cosd_8_0_1_config)
    }
}
