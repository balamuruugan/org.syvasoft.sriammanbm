-- DROP VIEW TF_CashBookReport_V ;
-- SELECT * FROM TF_CashBookReport_V WHERE C_BankAccount_ID=1000007 AND DateTrx = TRUNC(now()) ;

CREATE OR REPLACE VIEW TF_CashBookReport_V AS

SELECT 
	C_Payment_ID, AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,
	C_BankAccount_ID, NextDateTrx DateTrx, '' DocumentNo,
	'' AccountHead, 'OPENING BALANCE' Description, Receipt, Payment	
FROM 
	TF_CashBookReport_CBal_V a

UNION

SELECT 	
	C_Payment_ID, AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,
	C_BankAccount_ID, DateAcct DateTrx, DocumentNo, AccountHead, Description,
	Receipt, Payment
FROM
	TF_CashBookReport_Trans_V

UNION

SELECT 
	9999998 C_Payment_ID, AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,
	C_BankAccount_ID, NextDateTrx DateTrx,'' DocumentNo,
	'' AccountHead, 'TOTAL' Description, 

	COALESCE(a.Receipt,0) +(SELECT SUM(COALESCE(b.Receipt,0)) FROM TF_CashBookReport_Trans_V b 
	WHERE b.C_BankAccount_ID = a.C_BankAccount_ID AND b.DateAcct = a.NextDateTrx) Receipt, 

	COALESCE(a.Payment,0) +(SELECT SUM(COALESCE(c.Payment,0)) FROM TF_CashBookReport_Trans_V c 
	WHERE c.C_BankAccount_ID = a.C_BankAccount_ID AND c.DateAcct = a.NextDateTrx) 
	Payment
FROM 
	TF_CashBookReport_CBal_V a

UNION

SELECT 
	9999999 C_Payment_ID, AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,
	C_BankAccount_ID, DateTrx,'' DocumentNo,
	'' AccountHead, 'CLOSING BALANCE' Description, Receipt, Payment	
FROM 
	TF_CashBookReport_CBal_V

ORDER BY  3, 9, 10,1