package org.modelcatalogue

class ModificationData {

    static String optionalSchemaSpec = 'Optional'
    /**
     * 
     * Produced from categorizeModifications method, which analysed the spreadsheet, and then edited by hand
     * // Note GY7190 is written in the spreadsheet with a space or newline...

     // The method missed 13 things from COSMETIC_CHANGES:

     // CR0020
     // CR3170
     // CR3160
     // CT6750, (belongs with CT6350 etc.)
     // CT6710, CT6720, CT6740, CT6770, CT6800 (belongs with CT6250 etc.)
     // CT6760, (belongs with CT6560)
     // HA8720, HA8680, (belongs with HA8280 etc.)
     // SK12630

     // The program found 186 modified things (deduped), adding 13 gives 199, which is the same deduped figure calculated from all changed - deleted - completely new

     // Also, the editors forgot to put some changes from Haematology (['HA8240', 'HA8700', 'HA8560', 'HA8710']) into COSMETIC_CHANGES.

     Also, the following CT6*** items were not found in the catalogue, as they are listed with their HA8*** ids:

     Data Element CT6720 not found (ANN ARBOR STAGE DATE) (HA8720)
     Data Element CT6270 not found (ANN ARBOR STAGE) (HA8280)
     Data Element CT6280 not found (ANN ARBOR SYMPTOMS) (HA8290)
     Data Element CT6290 not found (ANN ARBOR EXTRANODALITY) (HA8300)

     These were put into a separate modification group that uses their HA8*** ids to find them.

     Similarly:

     Data Element CT6470 not found (SARCOMA TUMOUR SITE (BONE)) (SA11000)
     Data Element CT6440 not found (SARCOMA TUMOUR SUBSITE (BONE)) (SA11010)
     Data Element CT6220 not found (WHITE BLOOD CELL COUNT (HIGHEST PRE TREATMENT)) (HA8150)

     */
    static final List<ModificationGroup> COSD_v7_0_6_substantial_and_cosmetic_change_modifications = [
            new ModificationGroup(ids: ['BR4140', 'BR4160', 'BR4170', 'BR4180', 'BR4190', 'BR4200', 'BR4210', 'BR4230', 'BR4220', 'BR4300', 'BR4290', 'BR4280', 'BR4310', 'BR4240', 'BR4250', 'BR4260', 'BR4270'],
                    modifications: [new ModMoveToCorePathology(['BREAST - PATHOLOGY  '])]),

            new ModificationGroup(ids: ['BA3070'],
                    modifications: [new ModChangesToEnums('BA3070', ['06':'Evidence of ALK rearrangement',
                                                                     '07':'Evidence of native ALK',
                                                                     '08':'Evidence of ATRX mutation',
                                                                     '09':'Evidence of wt ATRX',
                                                                     '10':'Evidence of BRAF V600E mutation',
                                                                     '11':'Evidence of wt BRAF',
                                                                     '12':'Evidence of KIAA1549-BRAF fusion',
                                                                     '13':'Evidence of BRAF/RAF1 mutations, or fusions involving genes other than KIAA1549',
                                                                     '14':'Evidence of C11orf95-RELA fusion',
                                                                     '15':'Evidence of native C11orf95 and RELA',
                                                                     '16':'Evidence of amplification or fusion of C19MC locus (chr.19q13.42)',
                                                                     '17':'Evidence of unaltered C19MC locus (chr.19q13.42)',
                                                                     '18':'Evidence of CDK4/6 amplification',
                                                                     '19':'Evidence of CDK4/6 normal copy number',
                                                                     '20':'Evidence of CDKN2A locus homozygous deletion',
                                                                     '21':'Evidence of CDKN2A locus normal copy number',
                                                                     '22':'Evidence of CCND1/2/3 amplification',
                                                                     '23':'Evidence of CCND1/2/3 normal copy number',
                                                                     '24':'Evidence of CTNNB1 mutation ',
                                                                     '25':'Evidence of wt CTNNB1',
                                                                     '26':'Evidence of amplification of EGFR ',
                                                                     '27':'Evidence of mutation / rearrangement of EGFR',
                                                                     '28':'Evidence of unaltered EGFR',
                                                                     '29':'Evidence of EWSR1-FLI1 fusion',
                                                                     '30':'Evidence of native EWSR1 and FLI1',
                                                                     '31':'Evidence of FGFR1 mutation / rearrangement / fusion',
                                                                     '32':'Evidence of unaltered FGFR1',
                                                                     '33':'Evidence of H3F3A/H3F3B (H3.3) K27M mutation',
                                                                     '34':'Evidence of H3F3A/H3F3B (H3.3) wt K27',
                                                                     '35':'Evidence of H3F3A/H3F3B (H3.3) G34R/V mutation',
                                                                     '36':'Evidence of H3F3A/H3F3B (H3.3) wt G34',
                                                                     '37':'Evidence of HIST1H3B K27M mutation',
                                                                     '38':'Evidence of HIST1H3B wt K27',
                                                                     '39':'Evidence of HIST1H3C K27M mutation',
                                                                     '40':'Evidence of HIST1H3C wt K27',
                                                                     '41':'Evidence of ID2 amplification',
                                                                     '42':'Evidence of ID2 normal copy number',
                                                                     '43':'IDH1 (codon 132) or IDH2 (codon 172) mutation identified',
                                                                     '44':'IDH1 (codon 132) and IDH2 (codon 172) wt confirmed',
                                                                     '45':'Evidence of KLF4 K409Q and TRAF7 mutations',
                                                                     '46':'Evidence of wt KLF4 and TRAF7',
                                                                     '47':'Evidence of MAP2K1 mutation',
                                                                     '48':'Evidence of wt MAP2K1 ',
                                                                     '49':'Evidence of MET amplification',
                                                                     '50':'Evidence of MET normal copy number ',
                                                                     '51':'Evidence of significant MGMT promoter methylation',
                                                                     '52':'Evidence of unmethylated MGMT promoter',
                                                                     '53':'Evidence of MYC/MYCN amplification',
                                                                     '54':'Evidence of MYC/MYCN normal copy number ',
                                                                     '55':'Evidence of NF1 biallelic loss / mutation',
                                                                     '56':'Evidence of unaltered NF1',
                                                                     '57':'Evidence of NF2 biallelic loss / mutation',
                                                                     '58':'Evidence of unaltered NF2',
                                                                     '59':'Evidence of NKTR fusions ',
                                                                     '60':'Evidence of native NKTR',
                                                                     '61':'Evidence of PTEN biallelic loss / mutation',
                                                                     '62':'Evidence of unaltered PTEN',
                                                                     '63':'Evidence of SDHB or SDHD mutation',
                                                                     '64':'Evidence of wt SDHB and SDHD',
                                                                     '65':'Evidence of SHH pathway activation',
                                                                     '66':'Evidence of normal SHH pathway',
                                                                     '67':'Evidence of inactivation of SMARCB1 (INI1)',
                                                                     '68':'Evidence of wt SMARCB1 (INI1)',
                                                                     '69':'Evidence of inactivation of SMARCA4 ',
                                                                     '70':'Evidence of wt SMARCA4 ',
                                                                     '71':'Evidence of TERT promotor mutation ',
                                                                     '72':'Evidence of wt TERT promotor',
                                                                     '73':'Evidence  of TP53 mutation ',
                                                                     '74':'Evidence of wt TP53',
                                                                     '75':'Evidence of TSC1 or TSC2 mutation',
                                                                     '76':'Evidence of wt TSC1 and TSC2',
                                                                     '77':'Evidence of VHL mutation',
                                                                     '78':'Evidence of wt VHL gene',
                                                                     '79':'Evidence of WNT pathway activation',
                                                                     '80':'Evidence of normal WNT pathway',
                                                                     '81':'Evidence of WWTR1-CAMTA1 fusion',
                                                                     '82':'Evidence of native WWTR1 and CAMTA1 ',
                                                                     '83':'Evidence of codeletion of chr.1p and chr.19q',
                                                                     '84':'Evidence of total chr.1p loss but normal copy number of chr.19q',
                                                                     '85':'Evidence of normal copy number of both chr.1p and chr.19q',
                                                                     '86':'Evidence of monosomy chr.6',
                                                                     '87':'Evidence of chr.6 normal copy number',
                                                                     '88':'Evidence of polysomy chr.7',
                                                                     '89':'Evidence of chr.7 normal copy number',
                                                                     '90':'Evidence of loss of chr.10 or chr.10q',
                                                                     '91':'Evidence of chr.10 normal copy number',
                                                                     '92':'Evidence of loss of chr.22 or chr.22q',
                                                                     '93':'Evidence of chr.22 or chr.22q normal copy number',
                                                                     '98':'Other',
                                                                     '99':'Not Known (Not Recorded)'])]),

            new ModificationGroup(ids: ['BA3150', 'BA3160'],
                    modifications: [new ModMoveToCorePathology(['CNS - PATHOLOGY '])]),
            new ModificationGroup(ids: ['CO5190', 'CO5210'],
                    modifications: [new ModMoveToCorePathology(['COLORECTAL - PATHOLOGY'])]),
            new ModificationGroup(ids: ['CO5260', 'CO5270', 'CO5280', 'CO5290', 'CO5300'],
                    modifications: [new ModMoveToCorePathology(['COLORECTAL - PATHOLOGY'])]),


            new ModificationGroup(ids: ['CT6610', 'CT6620', 'CT6630', 'CT6640', 'CT6650', 'CT6660', 'CT6670'],
                    modifications: [new ModMoveToCorePathology(['CTYA -  RENAL PATHOLOGY (Paediatric Kidney)'])]),
            new ModificationGroup(ids: ['GY7050', 'GY7120', 'GY7130', 'GY7100', 'GY7140', 'GY7190', 'GY7150', 'GY7170', 'GY7180', 'GY7240', 'GY7260', 'GY7270', 'GY7280'],
                    modifications: [new ModMoveToCorePathology(['GYNAECOLOGY - PATHOLOGY',
                                                                'GYNAECOLOGY - PATHOLOGY - FALLOPIAN TUBE, OVARIAN EPITHELIAL and PRIMARY PERITONEAL',
                                                                'GYNAECOLOGY - PATHOLOGY - ENDOMETRIAL']),]),

            new ModificationGroup(ids: ['GY7280'],
                    modifications: [new ModChangesToEnums('GY7280', ['P':'Positive ',
                                                                     'N':'Negative',
                                                                     'X':'Not sent/Not assessable'])]),

            new ModificationGroup(ids: ['GY7220'],
                    modifications: [new ModMoveToCorePathology(['GYNAECOLOGY - PATHOLOGY -ENDOMETRIAL']),
                                    new ModChangesToSchemaSpec('GY7220', optionalSchemaSpec)]),
            new ModificationGroup(ids: ['GY7290', 'GY7300', 'GY7350', 'GY7310', 'GY7340', 'GY7360', 'GY7370', 'GY7020', 'GY7060', 'GY7080', 'GY7070', 'GY7090', 'GY7410', 'GY7420', 'GY7230'],
                    modifications: [new ModMoveToCorePathology(['GYNAECOLOGY - PATHOLOGY - CERVICAL',
                                                                'GYNAECOLOGY - PATHOLOGY - NODES'])]),

            new ModificationGroup(ids: ['HA8270'],
                    modifications: [
                            new ModNewSectionInDiseaseGroup(['HA8270'], // standing in for CT6210
                                    'CTYA', 'DIAGNOSIS'),
                            new ModChangesToEnums('HA8270', ['1':'CNS1 ( without blasts)',
                                                                     '2':'CNS2 (< 5 WBC in the CSF with blasts)',
                                                                     '3':'CNS3 (≥5 WBC in the CSF with blasts)',
                                                                     '4':'Testes',
                                                                     '9':'Other'])]),

            new ModificationGroup(ids: ['HN9300', 'HN9310', 'HN9320', 'HN9330', 'HN9380', 'HN9390', 'HN9400', 'HN9410', 'HN9420', 'HN9430'],
                    modifications: [new ModMoveToCorePathology(['HEAD & NECK -PATHOLOGY - VARIOUS',
                                                                'HEAD & NECK -PATHOLOGY - SALIVARY',
                                                                'HEAD & NECK -PATHOLOGY - GENERAL and SALIVARY'])]),

            new ModificationGroup(ids: ['LU10090'],
                    modifications: [new ModChangesToEnums('LU10090', ['3':'Failed analysis',
                                                                      '4':'Not assessed',
                                                                      '5':'Wild type/non-sensitising mutation ',
                                                                      '6':'Sensitising/activating mutation '])]),

            new ModificationGroup(ids: ['LU10100', 'LU10110', 'LU10120', 'LU10130', 'LU10140', 'LU10150', 'LU10160', 'LU10170', 'LU10180'],
                    modifications: [new ModMoveToCorePathology(['LUNG - PATHOLOGY '])]),

            new ModificationGroup(ids: ['SA11120', 'SA11170', 'SA11130', 'SA11140'],
                    modifications: [new ModMoveToCorePathology(['SARCOMA - PATHOLOGY', 'SARCOMA - PATHOLOGY - BONE'])]),

            new ModificationGroup(ids: ['SA11100', 'SA11220'],
                    modifications: [new ModMoveToCorePathology(['SARCOMA - PATHOLOGY - SOFT TISSUE'])]),

            new ModificationGroup(ids: ['SK12450'],
                    modifications: [new ModRealignSecondLevel(['SK12450'], '- PATHOLOGY', '- DIAGNOSIS')]),
            new ModificationGroup(ids: ['SK12030'],
                    modifications: [new ModRealignSecondLevel(['SK12030'], '- GENERAL', '- DIAGNOSIS')]),
            new ModificationGroup(ids: ['SK12010'],
                    modifications: [new ModRealignSecondLevel(['SK12010'], '- GENERAL', '- SURGERY AND OTHER PROCEDURES'),
                    new ModChangesToEnums('SK12010', ['NU':'NURSE',
                                           'TS':'TRAINEE SPECIALIST DOCTOR',
                                           'CS':'CONSULTANT SURGEON (other than Plastic Surgeon)',
                                           'CD':'CONSULTANT DERMATOLOGIST',
                                           'CPS':'CONSULTANT PLASTIC SURGEON',
                                           'HP':'HOSPITAL PRACTITIONER',
                                           'SI':'GP WITH SPECIAL INTEREST',
                                           'GP':'GENERAL PRACTITIONER',
                                           'OO':'OTHER'])]),

            new ModificationGroup(ids: ['SK12120'],
                    modifications: [new ModMoveToCorePathology(['SKIN - GENERAL - BCC, SCC & MM '])]),
            new ModificationGroup(ids: ['SK12530', 'SK12537', 'SK12650', 'SK12660', 'SK12545', 'SK12565', 'SK12580', 'SK12590', 'SK12600', 'SK12620', 'SK12630', 'SK12430', 'SK12460', 'SK12470', 'SK12480', 'SK12490'],
                    modifications: [new ModMoveToCorePathology(['SKIN - PATHOLOGY - BCC & SCC', 'SKIN - PATHOLOGY - SCC & MM', 'SKIN - PATHOLOGY - SCC', 'SKIN - PATHOLOGY - MM'])]),
            new ModificationGroup(ids: ['UG14470', 'UG14480', 'UG14490'],
                    modifications: [new ModMoveToCorePathology(['UPPER GI -  PATHOLOGY - LIVER METS',
                                                                'UPPER GI - PATHOLOGY - OESOPHAGEAL AND STOMACH',
                                                                'UPPER GI -PATHOLOGY - OESOPHAGEAL, OG JUNCTION, PANCREAS, BILE DUCT, LCC, LIVER HCC AND LIVER METS'])]),
            new ModificationGroup(ids: ['UR15120', 'UR15290', 'UR15130', 'UR15140', 'UR15150', 'UR15160', 'UR15170', 'UR15180', 'UR15190', 'UR15200', 'UR15210', 'UR15220', 'UR15230', 'UR15240', 'UR15250', 'UR15260', 'UR15270', 'UR15310'],
                    modifications: [new ModMoveToCorePathology(['UROLOGY - PATHOLOGY - BLADDER',
                                                                'UROLOGY - PATHOLOGY - KIDNEY',
                                                                'UROLOGY- PATHOLOGY - PENIS',
                                                                'UROLOGY - PATHOLOGY - PROSTATE',
                                                                'UROLOGY - PATHOLOGY - TESTICULAR'])]),
            // END OF SUBSTANTIAL CHANGES

            // Cosmetic Changes: Some "realigned", "regrouped"

            new ModificationGroup(ids: ['CR0020'],
                    modifications: [new ModManual(['CR0020'], "format 'max an20'")]),
            new ModificationGroup(ids: ['CR3170'],
                    modifications: [new ModChangesToEnums('CR3170', ['1':'Male',
                                                                     '2':'Female',
                                                                     '9':'Indeterminate (Unable to be classified as either male or female) ',
                                                                     'X':'Not Known (PERSON STATED GENDER CODE not recorded)'])]),
            new ModificationGroup(ids: ['CR0180'],
                    modifications: [new ModManual(['CR0180'], "Data Dictionary Name change to 'MORPHOLOGY (ICD-O DIAGNOSIS)'")]),
            new ModificationGroup(ids: ['CR3160'],
                    modifications: [new ModManual(['CR3160'], "format 'max an60'")]),
            new ModificationGroup(ids: ['CR0510'],
                    modifications: [new ModRealignSecondLevel(['CR0510'], '- CANCER CARE PLAN', '- DIAGNOSIS')]),
            new ModificationGroup(ids: ['CR2070'],
                    modifications: [new ModManual(['CR2070'], "description changed to 'The AJCC (Skin) or UICC edition number used for Tumour, Node and Metastasis (TNM) staging for cancer diagnosis.'")]),

            new ModificationGroup(ids: ['CR3040', 'CR3050'],
                    modifications: [new ModChangesToSchemaSpec('CR3040', optionalSchemaSpec),
                    new ModChangesToSchemaSpec('CR3050', optionalSchemaSpec)]),

            new ModificationGroup(ids: ['CT6350', 'CT6750', 'CT6380', 'CT6390', 'CT6450', 'CT6230', 'CT6240'] + ['SA11000', 'SA11010', 'HA8150'],
                    modifications: [new ModNewSectionInDiseaseGroup(['CT6350', 'CT6750', 'CT6380', 'CT6390', 'CT6450', 'CT6230', 'CT6240'] + ['SA11000', 'SA11010', 'HA8150'],
                            'CTYA', 'DIAGNOSIS')]),
            new ModificationGroup(ids: ['CT6130', 'CT6140'],
                    modifications: [new ModNewSectionInDiseaseGroup(['CT6130', 'CT6140'],
                    'CTYA', 'SURGERY AND OTHER PROCEDURES')]),

            new ModificationGroup(ids: ['CT6710',  'CT6740', 'CT6770', 'CT6800', 'CT6250',  'CT6330', 'CT6500', 'CT6510', 'CT6590'] + ['HA8720', 'HA8280', 'HA8290', 'HA8300'],
                    modifications: [new ModNewSectionInDiseaseGroup(['CT6710',  'CT6740', 'CT6770', 'CT6800', 'CT6250',  'CT6330', 'CT6500', 'CT6510', 'CT6590'] + ['HA8720', 'HA8280', 'HA8290', 'HA8300'],
                    'CTYA','STAGING')]),

            new ModificationGroup(ids: ['CT6560', 'CT6760'],
                    modifications: [new ModManual(['CT6560', 'CT6760'], "section, name, description, national codes")]),

            new ModificationGroup(ids: ['CT6310', 'CT6360', 'CT6460', 'CT6530', 'CT6550', 'CT6580', 'CT6520'],
                    modifications: [new ModNewSectionInDiseaseGroup(['CT6310', 'CT6360', 'CT6460', 'CT6530', 'CT6550', 'CT6580', 'CT6520'],
                    'CTYA', 'LABORATORY RESULTS'),
                    new ModManual(['CT6360'], "make data class 'CTYA -LABORATORY RESULTS - RHABDOMYOSARCOMA and OTHER SOFT TISSUE SARCOMAS'. Yes, you have to introduce a typo.")]),

            new ModificationGroup(ids: ['HA8660'],
                    modifications: [new ModManual(['HA8660'], "data type 'Range 0.0 to 999.9  (to 1dp)'")]),
            new ModificationGroup(ids: ['HA8720', 'HA8680', 'HA8280', 'HA8290', 'HA8300', 'HA8310'],
                    modifications: [new ModNewSectionInDiseaseGroup(['HA8720', 'HA8680', 'HA8280', 'HA8290', 'HA8300', 'HA8310'],
                    'HAEMATOLOGY - STAGING', 'ANN ARBOR')]),
            new ModificationGroup(ids: ['HA8240', 'HA8700', 'HA8560', 'HA8710'],
                    modifications: [new ModManual(['HA8240', 'HA8700', 'HA8560', 'HA8710'], "Changes not listed in SUBSTANTIAL/COSMETIC CHANGES but under Haematology! They missed this out...")]),

            new ModificationGroup(ids: ['LU10070', 'LU10080'],
                    modifications: [new ModNewSectionInDiseaseGroup(['LU10070', 'LU10080'],
                    'LUNG', 'SURGERY AND OTHER PROCEDURES')]),
            new ModificationGroup(ids: ['SK12030'],
                    modifications: [new ModRealignSecondLevel(['SK12030'], '- GENERAL', '- DIAGNOSIS')]),
            new ModificationGroup(ids: ['SK12450'],
                    modifications: [new ModRealignSecondLevel(['SK12450'], '- PATHOLOGY', '- DIAGNOSIS')]),
            new ModificationGroup(ids: ['SK12630'],
                    modifications: [new ModManual(['SK12630'], "Description changed to 'Breslow thickness in mm, can be recorded to nearest 0.01mm where clinically appropriate'")]),
            new ModificationGroup(ids: ['UG13100', 'UG13810'],
                    modifications: [new ModRealignSecondLevel(['UG13100', 'UG13810'],'-SURGICAL PROCEDURES', '- SURGICAL AND OTHER PROCEDURES')]),
            new ModificationGroup(ids: ['UG14210', 'UG14230', 'UG13240', 'UG13590', 'UG14290', 'UG13090', 'UG13250', 'UG13070', 'UG13080', 'UG13560', 'UG13580'],
                    modifications: [new ModNewSectionInDiseaseGroup(['UG14210', 'UG14230', 'UG13240', 'UG13590',  'UG13070', 'UG13080'],
                    'UPPER GI', 'SURGICAL AND OTHER PROCEDURES'),
                                    new ModNewSectionInDiseaseGroup(
                                    ['UG14290', 'UG13090', 'UG13250'],
                    'UPPER GI', 'SURGERY AND OTHER PROCEDURES'),
                                    new ModNewSectionInDiseaseGroup(['UG13560', 'UG13580'],
                    'UPPER GI', 'TREATMENT')]),
            new ModificationGroup(ids: ['UR15100', 'UR15110'],
                    modifications: [new ModManual(['UR15100', 'UR15110'], "descriptions changed")]),
            new ModificationGroup(ids: ['UG14210', 'UG14230', 'UG13240', 'UG13590'],
                    modifications: [new ModManual(['UG14210', 'UG14230', 'UG13240', 'UG13590'], "Script messed these data class names up")]),

            new ModificationGroup(ids: ['HA8300', 'HA8280', 'HA8720', 'HA8290', 'HA8270', 'SK12730', 'BA3030', 'UG14540', 'SK12530', 'CT6650', 'SA11000', 'SA11010', 'CO5000', 'HA8150'],
                    modifications:[
                            new ModCreateDuplicates('HA8300', 'CT6290', 'CTYA - STAGING - HODGKIN LYMPHOMA'),
                            new ModCreateDuplicates('HA8280', 'CT6270', 'CTYA - STAGING - HODGKIN LYMPHOMA'),
                            new ModCreateDuplicates('HA8720', 'CT6720', 'CTYA - STAGING - HODGKIN LYMPHOMA'),
                            new ModCreateDuplicates('HA8290', 'CT6280', 'CTYA - STAGING - HODGKIN LYMPHOMA'),

                            new ModCreateDuplicates('HA8270', 'CT6210', 'CTYA - DIAGNOSIS - ACUTE LYMPHOBLASTIC LEUKAEMIA and ACUTE MYELOID LEUKAEMIA'),
                            new ModCreateDuplicates('SK12730', 'CR6200', 'CORE - MOLECULAR AND BIOMARKERS - SOMATIC TESTING FOR TARGETED THERAPY AND PERSONALISED MEDICINE'),

                            new ModCreateDuplicates('BA3030', 'CR0350', 'CORE - IMAGING'),
                            new ModCreateDuplicates('UG14540', 'BA3020', 'CNS - IMAGING'),
                            new ModCreateDuplicates('SK12530', 'UR15240', 'UROLOGY - PATHOLOGY - PROSTATE'),
                            new ModCreateDuplicates('CT6650', 'UR15160', 'UROLOGY - PATHOLOGY - KIDNEY'),

                            new ModCreateDuplicates('SA11000', 'CT6470', 'CTYA - DIAGNOSIS - OSTEOSARCOMA and EWINGS'),
                            new ModCreateDuplicates('SA11010', 'CT6440', 'CTYA - DIAGNOSIS - OSTEOSARCOMA and EWINGS'),

                            new ModCreateDuplicates('CO5000', 'BR4025', 'BREAST - REFERRALS'),
                            new ModCreateDuplicates('CO5000', 'GY7030', 'GYNAECOLOGY - REFERRAL'),

                            new ModCreateDuplicates('HA8150', 'CT6220', 'CTYA - DIAGNOSIS - ACUTE LYMPHOBLASTIC LEUKAEMIA and ACUTE MYELOID LEUKAEMIA'),
                    ]),

    ]

    /**
     *
     * Produced from categorizeModifications method, which analysed the spreadsheet, and then edited by hand
     */
    static final List<ModificationGroup> COSD_v8_0_6_substantial_and_cosmetic_change_modifications = [
            new ModificationGroup(ids: ['CR1590'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR6970', 'CT7020'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR2050'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR1290'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR1260'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR1340'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR0680'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CO5290'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['GY7000'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR0020'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR0030'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR1410'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR1400'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR0300'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR1550'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CT7190'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR0310'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR6230'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CT6060', 'CT6070', 'CT6080', 'CT6090', 'CT6100', 'CT6990'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR3090'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR6140'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR6200'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR0520', 'CR0540', 'CR0560', 'CR0580', 'CR0620', 'CR0630', 'CR0640', 'CR0610', 'CR2070'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR1340'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR1450'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CT6130', 'CT6140', 'CT7370'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CT7040', 'UR15020', 'CT6580', 'CT6520'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR0950', 'CR6220'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR0980', 'CR0800'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CR0910', 'CR0920', 'CR0930', 'CR0940'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CT6420'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['BR4010'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CT7030', 'CT7400', 'CT6560', 'CT6760', 'CT7390', 'CT6530', 'CT6550'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CT7200', 'CT7240', 'CT7160', 'CT7170', 'CT7180', 'CT7260', 'CT7270', 'CT7380', 'CT7310', 'CT7150', 'CT6250', 'CT6710', 'CT7110'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['HA8360'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CT7330', 'CT6240', 'CT7340', 'CT7350', 'CT7360', 'CT7120', 'CT7130', 'CT7140', 'CT6260'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['CT6350', 'CT6750', 'CT6450', 'CT6370', 'CT6360', 'CT6460'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['SK12730'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['LU10310'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['LU10370'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['LV16100', 'LV16110', 'LV16120'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
            new ModificationGroup(ids: ['LV16300'],
                    modifications: [new ModNotLookedAtSpreadsheetYet()]),
    ]
}
