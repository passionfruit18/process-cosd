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

    String deletedForegroundHex = 'FFFF:0:0'
    String deletedFontColor = 'FFFF:0:0'
    String newEntryForegroundColorHex = '0:8080:0'
}

class ProcessCosd {

    /**
     * Notes on the fonts:
     * Green Foreground color index 17/hex string '0:8080:0' (e.g. CR6000) for new additions
     * Red Font color getHexString() FFFF:0:0 (e.g. CR0400), or Red Foreground color index 10/hex string 'FFFF:0:0', (e.g. CO5230) for removals
     */
    static void processCOSD(Config config) {
        println "COSD Version: ${config.version}"
        List<String> deletedItemIds = []
        List<String> allChangedIds = []
        List<String> completelyNewItemIds = []

        InputStream is = ProcessCosd.class.getClassLoader().getResourceAsStream(config.workbookPath)
        FrostedWorkbook workbook = FrostedWorkbook.readXLS(is)

        FrostedSheet substantialChangesSheet = workbook['SUBSTANTIAL CHANGES']
        FrostedSheet cosmeticChangesSheet = workbook['COSMETIC  CHANGES']
        
        Closure c = { Row row ->
            println row
            Cell c = row.getCell(0)
            HSSFCellStyle cs = c?.getCellStyle()
            HSSFFont font = cs?.getFont(workbook.getWorkbook())
            HSSFColor fontColor = font?.getHSSFColor((HSSFWorkbook) workbook.getWorkbook())

            println "${c?.stringCellValue}:\n" +
                    "Foreground color: ${cs?.fillForegroundColorColor?.hexString},\n" +
                    "Font color: ${fontColor?.getHexString()}"
            RichTextString
            println "===\n\n==="

            if (fontColor?.getHexString() == config.deletedFontColor || cs?.fillForegroundColorColor?.hexString == config.deletedForegroundHex) {
                deletedItemIds << c.stringCellValue
            }
            if (cs?.fillForegroundColorColor?.hexString == config.newEntryForegroundColorHex) {
                completelyNewItemIds << c.stringCellValue
            }
            if (c?.stringCellValue?.matches(/[A-Z]{1,4}[0-9]{1,10}/)) { // e.g. CO12345
                allChangedIds << c.stringCellValue
            }

        }
        substantialChangesSheet.each c
        cosmeticChangesSheet.each c
        

        // remove empty strings
        deletedItemIds.removeIf({it == ''})
        println "Deleted Item Ids: $deletedItemIds\n" +
                "size: ${deletedItemIds.size()}"

        completelyNewItemIds.removeIf({it == ''})
        println "Completely new item ids: ${completelyNewItemIds}\n" +
                "size: ${completelyNewItemIds.size()}"

        allChangedIds.removeIf({it == ''})
        println "All changed item Ids: $allChangedIds\n" +
                "size: ${allChangedIds.size()}"


        List<String> justModified = (allChangedIds - deletedItemIds) - completelyNewItemIds//((allChangedIds.toSet() - deletedItemIds.toSet()) - completelyNewItemIds.toSet()).toList()
        println "Just modified: $justModified\n" +
                "size: ${justModified.size()}, should equal allChanged.size - deletedItems.size - completelyNew.size = ${allChangedIds.size() - deletedItemIds.size() - completelyNewItemIds.size()}"


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
        Config config1 = new Config(version: "7.0.6", workbookPath: 'org/modelcatalogue/COSD_Dataset_v7_0_6_Final.xls',
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
                                   "UG13030", "UG14410", "UG13320"])
        println "Hello World"
        processCOSD(config1)

        Config config2 = new Config(version: "8.0.1", workbookPath: 'org/modelcatalogue/COSD_Dataset_v8_0_1_Final.xls', handPickedDeletedItemIds: [])
        processCOSD(config2)
    }
}
