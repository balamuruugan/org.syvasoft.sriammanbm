/*
Jayaprakash treatment
 Keep [jayaprakesh nillakotti] for Vendor
 Delete opening entries for [jayaprakesh madicine] and disable it.
 Disable [jayaprakash nillakottai madicine] -- no opening entries..
 Keep [JAYAPRAKASH NILLAKOTTI] for Customer -- opening entry for customer (DON"T DELETE Opening Entry).
*/


--Opening Balance Entry | {->91)

--C_AllocationHdr Journal Entries
DELETE FROM Fact_Acct WHERE AD_Table_ID=735 AND Record_ID IN 
  (SELECT C_AllocationHdr_ID FROM C_AllocationLine WHERE C_Invoice_ID IN 
    (SELECT C_Invoice_ID FROM C_Invoice WHERE C_BPartner_ID = 1000022 AND Description LIKE 'Opening Balance Entry%' ) );
	
	

--C_Invoice Journal Entries
DELETE FROM Fact_Acct WHERE AD_Table_ID=318 AND Record_ID IN 
 (SELECT C_Invoice_ID FROM C_Invoice WHERE C_BPartner_ID = 1000022 AND Description LIKE 'Opening Balance Entry%');


-- Delete C_AllocationHdr and Line Records
DELETE FROM C_AllocationLine WHERE C_AllocationHdr_ID IN 
 (SELECT C_AllocationHdr_ID FROM C_AllocationLine WHERE C_Invoice_ID IN
   (SELECT C_Invoice_ID FROM C_Invoice WHERE C_BPartner_ID = 1000022 AND Description LIKE 'Opening Balance Entry%') );



DELETE FROM C_AllocationHdr WHERE C_AllocationHdr_ID NOT IN
 (SELECT l.C_AllocationHdr_ID FROM C_AllocationLine l WHERE l.C_AllocationHdr_ID = C_AllocationHdr.C_AllocationHdr_ID );
 --SELECT * FROM C_AllocationHdr WHERE C_AllocationHdr_ID NOT IN (SELECT l.C_AllocationHdr_ID FROM C_AllocationLine l WHERE l.C_AllocationHdr_ID = C_AllocationHdr.C_AllocationHdr_ID );


DELETE FROM C_InvoiceLine WHERE C_INvoice_ID IN 
	(SELECT C_Invoice_ID FROM C_Invoice WHERE C_BPartner_ID = 1000022 AND Description LIKE 'Opening Balance Entry%' ) ;
DELETE FROM C_InvoiceTax WHERE C_Invoice_ID  IN 
	(SELECT C_Invoice_ID FROM C_Invoice WHERE C_BPartner_ID = 1000022 AND Description LIKE 'Opening Balance Entry%' ) ;
UPDATE C_BPartner SET C_Invoice_ID = NULL WHERE C_BPartner_ID = 1000022 ;
DELETE FROM C_Invoice WHERE C_INvoice_ID  IN 
	(SELECT C_Invoice_ID FROM C_Invoice WHERE C_BPartner_ID = 1000022 AND Description LIKE 'Opening Balance Entry%' ) ;

--UPDATE C_BPartner SET TotalOpenBalance = 127575.00 WHERE C_BPartner_ID = 1000022;
-- Set it based on Vendor/Customer Statement

DELETE FROM ad_changelog WHERE ad_client_id=1000000 AND AD_Column_ID = 12533 AND Record_ID = 1000022;
 
 -- SET OPENING BALANCE 8,950.00

-- Allocate Open Payments If Any

