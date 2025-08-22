package com.constants.requisitions.create;

public class PRCreate {

    public static final String REQUISITION_NAVIGATION_BAR = "ni-requisitions";

    public static final String CREATE_BUTTON_XPATH = "//*[@id=\"content\"]/div/div[2]/div/div[2]/button";
    public static final String CREATE_MODAL_ID = "createPRModal"; // Update if modal appears

    public static final String POC_CATALOG_XPATH = "//*[@id='createPRModal']/div/div/div[2]/div/div/div/table/tbody/tr[1]/td[1]/a";

    public static final String TITLE_INPUT = "//*[@id=\"title\"]";

    public static final String PROJECT_DROPDOWN = "//*[@id='select2-projectId-container']";
    public static final String PROJECT_SEARCH_BOX = "//input[@class='select2-search__field']";
    public static final String PROJECT_OPTION_TEXT = "//li[contains(@class,'select2-results__option') and text()='E256232Q00 - 20BW01-Satna Smart City Development']";

    public static final String WBS_DROPDOWN_XPATH = "//*[@id=\"select2-wbsId-container\"]";
    public static final String WBS_SEARCH_INPUT_XPATH = "//input[@class='select2-search__field']";
    public static final String WBS_OPTION_XPATH = "//li[contains(@class,'select2-results__option') and text()='J11DCSH']";

    public static final String VENDOR_DROPDOWN_XPATH = "select2-vendorId-container";
    public static final String VENDOR_SEARCH_BOX_CLASSNAME ="select2-search__field";

    public static final String RATECONTRACT_DROPDOWN_XPATH ="//*[@id='select2-rateContractId-container']";
    public static final String RATECONTRACT_SEARCH_XPATH ="//input[@class='select2-search__field']";

    public static final String SHIPPINGADDRESS_DROPDOWN_XPATH="//*[@id='select2-endusersId-container']";
    public static final String SHIPPINGADDRESS_SEARCH_XPATH="//input[@class='select2-search__field']";

    public static final String SHIPPINGMODE_DROPDOWN_XPATH="//*[@id=\"select2-shippingmodeid-container\"]";
    public static final String SHIPPINGMODE_SEARCH_XPATH="//input[@class='select2-search__field']";

    public static final String CHECKER_DROPDOWN_XPATH="//*[@id='select2-checkerId-container']";
    public static final String CHECKER_SEARCH_XPATH="//input[@class='select2-search__field']";

    public static final String PO_ISSUE_INPUT_XPATH = "//*[@id=\"dates\"]/div[2]/input[2]";
    public static final String DELIVERY_INPUT_XPATH = "//*[@id=\"dates\"]/div[3]/input[2]";
    public static final String QUOTATION_INPUT_XPATH = "//*[@id=\"dates\"]/div[1]/input[2]";

    public static final String BUYERGROUP_DROPDOWN_XPATH="//*[@id=\"select2-buyergroupid-container\"]/span";
    public static final String BUYERGROUP_SEARCH_XPATH="//input[@class='select2-search__field']";

    public static final String ITEM_DROPDOWN_XPATH="//*[@id='select2-itemid-container']";
    public static final String ITEM_SEARCH_XPATH="//input[@class='select2-search__field']";

    public static final String UPDATE_OITP_XPATH="(//*[@id='btnEdit'])[2]";

    public static final String ORDERINTAKECOSTINPUT_ID ="orderIntakeChangeId";

    public static final String TARGETPRICE_XPATH="//*[@id=\"targetPriceChangeId\"]";

    public static final String SUBMIT_BUTTON_ID="oiTpSubmit";

    public static final String ASSIGN_BUYER_DROPDOWN_XPATH="//*[@id='select2-bgUser-container']";
    public static final String ASSIGN_BUYER_SEARCH_XPATH="(//div[@id='modalUserAssign']//input)[1]";

    public static final String INSPECTOR_DROPDOWN_XPATH="//*[@id=\"select2-InspectionId-container\"]";
    public static final String INSPECTOR_SEARCH_XPATH="//*[@id=\"modalInspector\"]/span/span/span[1]/input";

    public static final String INVOICETYPE_DROPDOWN_XPATH="(//form[@id='createForm']//span[@class='select2-selection__rendered'])[1]";
    public static final String INVOICETYPE_SEARCH_XPATH="/html/body/span/span/span[1]/input";

    public static final String INVOICENUMBER_ID="invoiceNumber";

    public static final String PURCHASE_ORDER_DROPDOWN_XPATH="//div[@id='poContent']//span/span";
    public static final String PURCHASE_ORDER_SEARCH_XPATH="//input[@class='select2-search__field']";

    public static final String HEADER_TEXT_ID="headerText";

    public static final String BILL_LADING_ID="billOfLadding";

    public static final String POC_NONCATALOG_XPATH = "//*[@id=\"createPRModal\"]/div/div/div[2]/div/div/div/table/tbody/tr[2]/td[1]/a";

    public static final String INCOTERM_DROPDOWN_XPATH = "//*[@id=\"select2-incoterm-container\"]";
    public static final String INCOTERM_SEARCH_INPUT_XPATH = "//input[@class='select2-search__field']";
    public static final String INCOTERM_OPTION_XPATH = "//li[contains(@class,'select2-results__option') and text()='EXW - Ex Works ']";


    public static final String WARRANTY_DROPDOWN_XPATH = "//*[@id=\"select2-warrantyrequirementsid-container\"]/span";
    public static final String WARRANTY_SEARCH_BOX_XPATH ="//input[@class='select2-search__field']";

    public static final String PRICE_VADILITY_DROPDOWN_XPATH = "//*[@id=\"select2-pricevalidityid-container\"]/span";
    public static final String PRICE_VADILITY_SEARCHBOX_XPATH ="//input[@class='select2-search__field']";

    public static final String PURCHASE_DROPDOWN_XPATH = "//span[@aria-labelledby=\"select2-typeOfPurchaseId-container\"]";
    public static final String PURCHASE_SEARCHBOX_XPATH ="//input[@class='select2-search__field']";
    public static final String REQUEST_FOR_QUOTATION_ID = "ni-request-for-quotations";

    public static final String VENDORNAME_DROPDOWN_XPATH = "//*[@id=\"select2-vendorId-container\"]";
    public static final String VENDORNAME_SEARCH_BOX_XPATH ="//input[@class='select2-search__field']";

    public static final String QUOTATION_VADILITYDATE_XPATH ="//*[@id=\"dates\"]/input[2]";







    public static String getVendor(String vendorName) {return "//li[contains(text(), '"+ vendorName +"')]";
    }
    public static String getRatecontract(String rateContract){return "//li[contains(text(), '"+ rateContract +"')]";
    }
    public static String getShippingAddress(String shippingAddress){return "//li[contains(text(),'"+ shippingAddress +"')]";
    }
    public static String getShippingMode(String shippingMode){return "//li[contains(text(),'"+ shippingMode +"')]";
    }
    public static String getchecker(String checker){return "//li[contains(text(),'"+ checker+"')]";
    }
    public static String getbuyerGroup(String buyerGroup){return "//li[contains(text(),'"+ buyerGroup+"')]";
    }
    public static String getitem(String item) {return "//li[contains(text(),'"+ item +"')]";
    }
    public static String getassignbuyer(String assignbuyer){return "//li[contains(text(),'"+assignbuyer +"')]";
    }
    public static String getInspectorName(String InspectorName){return "//li[contains(text(),'"+InspectorName +"')]";
    }
    public static String getInvoicetype(String Invoicetype){return "//li[contains(text(),'"+Invoicetype +"')]";
    }
    public static String getpurchaseOrder(String purchaseOrder){return "//li[contains(text(),'"+purchaseOrder +"')]";
    }
    public static String getWarranty(String warrantyYear) {return "//li[contains(text(),'" + warrantyYear + "')]";
    }
    public static String getprice(String priceValidity){return "//li[contains(text(),'" + priceValidity + "')]";
    }
    public static String getPurchase(String purchase){return "//li[contains(text(),'" + purchase + "')]";
    }
    public static String getVendorName(String vendor) {return "//li[contains(text(), '"+ vendor +"')]";
    }
}


