package com.base;
import com.constants.logout.Logout;
import com.source.POcreate.CreatePOnoncatalog;
import com.source.POcreate.POSendforApproval.POsendapprovalnoncatalog;
import com.source.createPOR.Buyerloginnoncatalog;
import com.source.createPOR.CreatePORnoncatalog;
import com.source.createPOR.PORSendforapproval.PoRsendforApprovalnoncatalog;
import com.source.createPOR.approvePOR.ApprovePORnoncatalog;
import com.source.createRFQ.*;
import com.source.invoice.Invoicenoncatalog;
import com.source.invoice.orderschedule.OrderscheduleApprovenonctlog;
import com.source.invoice.invoiceApprove.InvoiceApprovenoncatalog;
import com.source.invoice.invoicechecklist.Invoicechecklistnoncatalog;
import com.source.invoice.invoicesendforApproval.InvoicesendApprovalnoncatalog;
import com.source.requisition.Approvers.Approvers;
import com.source.createPOR.PORSendforapproval.PORsendforApproval;

import com.source.POcreate.POSendforApproval.POSendforapproval;
import com.source.POcreate.CreatePO;
import com.source.createPOR.approvePOR.ApprovePOR;
import com.source.createPOR.Buyerlogin;
import com.source.guestvendorlogin.Guestvendorlogin;
import com.source.requisition.Approvers.Approversnoncatalog;
import com.source.requisition.create.Createnoncatalog;
import com.source.requisition.sendforapproval.SendforApprovalnoncatalog;
import com.source.vendor.inspection.Inspection;
import com.source.vendor.inspection.Inspectionnoncatalog;
import com.source.vendor.inspectionlogin.Inspectionrequestloginnonctlog;
import com.source.vendor.inspectionlogin.Inspectionrequestorlogin;
import com.source.invoice.Invoice;
import com.source.invoice.invoiceApprove.InvoiceApprove;
import com.source.invoice.invoicechecklist.Invoicechecklist;
import com.source.invoice.invoicesendforApproval.InvoicesendforApproval;
import com.source.login.Login;
import com.source.nonCatalogcreate.InviteGuestVendor;
import com.source.invoice.orderschedule.OrderscheduleApprove;
import com.source.requisition.create.Create;
import com.source.requisition.sendforapproval.SendforApproval;
import com.source.vendor.Vendorlogin;
import com.source.vendor.inspectionlogin.Vendorloginnoncatalog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseMain {
    protected  WebDriver WebDriver;
    protected WebDriverWait wait;
    protected FileInputStream fileInputStream;
    protected FileOutputStream fileOutputStream;
    protected Properties properties;
    protected WebDriver webDriver;
    protected Login login;
    protected Logout logout;
    protected Create create;// catalog flow
    protected SendforApproval sendforApproval;
    protected  Approvers approvers;
    protected Buyerlogin  buyerlogin;
    protected PORsendforApproval porSendforApproval;
    protected ApprovePOR approvePOR;
    protected CreatePO createPO;
    protected POSendforapproval poSendforapproval;
    protected Vendorlogin vendorlogin;
    protected OrderscheduleApprove orderScheduleApprove;
    protected Invoice invoice;
    protected Inspection inspection;
    protected Inspectionrequestorlogin inspectionrequestorlogin;
    protected InvoiceApprove invoiceApprove;
    protected Invoicechecklist invoicechecklist;
    protected InvoicesendforApproval invoicesendforApproval;

    protected InviteGuestVendor inviteguestvendor;
    protected Guestvendorlogin guestvendorlogin;

    protected Createnoncatalog createnoncatalog;
    protected SendforApprovalnoncatalog sendforApprovalnoncatalog;
    protected Approversnoncatalog approversnoncatalog;
    protected Buyerloginnoncatalog buyerloginnoncatalog;
    protected CreateRFQ createRFQ;
    protected VendorloginRFQ vendorloginRFQ;
    protected RFQ rfq;
    protected RFQsendforApproval rfQsendforApproval;
    protected RFQApprover rfqApprover;
    protected RFQcreateCE rfQcreateCE;
    protected CreatePORnoncatalog createPORnoncatalog;
    protected PoRsendforApprovalnoncatalog poRsendforApprovalnoncatalog;
    protected ApprovePORnoncatalog approvePORnoncatalog;
    protected CreatePOnoncatalog createPOnoncatalog;
    protected POsendapprovalnoncatalog pOsendapprovalnoncatalog;
    protected Vendorloginnoncatalog vendorloginnoncatalog;
    protected OrderscheduleApprovenonctlog orderscheduleApprovenonctlog;
    protected Inspectionnoncatalog inspectionnoncatalog;
    protected Inspectionrequestloginnonctlog inspectionrequestloginnonctlog;
    protected Invoicenoncatalog invoicenoncatalog;
    protected Invoicechecklistnoncatalog invoicechecklistnoncatalog;
    protected InvoicesendApprovalnoncatalog invoicesendApprovalnoncatalog;
    protected InvoiceApprovenoncatalog invoiceApprovenoncatalog;


    public BaseMain(){
        try {
            properties = new Properties();
            fileInputStream = new FileInputStream("src/test/resources/config/Properties");
            fileOutputStream = new FileOutputStream("src/test/resources/config/Properties");
            properties.load(fileInputStream);
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Harika\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.get("https://dprocure-uat.cormsquare.com");
            webDriver.manage().window().maximize();
            wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));

//TODO Login Object
            login = new Login(webDriver);//catalog flow
            logout = new Logout(wait);
            create = new Create(webDriver, login, properties, wait, logout);
            sendforApproval = new SendforApproval(login, logout , wait);
            approvers = new Approvers(webDriver, wait, login, logout);
            buyerlogin = new Buyerlogin(webDriver, wait, login, logout, properties);
            porSendforApproval = new PORsendforApproval(login, logout, wait);
            approvePOR = new ApprovePOR(webDriver, wait, login, logout);
            createPO = new CreatePO(login, logout, wait ,webDriver, fileOutputStream, properties);
            poSendforapproval =new POSendforapproval(login, logout , wait ,webDriver);
            vendorlogin = new Vendorlogin(login, logout, wait ,webDriver);
            orderScheduleApprove = new OrderscheduleApprove(webDriver, wait, login, logout);
            invoice = new Invoice(webDriver, wait, login, logout , properties);
            inspection = new Inspection(login , logout , wait ,webDriver);
            inspectionrequestorlogin = new Inspectionrequestorlogin(login , logout , wait ,webDriver ,properties );
            invoiceApprove = new InvoiceApprove(webDriver, wait, login, logout);
            invoicechecklist =new Invoicechecklist(webDriver, wait, login, logout , properties);
            invoicesendforApproval = new InvoicesendforApproval(login, logout, wait);

            inviteguestvendor = new InviteGuestVendor(webDriver, wait, login, logout, webDriver, properties);
            guestvendorlogin = new Guestvendorlogin(webDriver, properties, wait);

            createnoncatalog = new Createnoncatalog(webDriver, login, properties, wait, logout);
            sendforApprovalnoncatalog =new SendforApprovalnoncatalog(login, logout , wait);
            approversnoncatalog = new Approversnoncatalog(webDriver, wait, login, logout);
            buyerloginnoncatalog = new Buyerloginnoncatalog(webDriver, wait, login, logout, properties);
            createRFQ = new CreateRFQ(webDriver, wait, login, logout, properties);
            vendorloginRFQ = new VendorloginRFQ(login, logout, wait ,webDriver);
            rfq = new RFQ(login, logout, wait ,webDriver);
            rfQsendforApproval = new RFQsendforApproval(login, logout , wait ,webDriver);
            rfqApprover = new RFQApprover(webDriver, wait, login, logout);
            rfQcreateCE =new RFQcreateCE(login, logout , wait ,webDriver);
            createPORnoncatalog = new CreatePORnoncatalog(webDriver, wait, login, logout, properties);
            poRsendforApprovalnoncatalog =new PoRsendforApprovalnoncatalog(login, logout , wait);
            approvePORnoncatalog  = new ApprovePORnoncatalog(webDriver, wait, login, logout);
            createPOnoncatalog = new CreatePOnoncatalog(login, logout, wait ,webDriver, fileOutputStream, properties);
            pOsendapprovalnoncatalog =new POsendapprovalnoncatalog(login, logout , wait ,webDriver);
            vendorloginnoncatalog = new Vendorloginnoncatalog(login, logout, wait ,webDriver);
            orderscheduleApprovenonctlog =new OrderscheduleApprovenonctlog(webDriver, wait, login, logout);
            inspectionnoncatalog =new Inspectionnoncatalog(login , logout , wait ,webDriver);
            inspectionrequestloginnonctlog =new Inspectionrequestloginnonctlog(login , logout , wait ,webDriver ,properties );
            invoicenoncatalog =new Invoicenoncatalog(webDriver, wait, login, logout , properties);
            invoicechecklistnoncatalog =new Invoicechecklistnoncatalog(webDriver, wait, login, logout , properties);
            invoicesendApprovalnoncatalog =new InvoicesendApprovalnoncatalog(login, logout, wait);
            invoiceApprovenoncatalog =new InvoiceApprovenoncatalog(webDriver, wait, login, logout);


        } catch(Exception exception) {
            System.out.println("Error in initializing BaseMain Function");
        }


    }

}


//TODO Commit for identification

